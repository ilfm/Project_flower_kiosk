package kiosk;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// �������� ���ư��� ���� 
class MainException extends RuntimeException{

}

public class FlowerKiosk
{
	
	static List<CartDB> CartDB_list = new LinkedList<CartDB>();
	static int count=0;
	
   public static void main(String[] args)
   {   	   

	   while(true)
	   {
		   count++;
		   try
			{
				A_Main.cus_maindisp();
				A_Main.cus_maininput();
			}
			catch (MainException e)
			{
				// �ܼ� ȭ�� �о������ �Լ� 
				CLIO.clearScreen_10();
				count++;
			}

	   }

   }
}