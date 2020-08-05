package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

public class I_CardPay
{
   static long cardNum;         // 정수형 카드번호 16자리
   static String inputNum;         // 문자열형으로 입력받은 카드번호
   static String[] card;         // 카드번호 각 자리수를 추출해 나누어 담을 배열
   static int[] even=new int[8];   // 짝수 각 숫자로 이루어진 배열
   static int[] odd=new int[7];   // 홀수 각 숫자로 이루어진 배열

   // 카드결제 기본화면 출력+자리수 체크 메소드
   public static void checkDigit()
   {
      inputNum=null;                                                   // 입력받을 문자열형 변수 초기화

      // 카드결제 기본화면 출력
      System.out.println("===================================================================");
      System.out.println("  [ 카드결제 ]                         「M=둘러보기」「X=전체취소」");
      System.out.println("===================================================================");
      System.out.println();
      Scanner sc=new Scanner(System.in);
      boolean flag=false;                                                // 재입력 안내를 위한 제어변수 초기화

      do
      {
         try
         {
            System.out.print(" ▶ 카드번호 16자리를 입력해주세요(-제외) : ");         // 카드번호 16자리 입력 안내
			CLIO.clearScreen(24);
            inputNum=CLIO.S_input();                                       // 입력받은 값을 문자열형으로 저장
            card=new String[16];                                          // 입력받은 값을 각각 나누어담을 16개 방의 배열 생성
         
            for (int i=0; i<card.length; i++)                                 // 16개 방마다
            {
               card[i]=inputNum.substring(i, i+1);                              // 문자열 i번째 추출해서 저장
               //System.out.println(card[i]);                                 // 각 문자 저장 확인 완료!
            }
            flag=false;
            
            if (checkAA()==0)
            {
               // System.out.format(" ☞ %,d원이 결제됩니다.", Money.userCash);         // 총결제액 안내         // ★★ 적립금 빠진 금액을 써야함(장바구니가 아니라 주문화면에서 적립금사용 체크후 총결제금액)
               // System.out.println();
               PurComplete.purComplete_Card();
            }
            else if (checkAA()==1)
            {
               System.out.println(" ☞ 카드가 유효하지 않습니다. 다시 입력해주세요.");   // 비유효 안내
			   CLIO.clearScreen(4);
               flag=true;                                                // 재입력 처리
            }
            // 타당한 카드번호 테스트 : 4388576018410707, 5365101012180349
            // 타당하지 않은 카드번호 테스트 : 4388576018402626

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
      while (flag);                                                      // 반복문 제어 변수가 false 상태인 한 do 수행하도록 처리
   }

   
   // 자리수 일치할 경우 유효성 검사 메소드
   private static int checkAA()
   {
      int evensum=0;                        // 짝수합 초기화
      int oddsum=0;                        // 홀수합 초기화
      int code=Integer.parseInt(card[15]);      // 검증코드(맨 마지막 숫자) 초기화

      for (int i=card.length-3; i>=0; i=i-2)      // 인덱스 13 11 9 7 5 3 1 → 맨 마지막 숫자를 제외한 짝수자리
      {
         int j=0;                        // 두번째 루프변수 초기화
         even[j] = Integer.parseInt(card[i]);   // card배열의 짝수자리번째 데이터를 int형으로 변환하여 짝수배열의 j번째 방에 저장
         
         if (even[j]>=10)                  // 짝수자리수의 숫자가 10 이상이라면
            evensum += even[j]%10 + even[j]/10;   // 짝수합에 10으로 나눈 몫과 10으로 나눈 나머지의 합만큼 더해주기.....18%10=8 , 18/10=1 > 8+1=9
         else                           // 짝수자리수의 숫자가 10 미만이라면
            evensum += even[j];               // 숫자 그대로 짝수합에 더해주기
         j++;                           // 두번째 루프변수 증감처리
         //System.out.println(evensum);         // 짝수합 확인 완료!
      }

      for (int i=card.length-2; i>=0; i=i-2)      // 인덱스 14 12 10 8 6 4 2 0 → 홀수자리
      {
         int j=0;                        // 두번째 루프변수 초기화
         odd[j] = Integer.parseInt(card[i]);      // card배열의 홀수자리번째 데이터를 int형으로 변환하여 홀수배열의 j번째 방에 저장
         odd[j]*=2;                        // 홀수배열 j번째 방 데이터마다 2씩 곱한 값 저장

         if (odd[j]>=10)                     // 홀수자리수의 숫자가 10 이상이라면
            oddsum += odd[j]%10 + odd[j]/10;   // 홀수합에 10으로 나눈 몫과 10으로 나눈 나머지의 합만큼 더해주기.....18%10=8 , 18/10=1 > 8+1=9
         else                           // 홀수자리수의 숫자가 10 미만이라면
            oddsum += odd[j];               // 숫자 그대로 홀수합에 더해주기
         j++;                           // 두번째 루프변수 증감처리
         //System.out.println(oddsum);         // 홀수합 확인 완료!
      }
      
      int compCode = 10-((evensum+oddsum)%10);   // 10에서 짝수합+홀수합을 10으로 나눈 나머지(1의 자리 수)를 뺀 숫자를 변수에 저장
      if (compCode==code)                     // 변수가 검증 코드와 일치한다면
         return 0;                        // 0=유효 반환
      else                              // 이외의 경우
         return 1;                        // 1=비유효 반환
   }


   // 뽑기이벤트 안내 메소드
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
            
          System.out.println("12345678");
           UserInfo temp = Cho.ui.get(tel);
           System.out.println("12345678");
           
           do
           {
             System.out.print(" ▶ 비밀번호 입력 : ");
             pw = CLIO.S_input();
             check = checkpho.pwCheck2(pw, temp);
             System.out.println("12345678");
           }
           while (check == true);
           temp.c_count +=1;                              // 해당 유저 카운트 1회 추가
           System.out.println(temp.c_count);
           A_Main.cus_maindisp();
           
           
          
           

         }else{

            A_Main.cus_maindisp();

         }      
         
           
        
        
         // ★★ 현금결제 구매완료화면 메소드();
      }
      else if (Money.userCash<50000)         // 총결제액이 50000원 이상인 경우 마무리
      {
         System.out.println("===================================================================");
         CLIO.clearScreen_10();
         // ★★ 현금결제 구매완료화면 메소드();
      }
   
   }

}




/*
      boolean flag=false;
      do
      {
         System.out.print(" ▶ 카드번호를 입력해주세요(-포함) : ");
         String inputNum=sc.next();   // 입력받는 카드번호(문자열)

         for (int i=0; i<inputNum.length(); i++)      // 문자열로 입력된 값을 각각 배열에 넣어줌
         {
            if (inputNum.length()>=13+3 || inputNum.length()<=16+3)
            {
               String[] temp=new String[inputNum.length()];
               int[] cardNum=new int[inputNum.length()];
            }
            temp[i]=inputNum.substring(i, i+1);
         }

         for (int i=0; i<inputNum.length(); i++)      // 문자열 배열의 값을 각각 정수형으로 변환해줌
         {
            if(temp[i]=="-")
               continue;
            cardNum[i]=Integer.parseInt(temp[i]);
         }

         if (inputNum.length()<13+3 || inputNum.length()>16+3)
         {
            System.out.println("다시 입력해주세요.");
            flag=true;
         }
      }
      while (flag);
*/   