package kiosk;
import java.util.*;
import java.io.*;

public class PurComplete
{
	static void purComplete_Cash()
	{
		CLIO.clearScreen_10();
		System.out.println("=======================================================");
		System.out.println("[���ſϷ�]                     M= �ѷ�����, X= ��ü���");
		System.out.println("=======================================================");
		System.out.println();
		System.out.println("�� ���Ű� �Ϸ�Ǿ����ϴ�.");
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(" No.  |        ��ǰ��       |    ����    |     ����   |");
		System.out.println("-------------------------------------------------------");
		
		for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
	      {
	    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_FlowerUser() + FlowerKiosk.CartDB_list.get(i).getSize() + FlowerKiosk.CartDB_list.get(i).getSu() + FlowerKiosk.CartDB_list.get(i).getPrice());
	      }
		
		System.out.println("-------------------------------------------------------");
		System.out.printf("�� �ֹ��ݾ� : %d%n", Money.userCash);
		System.out.println("�� �������� : ����");
		System.out.printf("�� �Ž����� : %d", H_CashPay.calResult);
		System.out.println();

		CLIO.clearScreen(16-FlowerKiosk.CartDB_list.size());

		// System.out.println(" ���� ���" );
		Money.userCash = 0;
		Cho.fl = Cho.boksa(Cho.fl_cl);
		Cho.tot = Cho.boksa_tot(Cho.fl_tot_cl);
		
		int a = FlowerKiosk.CartDB_list.size();
		for(int i=a-1;i>=0;i--) {
		FlowerKiosk.CartDB_list.remove(i);
		}
		
		Money.userCash = 0;
		
		String select = CLIO.S_input();

	}
	
	static void purComplete_Card()
	{
		CLIO.clearScreen_10();
		System.out.println("=======================================================");
		System.out.println("[���ſϷ�]                     M= �ѷ�����, X= ��ü���");
		System.out.println("=======================================================");
		System.out.println();
		System.out.println("�� ���Ű� �Ϸ�Ǿ����ϴ�.");
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(" No.  |        ��ǰ��       |    ����    |     ����   |");
		System.out.println("-------------------------------------------------------");
		
		for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
	      {
	    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_FlowerUser() + FlowerKiosk.CartDB_list.get(i).getSize() + FlowerKiosk.CartDB_list.get(i).getSu() + FlowerKiosk.CartDB_list.get(i).getPrice());
	      }
		
		System.out.println("");
		System.out.printf("�� �ֹ��ݾ� : %d%n", Money.userCash);
		System.out.println();
		System.out.println("�� �������� : ī��");
		System.out.println();

		CLIO.clearScreen(15-FlowerKiosk.CartDB_list.size());
		// System.out.println(" ���� ���" );
		Money.userCash = 0;
		Cho.fl = Cho.boksa(Cho.fl_cl);
		Cho.tot = Cho.boksa_tot(Cho.fl_tot_cl);
		
		int a = FlowerKiosk.CartDB_list.size();
		for(int i=a-1;i>=0;i--) {
		FlowerKiosk.CartDB_list.remove(i);
		}
		
		Money.userCash = 0;
		
		String select = CLIO.S_input();
	}
}
