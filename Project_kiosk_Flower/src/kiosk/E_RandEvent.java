package kiosk;
import java.util.*;
import java.io.*;


class checkpho
{
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

class E_RandEvent extends Cho
{
	static int ran,count=3; //�׽�Ʈ��
	static String randcon;
	static String tel,pw;
	static String y;
	static String ranCou;
	static boolean check=true;
	static boolean check2=false;
	static char[] cou=new char[8];
	static char couB;
	static int couponSize=10;
	static final char[] charcou={'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I','J','K',
						  'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};


	static void randUse() //throws InterruptedException//���� ��� ����
	{
		CLIO.clearScreen_10();
		System.out.println("===================================================================================");
		System.out.println("   [�̱� �̺�Ʈ]                                       ��M=�ѷ����⡹��X=��ü��ҡ�");
		System.out.println("===================================================================================");
		System.out.println(" �� ���� ���� �������� ����! ");
		System.out.println("\n\n");
		System.out.println("\t\t\t�� ���� �̱⸦ ����Ͻðڽ��ϱ�(Y/N)? ��\n\n\n");
		System.out.println("===================================================================================");

		Scanner sc=new Scanner(System.in);
		boolean flag=false;
	      do
	      {
	         try
	         {
		System.out.print(" �� ����� �Է����ּ��� : ");
		CLIO.clearScreen(17);
		y=CLIO.S_input();
		if(y.equals("Y")||y.equals("y"))
		{
			CLIO.clearScreen_10();
			ranUser();
		}
	}
	         catch (StringIndexOutOfBoundsException e)
	         {
	            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");
	            flag=true;
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


	static void ranUser() //throws InterruptedException//���� ����
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("===================================================================================");
		System.out.println("   [�̱� �̺�Ʈ]                                       ��M=�ѷ����⡹��X=��ü��ҡ�");
		System.out.println("===================================================================================\n");
		System.out.println(" �� ��ȭ��ȣ �Է� : ");
		System.out.println(" �� ��й�ȣ �Է� : ");
		System.out.println("===================================================================================\n");
		CLIO.clearScreen(21);

		do
		{
			try
	         {
			System.out.print(" �� ��ȭ��ȣ �Է� : ");
			tel=CLIO.S_input();

			check = checkpho.telCheck2(tel);
		}
			catch (StringIndexOutOfBoundsException e)
	         {
	            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");
	            check=true;
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
			System.out.print(" �� ��й�ȣ �Է� : ");
			pw = CLIO.S_input();
			check = checkpho.pwCheck2(pw, temp);  
		}
			 catch (StringIndexOutOfBoundsException e)
	         {
	            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");
	            check=true;
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

		temp.setCus_pw(pw); 
		System.out.println("\n\n");
		System.out.println("===================================================================================");
		// if(check == false)
		ranRun(temp);
	}
/*
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
			 System.out.println(" �� ��ȿ�� ��ȣ�� �Է��� �ּ���");
			 return true;
		}
		return false;
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
	*/


	static void ranRun(UserInfo temp)//throws InterruptedException //���� ���
	{
		Scanner sc=new Scanner(System.in);
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		if(temp.c_count>=1)
		{
			for (int i = 0; i < 8; i++) 
			cou[i] = charcou[rand.nextInt(charcou.length)];   
			randcon = new String(cou);


			ran=rand.nextInt(100)+1;
			//5000�� �������� : A, 3000�� ��������: B, 1000�� ����: C
			couB=(ran>95)?'A':(ran>80)?'B':'C'; 
			ranCou=randcon+couB;
			temp.setPrize(ranCou);
			for(String value : UserInfo.prizeCo)
			{
				System.out.print(value+ " ");
			}

			System.out.println();
			CLIO.clearScreen_10();
			String u= (ran>95)?"5000�� ��������":(ran>80)?"3000�� ��������":"1000�� ��������"; 
			System.out.println("===================================================================================");
			System.out.println("   [�̱� �̺�Ʈ]                                       ��M=�ѷ����⡹��X=��ü��ҡ�");
			System.out.println("===================================================================================");
			System.out.println("\n\n");
			System.out.println("\t\t�� �����մϴ�! ��"+u+"���� ��÷�Ǽ̽��ϴ�!! ��");
			temp.c_count--;
			System.out.println("\t\t\t �� ���� "+temp.c_count+"���� ��ȸ�� ���ҽ��ϴ�.\n\n");
			System.out.println("\t\t\t �� ���� ��ȣ : "+randcon);
			System.out.println();
			System.out.println();
			System.out.println("===================================================================================");
			CLIO.clearScreen(19);
			//Thread.sleep(3000);
			//CLIO.clearScreen_10();
		}
		else
		{
			CLIO.clearScreen_10();
			System.out.println("===================================================================================");
			System.out.println("   [�̱� �̺�Ʈ]                                       ��M=�ѷ����⡹��X=��ü��ҡ�");
			System.out.println("===================================================================================");
			System.out.println("\n\n");
			System.out.println("\t\t\t �� ������ �����մϴ�.\n\n\n");
			System.out.println("===================================================================================");
			CLIO.clearScreen(23);
			//Thread.sleep(3000);
			//CLIO.clearScreen_10();
		}

		//�׽�Ʈ��
		do
		{
			System.out.print(" �� �߰��� ��������Ͻðڽ��ϱ�(Y/N)? : ");
			y=CLIO.S_input();
			randUse();
			System.out.println(ranCou);
		}
		while(y.equals("Y")||y.equals("y"));
	}
}