package kiosk;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// 메인으로 돌아가는 예외 
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
				// 콘솔 화면 밀어버리는 함수 
				CLIO.clearScreen_10();
				count++;
			}

	   }

   }
}