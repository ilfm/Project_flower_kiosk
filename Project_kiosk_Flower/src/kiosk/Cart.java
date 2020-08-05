package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class Cart
{

   public static void User_Cart()
   {
	  CLIO.clearScreen_10();
      System.out.println("===================================================================");
      System.out.println("[ SMART FLOWER 장바구니 ]              「M=둘러보기」「X=전체취소」");
      System.out.println("===================================================================");
      System.out.println("-------------------------------------------------------------------");
      System.out.println("   상품명   |  수량  |  가격  ");
      System.out.println("-------------------------------------------------------------------");
	
      for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
      {
    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_FlowerUser() + "    " + FlowerKiosk.CartDB_list.get(i).getSize() + "    " + FlowerKiosk.CartDB_list.get(i).getSu() + "    " + FlowerKiosk.CartDB_list.get(i).getPrice());
      }


      // 데이터 불러오기....... or 장바구니 DB 불러오기..... + 출력
      /*
      for(int i=0 ; i<FlowerKiosk.CartDB_list.size(); i++)
      {
    	  Money.userCash += FlowerKiosk.CartDB_list.get(i).getPrice();
      }
	 */
      String[] ch=new String[Cho.length];            // 가격 표기를 위한 배열 생성
      DecimalFormat df=new DecimalFormat("###,###");   // 가격 표기를 위한 DecimalFormat 인스턴스 생성
      for(int i=0; i<Cho.length; i++)               // 배열방마다 int형 데이터를 콤마 찍히는 String형 데이터로 변환하여 저장
         ch[i]=df.format(Cho.tot.get(i).ft_price);

      System.out.println("-------------------------------------------------------------------");
      System.out.printf("→ 총 주문금액 : %d원\n", Money.userCash);
      System.out.print(" ▶ 주문화면으로 넘어가기 (Y입력) : ");
	  CLIO.clearScreen(21-FlowerKiosk.CartDB_list.size());
      
      Scanner sc=new Scanner(System.in);
      String selOrder=CLIO.S_input();
      if (selOrder.equals("Y") || selOrder.equals("y"))
      {
         System.out.println();
         G_UserOrder.uOrder();
      }
      else
      {
         System.out.print("다시 입력해주세요.");
         // ★★ 입력형식 안맞을경우 예외처리!!
      }
   }
}

