package kiosk;
import java.util.*;
import java.io.*;

class A_Main
{

	static void cus_maindisp()
	{
		Staff.stf_CheckExp();
		System.out.println("=============================================================");
		System.out.println("                        [SMART FLOWER]                       ");
		System.out.println("=============================================================");
		System.out.println();
		System.out.println(" 1. ♥ DIY 꽃다발 ♥");
		System.out.println("    : 원하는 대로 골라 만든 나만의 꽃다발로 마음을 전하세요.");
		System.out.println();
		System.out.println(" 2. ♥ 추천 꽃다발 ♥");
		System.out.println("    : 가까운 기념일, 소중한 사람을 위한 꽃다발을 준비하세요.");
		System.out.println();
		System.out.println(" 3. ♥ 랜덤 꽃다발 ♥");
		System.out.println("    : 활기가 필요할 때, 부담없이 가볍게 꽃다발을 만나보세요.");
		System.out.println();
		System.out.println(" 4. ♥ 뽑기 이벤트 ♥");
		System.out.println("    : 쿠폰 찬스 사용하시고, 선물을 확인하세요.");
		System.out.println("    → 5만원 이상 구매시 쿠폰 증정!");
		System.out.println();
		System.out.println(" 0. 관리자 Page");
		System.out.println("    : 자판기 관리자만 접근할 수 있습니다.");
		System.out.println();
		System.out.println("=============================================================");

		if (FlowerKiosk.count > 2)
		{
			CLIO.clearScreen(8);
		}

	}
	
	static void cus_maininput()
	{	
		boolean flag=false;
		Staff stf_ob = new Staff();

		do
		{
			try
			{
				Scanner sc = new Scanner(System.in);
				System.out.print(" ▶ 어떤 메뉴로 들어가시겠습니까? (숫자 입력) : ");

				int sel = CLIO.input();

				switch(sel)
				{
					case 1 :
						CLIO.clearScreen_10();
						B_DIYFlower.printDIYMenu();
						// B_DIYFlower.mainFlower();
						// B_DIYFlower.subFlower();
						break;

					case 2 :
						CLIO.clearScreen_10();
						C_FlowerUser ob=new C_FlowerUser();
						ob.offer();
						break;

					case 3 : 
						CLIO.clearScreen_10();
						D_RandomFlower.randomFlower_O();
						D_RandomFlower.randomFlower_I();
						break;
					
					case 4 :
						CLIO.clearScreen_10();
						E_RandEvent.randUse();

					case 0 :
						 stf_ob.stf_login();
						CLIO.clearScreen_10();
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
}