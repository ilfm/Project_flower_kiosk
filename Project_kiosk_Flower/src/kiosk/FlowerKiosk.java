package kiosk;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

// �������� ���ư��� ���� Ŭ����
class MainException extends RuntimeException{

}

public class FlowerKiosk
{
	// ��ٱ��� 
	static List<CartDB> CartDB_list = new LinkedList<CartDB>();
	static int count = 0;
	
	// ���� �޼ҵ� 
   public static void main(String[] args)
   {   	   

	   while(true)
	   {
		   count++;
		   try
			{	// ���θ޴� ȭ�� ��� �޼ҵ� ȣ��
				A_Main.cus_maindisp();
				// ���θ޴� �Է� �޼ҵ� ȣ��
				A_Main.cus_maininput();
			}
		   	// �������� ���ư��� Exception catch  
			catch (MainException e)
			{
				// �ܼ� ȭ�� �о������ �޼ҵ� ȣ�� 
				CLIO.clearScreen_10();
				count++;
			}

	   }

   }
}