package kiosk;
import java.util.*;
import java.io.*;

public class J_CashPoint
{
   static void earnRewards_O()
   {
      System.out.println("=============================================================");
      System.out.println("   [������ ����]                 ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("=============================================================");
      System.out.println("  �� ���� �ݾ��� �����Ͻðڽ��ϱ�(Y/N)? : ");
      System.out.println("     �� ��, ������ ��ȭ��ȣ�� ��й�ȣ�� �ʿ��մϴ�.");
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
      System.out.println("   [������ ����]                 ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("=============================================================");
	  System.out.println(" �� ��ȭ��ȣ �Է� : ");
	  System.out.println(" �� ��й�ȣ �Է� : ");
	  CLIO.clearScreen(26);
      do
      {
         try
         {
            System.out.println(" �� ��ȭ��ȣ �Է� : ");
            tel = CLIO.S_input();
            check = telCheck(tel);
         }
         catch (NumberFormatException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            check=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            check=true;
         }
      }
      while (check == true);
      
      UserInfo temp = Cho.ui.get(tel);

      do
      {
         try
         {
            System.out.println(" �� ��й�ȣ �Է� : ");
            pw = CLIO.S_input();
            check2 = pwCheck(pw, temp);
         }
         catch (NumberFormatException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            check2=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
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
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            flag=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
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
      System.out.println("   [������ ���]                 ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("=============================================================");
	  System.out.print(" �� ��ȭ��ȣ �Է� : ");
	  System.out.print(" �� ��й�ȣ �Է� : ");
	  CLIO.clearScreen(18);

      do
      {
         System.out.print(" �� ��ȭ��ȣ �Է� : ");
         tel = CLIO.S_input();
         check = telCheck2(tel);
      }
      while (check == true);

      UserInfo temp = Cho.ui.get(tel);

      do
      {
         System.out.print(" �� ��й�ȣ �Է� : ");
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
		   System.out.printf("�� ���� ��� ������ �������� %d�� �Դϴ�.%n �󸶸� ����Ͻðڽ��ϱ�?%n", temp.getMoney());
		   System.out.printf("�� ����� �ݾ� �Է� : ");
		   money = CLIO.input();
		   if(money > temp.getMoney())
		   {
			   System.out.println("�������� �����մϴ�. �ٽ� �Է����ּ���.");
		   }
		   else
		   {
			   temp.setMoney(temp.getMoney() - money);
			   Money.userCash -= money;
			   System.out.printf("������ %d���� ���Ǿ����ϴ�. ���� �������� %d�� �Դϴ�.", money, temp.money);
			   check = false;
		   }
	   }while(check);
	   
   }
   
   static void earnRewards_rewards(int money, UserInfo temp)
   {
	   temp.setMoney(temp.getMoney() + money);
	  System.out.println("=============================================================");
      System.out.println("   [������ ����]                 ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("=============================================================");
      System.out.printf("������ %d���� �����Ǿ����ϴ�. �� �������� %d�� �Դϴ�.", money, temp.getMoney());
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
      while (stz.hasMoreTokens()) // ���� ��ū�� �ִ��� �������� Ȯ��...
      {
         strArr[n++] = stz.nextToken();   // ��ū�� ���� �����´�
      }

      if (!(strArr[0].equals("010")) && !(strArr[0].equals("011")) && !(strArr[0].equals("016")) && !(strArr[0].equals("017")) && !(strArr[0].equals("019")))
      {
         System.out.println(" �� ��ȿ�� ��ȣ�� �Է��� �ּ���.");
         return true;
      }
      
      if (!(Cho.ui.containsKey(data)))
      {
         Cho.ui.put(data, new UserInfo());
         String password;
         System.out.printf("%s �� ���ο� ȸ�� ���̵� �����Ǿ����ϴ�.%n", data);
         System.out.printf("��й�ȣ�� ������ �ּ��� : ");
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
         System.out.println(" �� ��ȭ��ȣ�� �������� �ʽ��ϴ�.");
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
         System.out.println(" �� ��й�ȣ�� �ٽ� �Է��� �ּ���.");
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
            System.out.println(" �� ��й�ȣ�� �ٽ� �Է��� �ּ���.");
            return true;
         }
      }
   }
}