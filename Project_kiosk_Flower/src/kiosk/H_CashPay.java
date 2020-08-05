package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

public class H_CashPay
{
   static int change;         // 거스름돈
   static int calResult;      // 거스름돈 총액 저장 변수
   static int inputCash;      // 투입액수
   static int[] share;         // 몫 배열
   static Scanner sc=new Scanner(System.in);

   // 현금결제 기본화면 출력+가능여부 체크 메소드
   public static void checkcal()
   {
	  change = 0;
	  calResult = 0;
	  inputCash = 0;
	  
	   // 현금결제 기본화면 출력
      System.out.println("===================================================================");
      System.out.println("  [ 현금결제 ]                         「M=둘러보기」「X=전체취소」");
      System.out.println("===================================================================");
      System.out.printf("결제금액은 %d 원입니다.%n", Money.userCash);
      System.out.println("===================================================================");
      System.out.println();

      boolean flag=false;                           // 반복문 제어 변수 설정
      
      // 현금결제 가능여부 체크
      do
      {
         try
         {
            if (Money.exc_tot<50000 && Money.exc_1000<10)         // 보유잔고가 50000원 미만이면서, 1000원 권이 10장 미만일 때 현금결제 불가능
            {
               System.out.print(" ▶ 보유잔고가 부족하여 카드 결제만 가능합니다. (카드결제 C 입력) : ");   // 현금결제 불가능할 경우 선택지 출력
               String choice=CLIO.S_input();                                                         // 선택 입력받기
               
               do
               {
                  try
                  {
                     if (choice.equals("J"))                                                               // J 입력시 적립금 적립 메소드 실행
                     {
                        System.out.println();
                        calChange();
                        calResult();
                     }
                     else if (choice.equals("C"))                                                         // C 입력시 카드결제 메소드 실행
                     {
                        System.out.println();
                        I_CardPay.checkDigit();
                        I_CardPay.eventMsg();
                     }
                  }
                  catch (NumberFormatException e)
                  {
                     System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                     flag=true;
                  }
                  catch (IndexOutOfBoundsException e)
                  {
                     System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                     flag=true;
                  }
               }
               while (flag);
            }
            else if (Money.exc_tot>=50000 && Money.exc_1000>=10)   // 보유잔고가 50000원 이상이면서, 1000원 권이 10장 이상일 때 현금결제 가능
            {
               do
               {
                  try
                  {
                     System.out.print(" ▶ 현금을 투입해주세요(숫자 입력) : ");                                 // 현금 투입 안내메세지 출력
					 CLIO.clearScreen(23);
                     inputCash=CLIO.input();                                                            // 투입액 입력받기
         
                     if (inputCash<Money.userCash)               // 총 결제금액 미만으로 입력했을 경우 불가능
                     {
                        System.out.println(" ☞ 다시 입력해주세요.");   // 재입력 안내
                        flag=true;                              // 재입력 처리
                     }
                     else if (inputCash>=Money.userCash)            // 총 결제금액 이상으로 입력했을 경우 가능
                     {
                        H_CashPay.calChange();                  // 거스름돈 연산 메소드
                        H_CashPay.calResult();                  // 연산결과 안내 메소드
                       // PurComplete.purComplete_Cash();
                     }
                  }
                  catch (NumberFormatException e)
                  {
                     System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                     flag=true;
                  }
                  catch (IndexOutOfBoundsException e)
                  {
                     System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                     flag=true;
                  }
               }
               while (flag);                              // 반복문 제어 변수가 false 상태인 한 do 수행하도록 처리
            }
         }
         catch (NumberFormatException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            flag=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            flag=true;
         }
      }
      while (flag);
   }

   // 현금결제 가능시 : 거스름돈 연산 메소드
   public static void calChange()
   {   
      // 거스름돈 총액 연산
      int[] div={1000, 5000, 10000};               // 나눌 액수 배열에 값 저장
      share=new int[3];                        // 몫 배열 방 생성
      change=inputCash-Money.userCash;            // 거스름돈 총액 = 투입액 - 총결제금액 → 1000원 총액에 68000원 투입했다고 하면.. 거스름돈은 67000원
   
      for (int i=div.length-1; i>=0; i--)            // 큰 액수부터 나누기 반복
      {                                    // 67000원을 10000으로 나눴을때 몫6, 나머지 7000 > 5000으로 나눴을때 몫1, 나머지 2000 > 1000으로 나눴을때 몫2, 나머지0
         share[i] = change/div[i];               // 몫 배열방마다 몫값 저장
         //System.out.println(share[i]);            // 몫 확인 완료! (6/1/2)
         change -= div[i]*share[i];               // 다음 몫값 연산을 위해 몫 저장 이후마다 거스름돈 총액에서 나누는 금액*몫 만큼 빼줌..... 67000-60000 / 7000-5000 / 2000-2000 (거스름돈=나머지값)
      }

      for (int i=div.length-1; i>=0; i--)
      {
         if (share[i]>0)                        // 나누었을 때 몫이 0이상이라면
            calResult += change+div[i]*share[i];   // 임시변수에 나머지값과 나눈금액*몫 만큼 더해줌 (변해버린 거스름돈 총액-change- 원복을 위한 역연산)
         //System.out.println(calResult);         // 거스름돈 확인 완료! (60000/65000/67000)
      }
   }

