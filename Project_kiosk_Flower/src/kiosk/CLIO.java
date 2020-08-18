package kiosk;
import java.util.*;
import java.io.*;

class CLIO	//CLearscreenInputObject
{
	static void clearScreen_100()
	{
		for (int i=0; i<50; i++)
		{
			System.out.println();
		}
	}

	static void clearScreen_10()
	{
		for (int i=0; i<50; i++)
		{
			System.out.println();
		}
	}

	static void clearScreen_Cart_2()
	{
		for (int i=0; i<19; i++)
		{
			System.out.println();
		}
	}

	static void clearScreen(int i)
	{
		for (int j=1; j<=i; j++)
		{
			System.out.println();
		}
	}

	// �Է� �޼ҵ� 
	public static int input()	//��M = �ѷ����� (����ȭ������ )�� / ��X = �����ϱ⡹
	{
		Scanner sc = new Scanner(System.in);
		String select = sc.next();
		
		// M �Է½� ��ٱ��Ͽ� ��� ��ǰ�� ������ ���·� �������� ���ư���.
		if(select.equals("M")  || select.equals("m"))
		{
			// MainException ���� �߻�
			throw new MainException();
		}
		else if(select.equals("X")  || select.equals("x")) 
		{
			// X �Է� �� ��ٱ��Ͽ� �ִ� �͵��� ��� ����ϰ� �������� ���ư��� �Ѵ�.
			// fl_cl �� ������ fl�� �ʱ�ȭ �Ѵ�.
			Cho.fl_cl = Cho.boksa(Cho.fl);
			
			// fl_tot_cl �� ������ fl_tot�� �ʱ�ȭ �Ѵ�.
			Cho.fl_tot_cl = Cho.boksa_tot(Cho.tot);
			int a = FlowerKiosk.CartDB_list.size();
			
			// ��ٱ��Ͽ� �ִ� ��� ������ ���� �Ѵ�.
			for(int i=a-1;i>=0;i--) 				
				FlowerKiosk.CartDB_list.remove(i);
					
			// �߰� ���� ��ǰ �ʱ�ȭ 
			// DB�� �ִ� �޼��� ī�� ������ ���Ѵ�
			int v = Cho.adp_ob.getMsg();
			// DB ī�� ���� = (������ �ֹ��� ī���� ���� + DB�� ���� �ִ� ī�� ����)
			Cho.adp_ob.setMsg(v += G_UserOrder.adp_tot[0]);
			
			// DB�� �ִ� �ٱ��� ������ ���Ѵ�
			v = Cho.adp_ob.getBasket();
			// DB �ٱ��� ���� = (������ �ֹ��� �ٱ����� ���� + DB�� ���� �ִ� �ٱ��� ����)
			Cho.adp_ob.setBasket(v += G_UserOrder.adp_tot[1]);
			
			// DB�� �ִ� ������ ������ ���Ѵ�
			v = Cho.adp_ob.getPaper();
			// DB ������ ���� = (������ �ֹ��� �ٱ����� ���� + DB�� ���� �ִ� ������ ����)
			Cho.adp_ob.setPaper(v += G_UserOrder.adp_tot[2]);
			
			// DB�� �ִ� ������ ������ ���Ѵ�.
			v = Cho.adp_ob.getRibbon();
			// DB ���� ���� = (������ �ֹ��� ������ ���� + DB�� ���� �ִ� ���� ����)
			Cho.adp_ob.setRibbon(v += G_UserOrder.adp_tot[3]);
			
			// DB�� �ִ� �̴� �ɴٹ��� ������ ���Ѵ�.
			v = Cho.adp_ob.getMiniflo();
			// DB �̴� �ɴٹ� ���� = (������ �ֹ��� �̴ϲɴٹ� ���� + DB �� ���� �ִ� �̴� �ɴٹ��� ����)
			Cho.adp_ob.setMiniflo(v += G_UserOrder.adp_tot[4]);
			
			// MainExcpeiton ���� �߻�
			throw new MainException();
		}
		
		
		int temp = Integer.parseInt(select);
		return temp;
		
	}
	

	public static String S_input()   //��M = ������ ���Ρ� / ��X = �����ϱ⡹
	{
		Scanner sc = new Scanner(System.in);
		String select=sc.next();

		if(select.equals("M")  || select.equals("m"))
		{
			throw new MainException();
		}
		else if(select.equals("X")  || select.equals("x"))
		{
			Cho.fl_cl = Cho.boksa(Cho.fl);
			Cho.fl_tot_cl=Cho.boksa_tot(Cho.tot);
			int a = FlowerKiosk.CartDB_list.size();
			for(int i=a-1;i>=0;i--) {
			FlowerKiosk.CartDB_list.remove(i);
			}
			int v=Cho.adp_ob.getMsg();
			Cho.adp_ob.setMsg(v+=G_UserOrder.adp_tot[0]);
			v=Cho.adp_ob.getBasket();
			Cho.adp_ob.setBasket(v+=G_UserOrder.adp_tot[1]);
			v=Cho.adp_ob.getPaper();
			Cho.adp_ob.setPaper(v+=G_UserOrder.adp_tot[2]);
			v=Cho.adp_ob.getRibbon();
			Cho.adp_ob.setRibbon(v+=G_UserOrder.adp_tot[3]);
			v=Cho.adp_ob.getMiniflo();
			Cho.adp_ob.setMiniflo(v+=G_UserOrder.adp_tot[4]);
			
			throw new MainException();
		}

		return select;
	}
}

// CLIO.clearScreen_100();
// CLIO.clearScreen_10();
// CLIO.input();
// CLIO.S_input();