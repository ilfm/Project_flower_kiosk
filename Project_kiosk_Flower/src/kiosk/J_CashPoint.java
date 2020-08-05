package kiosk;
import java.util.*;
import java.io.*;

public class J_CashPoint
{
   static void earnRewards_O()
   {
      System.out.println("=============================================================");
      System.out.println("   [적립금 적립]                 「M=둘러보기」「X=전체취소」");
      System.out.println("=============================================================");
      System.out.println("  ▶ 남은 금액을 적립하시겠습니까(Y/N)? : ");
      System.out.println("     → 단, 적립시 전화번호와 비밀번호가 필요합니다.");
      System.out.println("=============================================================");
	  CLIO.clearScreen(22);
   }

   static void earnRewards_O2()
   {
      boolean check = true;
      boolean check2 = false;
      String tel = null;
      String pw = null;
      int money = 0;

      Scanner sc = new Scanner(System.in);
      CLIO.clearScreen_10();
      System.out.println("=============================================================");
      System.out.println("   [적립금 적립]                 「M=둘러보기」「X=전체취소」");
      System.out.println("=============================================================");
	  System.out.println(" ▶ 전화번호 입력 : ");
	  System.out.println(" ▶ 비밀번호 입력 : ");
	  CLIO.clearScreen(26);
      do
      {
         try
         {
            System.out.println(" ▶ 전화번호 입력 : ");
            tel = CLIO.S_input();
            check = telCheck(tel);
         }
         catch (NumberFormatException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            check=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            check=true;
         }
      }
      while (check == true);
      
      UserInfo temp = Cho.ui.get(tel);

      do
      {
         try
         {
            System.out.println(" ▶ 비밀번호 입력 : ");
            pw = CLIO.S_input();
            check2 = pwCheck(pw, temp);
         }
         catch (NumberFormatException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            check2=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            check2=true;
         }
      }
      while (check2 == true);
      
      earnRewards_rewards(H_CashPay.calResult, temp);
      
      // System.out.println(temp.cus_pw);
      // System.out.println(temp.cus_pw);
      // String pw = sc.next();
 
   }

   static void earnRewards_I()
   {
      Scanner sc = new Scanner(System.in);
      boolean flag=false;
      do
      {
         try
         {
            String sel = CLIO.S_input();
            if (sel.equals("Y") || sel.equals("y"))
            {
               earnRewards_O2();   
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

   static void useRewards_O()
   {
      Scanner sc = new Scanner(System.in);
      String tel, pw;
      boolean check = true;
      boolean check2 = true;
      
      System.out.println("=============================================================");
      System.out.println("   [적립금 사용]                 「M=둘러보기」「X=전체취소」");
      System.out.println("=============================================================");
	  System.out.print(" ▶ 전화번호 입력 : ");
	  System.out.print(" ▶ 비밀번호 입력 : ");
	  CLIO.clearScreen(18);

      do
      {
         System.out.print(" ▶ 전화번호 입력 : ");
         tel = CLIO.S_input();
         check = telCheck2(tel);
      }
      while (check == true);

      UserInfo temp = Cho.ui.get(tel);

      do
      {
         System.out.print(" ▶ 비밀번호 입력 : ");
         pw = CLIO.S_input();
         check = pwCheck2(pw, temp);
      }
      while (check == true);
      
      useRewards_O2(temp);

      System.out.println("=============================================================");
      CLIO.clearScreen_10();
   }
   
   static void useRewards_O2(UserInfo temp)
   {
	   int money;
	   boolean check = true;
	   do
	   {
		   System.out.printf("▶ 현재 사용 가능한 적립금은 %d원 입니다.%n 얼마를 사용하시겠습니까?%n", temp.getMoney());
		   System.out.printf("☞ 사용할 금액 입력 : ");
		   money = CLIO.input();
		   if(money > temp.getMoney())
		   {
			   System.out.println("적립금이 부족합니다. 다시 입력해주세요.");
		   }
		   else
		   {
			   temp.setMoney(temp.getMoney() - money);
			   Money.userCash -= money;
			   System.out.printf("적립금 %d원이 사용되었습니다. 남은 적립금은 %d원 입니다.", money, temp.money);
			   check = false;
		   }
	   }while(check);
	   
   }
   
   static void earnRewards_rewards(int money, UserInfo temp)
   {
	   temp.setMoney(temp.getMoney() + money);
	  System.out.println("=============================================================");
      System.out.println("   [적립금 적립]                 「M=둘러보기」「X=전체취소」");
      System.out.println("=============================================================");
      System.out.printf("적립금 %d원이 적립되었습니다. 총 적립금은 %d원 입니다.", money, temp.getMoney());
      System.out.println("=============================================================");

   }

   static boolean telCheck(String tel)
   {
      String data = tel;
      String strArr[];
      int n;

      StringTokenizer stz = new StringTokenizer(tel, "-");
      strArr = new String[stz.countTokens()];
      
      n=0;
      while (stz.hasMoreTokens()) // 다음 토큰이 있는지 없는지만 확인...
      {
         strArr[n++] = stz.nextToken();   // 토큰의 값을 가져온다
      }

      if (!(strArr[0].equals("010")) && !(strArr[0].equals("011")) && !(strArr[0].equals("016")) && !(strArr[0].equals("017")) && !(strArr[0].equals("019")))
      {
         System.out.println(" ☞ 유효한 번호를 입력해 주세요.");
         return true;
      }
      
      if (!(Cho.ui.containsKey(data)))
      {
         Cho.ui.put(data, new UserInfo());
         String password;
         System.out.printf("%s 로 새로운 회원 아이디가 생성되었습니다.%n", data);
         System.out.printf("비밀번호를 설정해 주세요 : ");
         password = CLIO.S_input();
         Cho.ui.get(data).setCus_pw(password);
      }

      return false;
   }

   static boolean telCheck2(String tel)
   {
      if (Cho.ui.containsKey(tel))
         return false;
      else
      {
         System.out.println(" ☞ 전화번호가 존재하지 않습니다.");
         return true;
      }
   }

   static boolean pwCheck2(String pw, UserInfo temp)
   {
      if (pw.equals(temp.cus_pw))
      {
         return false;
      }
      else
      {
         System.out.println(" ☞ 비밀번호를 다시 입력해 주세요.");
         return true;
      }
   }

   static boolean pwCheck(String pw, UserInfo temp)
   {
      if (temp.cus_pw == null)
      {
         temp.cus_pw = pw;
         return false;
      }
      else
      {
         if (pw.equals(temp.cus_pw))
         {
            return false;
         }
         else
         {
            System.out.println(" ☞ 비밀번호를 다시 입력해 주세요.");
            return true;
         }
      }
   }
}