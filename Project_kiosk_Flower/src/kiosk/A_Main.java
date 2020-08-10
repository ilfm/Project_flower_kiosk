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
		System.out.println(" 1. �� DIY �ɴٹ� ��");
		System.out.println("    : ���ϴ� ��� ��� ���� ������ �ɴٹ߷� ������ ���ϼ���.");
		System.out.println();
		System.out.println(" 2. �� ��õ �ɴٹ� ��");
		System.out.println("    : ����� �����, ������ ����� ���� �ɴٹ��� �غ��ϼ���.");
		System.out.println();
		System.out.println(" 3. �� ���� �ɴٹ� ��");
		System.out.println("    : Ȱ�Ⱑ �ʿ��� ��, �δ���� ������ �ɴٹ��� ����������.");
		System.out.println();
		System.out.println(" 4. �� �̱� �̺�Ʈ ��");
		System.out.println("    : ���� ���� ����Ͻð�, ������ Ȯ���ϼ���.");
		System.out.println("    �� 5���� �̻� ���Ž� ���� ����!");
		System.out.println();
		System.out.println(" 0. ������ Page");
		System.out.println("    : ���Ǳ� �����ڸ� ������ �� �ֽ��ϴ�.");
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
				System.out.print(" �� � �޴��� ���ðڽ��ϱ�? (���� �Է�) : ");

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
}