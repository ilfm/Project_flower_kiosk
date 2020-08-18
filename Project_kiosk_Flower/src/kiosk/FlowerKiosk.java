package kiosk;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// 메인으로 돌아가는 예외 클래스
class MainException extends RuntimeException{

}

public class FlowerKiosk
{
	// 장바구니 
	static List<CartDB> CartDB_list = new LinkedList<CartDB>();
	static int count = 0;
	
	// 메인 메소드 
   public static void main(String[] args)
   {   	   

	   while(true)
	   {
		   count++;
		   try
			{	// 메인메뉴 화면 출력 메소드 호출
				A_Main.cus_maindisp();
				// 메인메뉴 입력 메소드 호출
				A_Main.cus_maininput();
			}
		   	// 메인으로 돌아가는 Exception catch  
			catch (MainException e)
			{
				// 콘솔 화면 밀어버리는 메소드 호출 
				CLIO.clearScreen_10();
				count++;
			}

	   }

   }
}