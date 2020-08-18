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

	// 입력 메소드 
	public static int input()	//「M = 둘러보기 (메인화면으로 )」 / 「X = 종료하기」
	{
		Scanner sc = new Scanner(System.in);
		String select = sc.next();
		
		// M 입력시 장바구니에 담긴 상품을 유지한 상태로 메인으로 돌아간다.
		if(select.equals("M")  || select.equals("m"))
		{
			// MainException 예외 발생
			throw new MainException();
		}
		else if(select.equals("X")  || select.equals("x")) 
		{
			// X 입력 시 장바구니에 있던 것들을 모두 취소하고 메인으로 돌아가야 한다.
			// fl_cl 을 기존의 fl로 초기화 한다.
			Cho.fl_cl = Cho.boksa(Cho.fl);
			
			// fl_tot_cl 을 기존의 fl_tot로 초기화 한다.
			Cho.fl_tot_cl = Cho.boksa_tot(Cho.tot);
			int a = FlowerKiosk.CartDB_list.size();
			
			// 장바구니에 있는 모든 정보를 제거 한다.
			for(int i=a-1;i>=0;i--) 				
				FlowerKiosk.CartDB_list.remove(i);
					
			// 추가 구매 상품 초기화 
			// DB에 있는 메세지 카드 개수를 구한다
			int v = Cho.adp_ob.getMsg();
			// DB 카드 개수 = (유저가 주문한 카드의 개수 + DB에 남아 있는 카드 개수)
			Cho.adp_ob.setMsg(v += G_UserOrder.adp_tot[0]);
			
			// DB에 있는 바구니 개수를 구한다
			v = Cho.adp_ob.getBasket();
			// DB 바구니 개수 = (유저가 주문한 바구니의 개수 + DB에 남아 있는 바구니 개수)
			Cho.adp_ob.setBasket(v += G_UserOrder.adp_tot[1]);
			
			// DB에 있는 편지지 개수를 구한다
			v = Cho.adp_ob.getPaper();
			// DB 편지지 개수 = (유저가 주문한 바구니의 개수 + DB에 남아 있는 편지지 개수)
			Cho.adp_ob.setPaper(v += G_UserOrder.adp_tot[2]);
			
			// DB에 있는 리본의 개수를 구한다.
			v = Cho.adp_ob.getRibbon();
			// DB 리본 개수 = (유저가 주문한 리본의 개수 + DB에 남아 있는 리본 개수)
			Cho.adp_ob.setRibbon(v += G_UserOrder.adp_tot[3]);
			
			// DB에 있는 미니 꽃다발의 개수를 구한다.
			v = Cho.adp_ob.getMiniflo();
			// DB 미니 꽃다발 개수 = (유저가 주문한 미니꽃다발 개수 + DB 에 남아 있는 미니 꽃다발의 개수)
			Cho.adp_ob.setMiniflo(v += G_UserOrder.adp_tot[4]);
			
			// MainExcpeiton 예외 발생
			throw new MainException();
		}
		
		
		int temp = Integer.parseInt(select);
		return temp;
		
	}
	

	public static String S_input()   //「M = 관리자 메인」 / 「X = 종료하기」
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