   // 보유잔고 차감 처리 메소드
   private static void calBalance()
   {
         // 보유잔고 n원 권에서 몫만큼 개수 차감 처리 → 남은 10000원권 개수에서 6개 차감, 남은 5000원권 개수에서 1개 차감, 남은 1000원권 개수에서 2개 차감
         Money.exc_10000 -= share[2];
         //System.out.println(Money.exc_10000);      // 10000원권 차감 확인 완료!
         Money.exc_5000 -= share[1];
         //System.out.println(Money.exc_5000);      // 5000원권 차감 확인 완료!
         Money.exc_1000 -= share[0];
         //System.out.println(Money.exc_1000);      // 1000원권 차감 확인 완료!
   }
   

   // 현금결제 가능시 : 연산결과 안내 메소드
   public static void calResult()
   {
      if (calResult>Money.exc_tot)               // 거스름돈이 보유잔고 초과일 경우 반환 불가
      {
         boolean flag=false;
         do
         {
            try
            {
               System.out.print(" ▶ 보유잔고가 부족하여 거스름돈 반환이 불가합니다. (적립 J, 카드결제 C 입력) : ");   // 거스름돈 반환 불가능할 경우 선택지 출력
               String choice=CLIO.S_input();                                                         // 선택 입력받기
               
               if (choice.equals("J"))                                                               // J 입력시 적립금 적립 메소드 실행
               {
                  System.out.println();
                  J_CashPoint.earnRewards_O();
                  J_CashPoint.earnRewards_I();
                  System.out.println();
               }
               else if (choice.equals("C"))                                                         // C 입력시 카드결제 메소드 실행
               {
                  System.out.println();
                  I_CardPay.checkDigit();
                  I_CardPay.eventMsg();
               }
            }
            catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
            {
               System.out.println(" ☞ 자리수가 맞지 않습니다. 다시 입력해주세요. ");      // 재입력 안내
               flag=true;                                                   // 재입력 처리
            }
            catch (NumberFormatException e)
            {
               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
               flag=true;
            }
            catch (IndexOutOfBoundsException e)
            {
               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
               flag=true;
            }
         }
         while (flag);
      }
      else if (calResult>0 && calResult<=Money.exc_tot)   // 거스름돈이 보유잔고 이하일 경우 반환 가능
      {
         boolean flag=false;
         do
         {
            try
            {
               System.out.format(" ☞ 거스름돈은 %d원입니다.\n", calResult);                                 // 거스름돈 총액 안내
               System.out.print(" ▶ 적립하시려면 J, 반환하시려면 B 를 입력해주세요. : ");                        // 거스름돈 반환 가능할 경우 선택지 출력
               String choice2=CLIO.S_input();                                                         // 선택 입력받기
               
               if (choice2.equals("J") || choice2.equals("j") )                                                            // J 입력시 적립금 적립 메소드 실행
               {
                  System.out.println();
				  CLIO.clearScreen_10();
                  J_CashPoint.earnRewards_O();
                  J_CashPoint.earnRewards_I();
                  System.out.println();
               }
               else if (choice2.equals("B") || choice2.equals("b"))                                                         // B 입력시 거스름돈 반환액 안내 및 보유잔고 차감 처리
               {
                  System.out.format(" ☞ 결제완료 후 거스름돈 %,d원이 반환됩니다.\n", calResult);
                  calBalance();
               }
            }
            catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
            {
               System.out.println(" ☞ 자리수가 맞지 않습니다. 다시 입력해주세요. ");      // 재입력 안내
               flag=true;                                                   // 재입력 처리
            }
            catch (NumberFormatException e)
            {
               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
               flag=true;
            }
            catch (IndexOutOfBoundsException e)
            {
               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
               flag=true;
            }
         }
         while (flag);
      }
   }
   
   // 뽑기이벤트 안내 메소드
   public static void eventMsg()
   {
      if (Money.userCash>=50000)            // 총결제액이 50000원 이상인 경우               // ★★ 적립금 빠진 금액을 써야함(장바구니가 아니라 주문화면에서 적립금사용 체크후 총결제금액)
      {
         String y,tel,pw;

         System.out.println(" ★ 뽑기이벤트 찬스가 1회 생겼습니다. ★");
         System.out.println(" 쿠폰을 받으시겠습니까? (y/n) :");
         y=CLIO.S_input();
         boolean check =true;
         

          if(y.equals("y")||y.equals("Y"))
         {   

            do
           {
             System.out.print(" ▶ 전화번호 입력 : ");
             tel = CLIO.S_input();
             check = checkpho.telCheck(tel);
             
           }
           while (check == true);
            
           UserInfo temp = Cho.ui.get(tel);
           
           do
           {
             System.out.print(" ▶ 비밀번호 입력 : ");
             pw = CLIO.S_input();
             check = checkpho.pwCheck2(pw, temp);
           }
           while (check == true);
           temp.c_count +=1;                              // 해당 유저 카운트 1회 추가
           System.out.println(temp.c_count);
           
           PurComplete.purComplete_Cash();
           

         }else{

           PurComplete.purComplete_Cash();

         }      
         
           
         System.out.println();
         CLIO.clearScreen_10();
         // ★★ 현금결제 구매완료화면 메소드();
      }
      else if (Money.userCash<50000)         // 총결제액이 50000원 이상인 경우 마무리
      {
		  PurComplete.purComplete_Cash();
      }
   }
}
