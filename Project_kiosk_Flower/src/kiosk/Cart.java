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
      System.out.println("[ SMART FLOWER ��ٱ��� ]              ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("===================================================================");
      System.out.println("-------------------------------------------------------------------");
      System.out.println("   ��ǰ��   |  ����  |  ����  ");
      System.out.println("-------------------------------------------------------------------");
	
      for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
      {
    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_FlowerUser() + "    " + FlowerKiosk.CartDB_list.get(i).getSize() + "    " + FlowerKiosk.CartDB_list.get(i).getSu() + "    " + FlowerKiosk.CartDB_list.get(i).getPrice());
      }


      // ������ �ҷ�����....... or ��ٱ��� DB �ҷ�����..... + ���
      /*
      for(int i=0 ; i<FlowerKiosk.CartDB_list.size(); i++)
      {
    	  Money.userCash += FlowerKiosk.CartDB_list.get(i).getPrice();
      }
	 */
      String[] ch=new String[Cho.length];            // ���� ǥ�⸦ ���� �迭 ����
      DecimalFormat df=new DecimalFormat("###,###");   // ���� ǥ�⸦ ���� DecimalFormat �ν��Ͻ� ����
      for(int i=0; i<Cho.length; i++)               // �迭�渶�� int�� �����͸� �޸� ������ String�� �����ͷ� ��ȯ�Ͽ� ����
         ch[i]=df.format(Cho.tot.get(i).ft_price);

      System.out.println("-------------------------------------------------------------------");
      System.out.printf("�� �� �ֹ��ݾ� : %d��\n", Money.userCash);
      System.out.print(" �� �ֹ�ȭ������ �Ѿ�� (Y�Է�) : ");
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
         System.out.print("�ٽ� �Է����ּ���.");
         // �ڡ� �Է����� �ȸ������ ����ó��!!
      }
   }
}

