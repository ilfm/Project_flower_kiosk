package kiosk;
import java.util.*;
import java.io.*;

public class PurComplete
{
	static void purComplete_Cash()
	{
		CLIO.clearScreen_10();
		System.out.println("=======================================================");
		System.out.println("[구매완료]                     M= 둘러보기, X= 전체취소");
		System.out.println("=======================================================");
		System.out.println();
		System.out.println("▶ 구매가 완료되었습니다.");
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(" No.  |        상품명       |    개수    |     가격   |");
		System.out.println("-------------------------------------------------------");
		
		for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
	      {
	    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_FlowerUser() + FlowerKiosk.CartDB_list.get(i).getSize() + FlowerKiosk.CartDB_list.get(i).getSu() + FlowerKiosk.CartDB_list.get(i).getPrice());
	      }
		
		System.out.println("-------------------------------------------------------");
		System.out.printf("▶ 주문금액 : %d%n", Money.userCash);
		System.out.println("▶ 결제수단 : 현금");
		System.out.printf("▶ 거스름돈 : %d", H_CashPay.calResult);
		System.out.println();

		CLIO.clearScreen(16-FlowerKiosk.CartDB_list.size());

		// System.out.println(" 쿠폰 출력" );
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
		System.out.println("[구매완료]                     M= 둘러보기, X= 전체취소");
		System.out.println("=======================================================");
		System.out.println();
		System.out.println("▶ 구매가 완료되었습니다.");
		System.out.println();
		System.out.println("=======================================================");
		System.out.println(" No.  |        상품명       |    개수    |     가격   |");
		System.out.println("-------------------------------------------------------");
		
		for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
	      {
	    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_FlowerUser() + FlowerKiosk.CartDB_list.get(i).getSize() + FlowerKiosk.CartDB_list.get(i).getSu() + FlowerKiosk.CartDB_list.get(i).getPrice());
	      }
		
		System.out.println("");
		System.out.printf("▶ 주문금액 : %d%n", Money.userCash);
		System.out.println();
		System.out.println("▶ 결제수단 : 카드");
		System.out.println();

		CLIO.clearScreen(15-FlowerKiosk.CartDB_list.size());
		// System.out.println(" 쿠폰 출력" );
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
