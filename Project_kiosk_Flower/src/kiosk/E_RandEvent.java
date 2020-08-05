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

class E_RandEvent extends Cho
{
	static int ran,count=3; //테스트용
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


	static void randUse() //throws InterruptedException//쿠폰 사용 여부
	{
		CLIO.clearScreen_10();
		System.out.println("===================================================================================");
		System.out.println("   [뽑기 이벤트]                                       「M=둘러보기」「X=전체취소」");
		System.out.println("===================================================================================");
		System.out.println(" ■ 쿠폰 사용시 할인쿠폰 증정! ");
		System.out.println("\n\n");
		System.out.println("\t\t\t【 랜덤 뽑기를 사용하시겠습니까(Y/N)? 】\n\n\n");
		System.out.println("===================================================================================");

		Scanner sc=new Scanner(System.in);
		boolean flag=false;
	      do
	      {
	         try
	         {
		System.out.print(" ▶ 명령을 입력해주세요 : ");
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
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요. ");
	            flag=true;
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


	static void ranUser() //throws InterruptedException//유저 정보
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("===================================================================================");
		System.out.println("   [뽑기 이벤트]                                       「M=둘러보기」「X=전체취소」");
		System.out.println("===================================================================================\n");
		System.out.println(" ▶ 전화번호 입력 : ");
		System.out.println(" ▶ 비밀번호 입력 : ");
		System.out.println("===================================================================================\n");
		CLIO.clearScreen(21);

		do
		{
			try
	         {
			System.out.print(" ▶ 전화번호 입력 : ");
			tel=CLIO.S_input();

			check = checkpho.telCheck2(tel);
		}
			catch (StringIndexOutOfBoundsException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요. ");
	            check=true;
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
			System.out.print(" ▶ 비밀번호 입력 : ");
			pw = CLIO.S_input();
			check = checkpho.pwCheck2(pw, temp);  
		}
			 catch (StringIndexOutOfBoundsException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요. ");
	            check=true;
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
		System.out.println(" ☞ 전화번호가 존재하지 않습니다.");
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
		while (stz.hasMoreTokens()) // 다음 토큰이 있는지 없는지만 확인...
		{
			strArr[n++] = stz.nextToken();   // 토큰의 값을 가져온다
		}

		if (!(strArr[0].equals("010")) && !(strArr[0].equals("011")) && !(strArr[0].equals("016")) && !(strArr[0].equals("017")) && !(strArr[0].equals("019")))
		{
			 System.out.println(" ☞ 유효한 번호를 입력해 주세요");
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
	*/


	static void ranRun(UserInfo temp)//throws InterruptedException //랜덤 출력
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
			//5000원 할인쿠폰 : A, 3000원 할인쿠폰: B, 1000원 할인: C
			couB=(ran>95)?'A':(ran>80)?'B':'C'; 
			ranCou=randcon+couB;
			temp.setPrize(ranCou);
			for(String value : UserInfo.prizeCo)
			{
				System.out.print(value+ " ");
			}

			System.out.println();
			CLIO.clearScreen_10();
			String u= (ran>95)?"5000원 할인쿠폰":(ran>80)?"3000원 할인쿠폰":"1000원 할인쿠폰"; 
			System.out.println("===================================================================================");
			System.out.println("   [뽑기 이벤트]                                       「M=둘러보기」「X=전체취소」");
			System.out.println("===================================================================================");
			System.out.println("\n\n");
			System.out.println("\t\t【 축하합니다! 『"+u+"』에 당첨되셨습니다!! 】");
			temp.c_count--;
			System.out.println("\t\t\t ▶ 현재 "+temp.c_count+"번의 기회가 남았습니다.\n\n");
			System.out.println("\t\t\t ☞ 쿠폰 번호 : "+randcon);
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
			System.out.println("   [뽑기 이벤트]                                       「M=둘러보기」「X=전체취소」");
			System.out.println("===================================================================================");
			System.out.println("\n\n");
			System.out.println("\t\t\t ☞ 쿠폰이 부족합니다.\n\n\n");
			System.out.println("===================================================================================");
			CLIO.clearScreen(23);
			//Thread.sleep(3000);
			//CLIO.clearScreen_10();
		}

		//테스트용
		do
		{
			System.out.print(" ▶ 추가로 쿠폰사용하시겠습니까(Y/N)? : ");
			y=CLIO.S_input();
			randUse();
			System.out.println(ranCou);
		}
		while(y.equals("Y")||y.equals("y"));
	}
}