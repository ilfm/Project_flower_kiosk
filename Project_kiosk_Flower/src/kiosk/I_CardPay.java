package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

public class I_CardPay
{
   static long cardNum;         // ������ ī���ȣ 16�ڸ�
   static String inputNum;         // ���ڿ������� �Է¹��� ī���ȣ
   static String[] card;         // ī���ȣ �� �ڸ����� ������ ������ ���� �迭
   static int[] even=new int[8];   // ¦�� �� ���ڷ� �̷���� �迭
   static int[] odd=new int[7];   // Ȧ�� �� ���ڷ� �̷���� �迭

   // ī����� �⺻ȭ�� ���+�ڸ��� üũ �޼ҵ�
   public static void checkDigit()
   {
      inputNum=null;                                                   // �Է¹��� ���ڿ��� ���� �ʱ�ȭ

      // ī����� �⺻ȭ�� ���
      System.out.println("===================================================================");
      System.out.println("  [ ī����� ]                         ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("===================================================================");
      System.out.println();
      Scanner sc=new Scanner(System.in);
      boolean flag=false;                                                // ���Է� �ȳ��� ���� ����� �ʱ�ȭ

      do
      {
         try
         {
            System.out.print(" �� ī���ȣ 16�ڸ��� �Է����ּ���(-����) : ");         // ī���ȣ 16�ڸ� �Է� �ȳ�
			CLIO.clearScreen(24);
            inputNum=CLIO.S_input();                                       // �Է¹��� ���� ���ڿ������� ����
            card=new String[16];                                          // �Է¹��� ���� ���� ��������� 16�� ���� �迭 ����
         
            for (int i=0; i<card.length; i++)                                 // 16�� �渶��
            {
               card[i]=inputNum.substring(i, i+1);                              // ���ڿ� i��° �����ؼ� ����
               //System.out.println(card[i]);                                 // �� ���� ���� Ȯ�� �Ϸ�!
            }
            flag=false;
            
            if (checkAA()==0)
            {
               // System.out.format(" �� %,d���� �����˴ϴ�.", Money.userCash);         // �Ѱ����� �ȳ�         // �ڡ� ������ ���� �ݾ��� �����(��ٱ��ϰ� �ƴ϶� �ֹ�ȭ�鿡�� �����ݻ�� üũ�� �Ѱ����ݾ�)
               // System.out.println();
               PurComplete.purComplete_Card();
            }
            else if (checkAA()==1)
            {
               System.out.println(" �� ī�尡 ��ȿ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");   // ����ȿ �ȳ�
			   CLIO.clearScreen(4);
               flag=true;                                                // ���Է� ó��
            }
            // Ÿ���� ī���ȣ �׽�Ʈ : 4388576018410707, 5365101012180349
            // Ÿ������ ���� ī���ȣ �׽�Ʈ : 4388576018402626

         }
         catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException�� �ش�� ���(�ڸ��� ���� ���� ���)
         {
            System.out.println(" �� �ڸ����� ���� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");      // ���Է� �ȳ�
            flag=true;                                                   // ���Է� ó��
         }
         catch (NumberFormatException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            flag=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            flag=true;
         }
      }
      while (flag);                                                      // �ݺ��� ���� ������ false ������ �� do �����ϵ��� ó��
   }

   
   // �ڸ��� ��ġ�� ��� ��ȿ�� �˻� �޼ҵ�
   private static int checkAA()
   {
      int evensum=0;                        // ¦���� �ʱ�ȭ
      int oddsum=0;                        // Ȧ���� �ʱ�ȭ
      int code=Integer.parseInt(card[15]);      // �����ڵ�(�� ������ ����) �ʱ�ȭ

      for (int i=card.length-3; i>=0; i=i-2)      // �ε��� 13 11 9 7 5 3 1 �� �� ������ ���ڸ� ������ ¦���ڸ�
      {
         int j=0;                        // �ι�° �������� �ʱ�ȭ
         even[j] = Integer.parseInt(card[i]);   // card�迭�� ¦���ڸ���° �����͸� int������ ��ȯ�Ͽ� ¦���迭�� j��° �濡 ����
         
         if (even[j]>=10)                  // ¦���ڸ����� ���ڰ� 10 �̻��̶��
            evensum += even[j]%10 + even[j]/10;   // ¦���տ� 10���� ���� ��� 10���� ���� �������� �ո�ŭ �����ֱ�.....18%10=8 , 18/10=1 > 8+1=9
         else                           // ¦���ڸ����� ���ڰ� 10 �̸��̶��
            evensum += even[j];               // ���� �״�� ¦���տ� �����ֱ�
         j++;                           // �ι�° �������� ����ó��
         //System.out.println(evensum);         // ¦���� Ȯ�� �Ϸ�!
      }

      for (int i=card.length-2; i>=0; i=i-2)      // �ε��� 14 12 10 8 6 4 2 0 �� Ȧ���ڸ�
      {
         int j=0;                        // �ι�° �������� �ʱ�ȭ
         odd[j] = Integer.parseInt(card[i]);      // card�迭�� Ȧ���ڸ���° �����͸� int������ ��ȯ�Ͽ� Ȧ���迭�� j��° �濡 ����
         odd[j]*=2;                        // Ȧ���迭 j��° �� �����͸��� 2�� ���� �� ����

         if (odd[j]>=10)                     // Ȧ���ڸ����� ���ڰ� 10 �̻��̶��
            oddsum += odd[j]%10 + odd[j]/10;   // Ȧ���տ� 10���� ���� ��� 10���� ���� �������� �ո�ŭ �����ֱ�.....18%10=8 , 18/10=1 > 8+1=9
         else                           // Ȧ���ڸ����� ���ڰ� 10 �̸��̶��
            oddsum += odd[j];               // ���� �״�� Ȧ���տ� �����ֱ�
         j++;                           // �ι�° �������� ����ó��
         //System.out.println(oddsum);         // Ȧ���� Ȯ�� �Ϸ�!
      }
      
      int compCode = 10-((evensum+oddsum)%10);   // 10���� ¦����+Ȧ������ 10���� ���� ������(1�� �ڸ� ��)�� �� ���ڸ� ������ ����
      if (compCode==code)                     // ������ ���� �ڵ�� ��ġ�Ѵٸ�
         return 0;                        // 0=��ȿ ��ȯ
      else                              // �̿��� ���
         return 1;                        // 1=����ȿ ��ȯ
   }


   // �̱��̺�Ʈ �ȳ� �޼ҵ�
   // �̱��̺�Ʈ �ȳ� �޼ҵ�
   public static void eventMsg()
   {
      if (Money.userCash>=50000)            // �Ѱ������� 50000�� �̻��� ���               // �ڡ� ������ ���� �ݾ��� �����(��ٱ��ϰ� �ƴ϶� �ֹ�ȭ�鿡�� �����ݻ�� üũ�� �Ѱ����ݾ�)
      {
         String y,tel,pw;

         System.out.println(" �� �̱��̺�Ʈ ������ 1ȸ ������ϴ�. ��");
         System.out.println(" ������ �����ðڽ��ϱ�? (y/n) :");
         y=CLIO.S_input();
         boolean check =true;
         

          if(y.equals("y")||y.equals("Y"))
         {   

            do
           {
             System.out.print(" �� ��ȭ��ȣ �Է� : ");
             tel = CLIO.S_input();
             check = checkpho.telCheck(tel);
           }
           while (check == true);
            
          System.out.println("12345678");
           UserInfo temp = Cho.ui.get(tel);
           System.out.println("12345678");
           
           do
           {
             System.out.print(" �� ��й�ȣ �Է� : ");
             pw = CLIO.S_input();
             check = checkpho.pwCheck2(pw, temp);
             System.out.println("12345678");
           }
           while (check == true);
           temp.c_count +=1;                              // �ش� ���� ī��Ʈ 1ȸ �߰�
           System.out.println(temp.c_count);
           A_Main.cus_maindisp();
           
           
          
           

         }else{

            A_Main.cus_maindisp();

         }      
         
           
        
        
         // �ڡ� ���ݰ��� ���ſϷ�ȭ�� �޼ҵ�();
      }
      else if (Money.userCash<50000)         // �Ѱ������� 50000�� �̻��� ��� ������
      {
         System.out.println("===================================================================");
         CLIO.clearScreen_10();
         // �ڡ� ���ݰ��� ���ſϷ�ȭ�� �޼ҵ�();
      }
   
   }

}




/*
      boolean flag=false;
      do
      {
         System.out.print(" �� ī���ȣ�� �Է����ּ���(-����) : ");
         String inputNum=sc.next();   // �Է¹޴� ī���ȣ(���ڿ�)

         for (int i=0; i<inputNum.length(); i++)      // ���ڿ��� �Էµ� ���� ���� �迭�� �־���
         {
            if (inputNum.length()>=13+3 || inputNum.length()<=16+3)
            {
               String[] temp=new String[inputNum.length()];
               int[] cardNum=new int[inputNum.length()];
            }
            temp[i]=inputNum.substring(i, i+1);
         }

         for (int i=0; i<inputNum.length(); i++)      // ���ڿ� �迭�� ���� ���� ���������� ��ȯ����
         {
            if(temp[i]=="-")
               continue;
            cardNum[i]=Integer.parseInt(temp[i]);
         }

         if (inputNum.length()<13+3 || inputNum.length()>16+3)
         {
            System.out.println("�ٽ� �Է����ּ���.");
            flag=true;
         }
      }
      while (flag);
*/   