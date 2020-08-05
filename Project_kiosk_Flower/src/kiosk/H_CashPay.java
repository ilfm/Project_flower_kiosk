package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

public class H_CashPay
{
   static int change;         // �Ž�����
   static int calResult;      // �Ž����� �Ѿ� ���� ����
   static int inputCash;      // ���Ծ׼�
   static int[] share;         // �� �迭
   static Scanner sc=new Scanner(System.in);

   // ���ݰ��� �⺻ȭ�� ���+���ɿ��� üũ �޼ҵ�
   public static void checkcal()
   {
	  change = 0;
	  calResult = 0;
	  inputCash = 0;
	  
	   // ���ݰ��� �⺻ȭ�� ���
      System.out.println("===================================================================");
      System.out.println("  [ ���ݰ��� ]                         ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("===================================================================");
      System.out.printf("�����ݾ��� %d ���Դϴ�.%n", Money.userCash);
      System.out.println("===================================================================");
      System.out.println();

      boolean flag=false;                           // �ݺ��� ���� ���� ����
      
      // ���ݰ��� ���ɿ��� üũ
      do
      {
         try
         {
            if (Money.exc_tot<50000 && Money.exc_1000<10)         // �����ܰ� 50000�� �̸��̸鼭, 1000�� ���� 10�� �̸��� �� ���ݰ��� �Ұ���
            {
               System.out.print(" �� �����ܰ� �����Ͽ� ī�� ������ �����մϴ�. (ī����� C �Է�) : ");   // ���ݰ��� �Ұ����� ��� ������ ���
               String choice=CLIO.S_input();                                                         // ���� �Է¹ޱ�
               
               do
               {
                  try
                  {
                     if (choice.equals("J"))                                                               // J �Է½� ������ ���� �޼ҵ� ����
                     {
                        System.out.println();
                        calChange();
                        calResult();
                     }
                     else if (choice.equals("C"))                                                         // C �Է½� ī����� �޼ҵ� ����
                     {
                        System.out.println();
                        I_CardPay.checkDigit();
                        I_CardPay.eventMsg();
                     }
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
               while (flag);
            }
            else if (Money.exc_tot>=50000 && Money.exc_1000>=10)   // �����ܰ� 50000�� �̻��̸鼭, 1000�� ���� 10�� �̻��� �� ���ݰ��� ����
            {
               do
               {
                  try
                  {
                     System.out.print(" �� ������ �������ּ���(���� �Է�) : ");                                 // ���� ���� �ȳ��޼��� ���
					 CLIO.clearScreen(23);
                     inputCash=CLIO.input();                                                            // ���Ծ� �Է¹ޱ�
         
                     if (inputCash<Money.userCash)               // �� �����ݾ� �̸����� �Է����� ��� �Ұ���
                     {
                        System.out.println(" �� �ٽ� �Է����ּ���.");   // ���Է� �ȳ�
                        flag=true;                              // ���Է� ó��
                     }
                     else if (inputCash>=Money.userCash)            // �� �����ݾ� �̻����� �Է����� ��� ����
                     {
                        H_CashPay.calChange();                  // �Ž����� ���� �޼ҵ�
                        H_CashPay.calResult();                  // ������ �ȳ� �޼ҵ�
                       // PurComplete.purComplete_Cash();
                     }
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
               while (flag);                              // �ݺ��� ���� ������ false ������ �� do �����ϵ��� ó��
            }
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
      while (flag);
   }

   // ���ݰ��� ���ɽ� : �Ž����� ���� �޼ҵ�
   public static void calChange()
   {   
      // �Ž����� �Ѿ� ����
      int[] div={1000, 5000, 10000};               // ���� �׼� �迭�� �� ����
      share=new int[3];                        // �� �迭 �� ����
      change=inputCash-Money.userCash;            // �Ž����� �Ѿ� = ���Ծ� - �Ѱ����ݾ� �� 1000�� �Ѿ׿� 68000�� �����ߴٰ� �ϸ�.. �Ž������� 67000��
   
      for (int i=div.length-1; i>=0; i--)            // ū �׼����� ������ �ݺ�
      {                                    // 67000���� 10000���� �������� ��6, ������ 7000 > 5000���� �������� ��1, ������ 2000 > 1000���� �������� ��2, ������0
         share[i] = change/div[i];               // �� �迭�渶�� �� ����
         //System.out.println(share[i]);            // �� Ȯ�� �Ϸ�! (6/1/2)
         change -= div[i]*share[i];               // ���� �� ������ ���� �� ���� ���ĸ��� �Ž����� �Ѿ׿��� ������ �ݾ�*�� ��ŭ ����..... 67000-60000 / 7000-5000 / 2000-2000 (�Ž�����=��������)
      }

      for (int i=div.length-1; i>=0; i--)
      {
         if (share[i]>0)                        // �������� �� ���� 0�̻��̶��
            calResult += change+div[i]*share[i];   // �ӽú����� ���������� �����ݾ�*�� ��ŭ ������ (���ع��� �Ž����� �Ѿ�-change- ������ ���� ������)
         //System.out.println(calResult);         // �Ž����� Ȯ�� �Ϸ�! (60000/65000/67000)
      }
   }

   // �����ܰ� ���� ó�� �޼ҵ�
   private static void calBalance()
   {
         // �����ܰ� n�� �ǿ��� ��ŭ ���� ���� ó�� �� ���� 10000���� �������� 6�� ����, ���� 5000���� �������� 1�� ����, ���� 1000���� �������� 2�� ����
         Money.exc_10000 -= share[2];
         //System.out.println(Money.exc_10000);      // 10000���� ���� Ȯ�� �Ϸ�!
         Money.exc_5000 -= share[1];
         //System.out.println(Money.exc_5000);      // 5000���� ���� Ȯ�� �Ϸ�!
         Money.exc_1000 -= share[0];
         //System.out.println(Money.exc_1000);      // 1000���� ���� Ȯ�� �Ϸ�!
   }
   

   // ���ݰ��� ���ɽ� : ������ �ȳ� �޼ҵ�
   public static void calResult()
   {
      if (calResult>Money.exc_tot)               // �Ž������� �����ܰ� �ʰ��� ��� ��ȯ �Ұ�
      {
         boolean flag=false;
         do
         {
            try
            {
               System.out.print(" �� �����ܰ� �����Ͽ� �Ž����� ��ȯ�� �Ұ��մϴ�. (���� J, ī����� C �Է�) : ");   // �Ž����� ��ȯ �Ұ����� ��� ������ ���
               String choice=CLIO.S_input();                                                         // ���� �Է¹ޱ�
               
               if (choice.equals("J"))                                                               // J �Է½� ������ ���� �޼ҵ� ����
               {
                  System.out.println();
                  J_CashPoint.earnRewards_O();
                  J_CashPoint.earnRewards_I();
                  System.out.println();
               }
               else if (choice.equals("C"))                                                         // C �Է½� ī����� �޼ҵ� ����
               {
                  System.out.println();
                  I_CardPay.checkDigit();
                  I_CardPay.eventMsg();
               }
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
         while (flag);
      }
      else if (calResult>0 && calResult<=Money.exc_tot)   // �Ž������� �����ܰ� ������ ��� ��ȯ ����
      {
         boolean flag=false;
         do
         {
            try
            {
               System.out.format(" �� �Ž������� %d���Դϴ�.\n", calResult);                                 // �Ž����� �Ѿ� �ȳ�
               System.out.print(" �� �����Ͻ÷��� J, ��ȯ�Ͻ÷��� B �� �Է����ּ���. : ");                        // �Ž����� ��ȯ ������ ��� ������ ���
               String choice2=CLIO.S_input();                                                         // ���� �Է¹ޱ�
               
               if (choice2.equals("J") || choice2.equals("j") )                                                            // J �Է½� ������ ���� �޼ҵ� ����
               {
                  System.out.println();
				  CLIO.clearScreen_10();
                  J_CashPoint.earnRewards_O();
                  J_CashPoint.earnRewards_I();
                  System.out.println();
               }
               else if (choice2.equals("B") || choice2.equals("b"))                                                         // B �Է½� �Ž����� ��ȯ�� �ȳ� �� �����ܰ� ���� ó��
               {
                  System.out.format(" �� �����Ϸ� �� �Ž����� %,d���� ��ȯ�˴ϴ�.\n", calResult);
                  calBalance();
               }
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
         while (flag);
      }
   }
   
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
            
           UserInfo temp = Cho.ui.get(tel);
           
           do
           {
             System.out.print(" �� ��й�ȣ �Է� : ");
             pw = CLIO.S_input();
             check = checkpho.pwCheck2(pw, temp);
           }
           while (check == true);
           temp.c_count +=1;                              // �ش� ���� ī��Ʈ 1ȸ �߰�
           System.out.println(temp.c_count);
           
           PurComplete.purComplete_Cash();
           

         }else{

           PurComplete.purComplete_Cash();

         }      
         
           
         System.out.println();
         CLIO.clearScreen_10();
         // �ڡ� ���ݰ��� ���ſϷ�ȭ�� �޼ҵ�();
      }
      else if (Money.userCash<50000)         // �Ѱ������� 50000�� �̻��� ��� ������
      {
		  PurComplete.purComplete_Cash();
      }
   }
}
