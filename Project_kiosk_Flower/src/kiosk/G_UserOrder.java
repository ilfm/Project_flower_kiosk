package kiosk;
import java.util.*;
import java.io.*;

//�ֹ�ȭ��
class G_UserOrder extends E_RandEvent
{
	static int ran,count;
	static String tel,pwd;
	static String y; //y or n �Է¹޴� ����
	static int n;
	static int[] adp_tot = new int[5];
	//0:�޼���, 1:�ٱ���, 2:������, 3:����, 4:�̴ϲɴٹ� 
	static String[] ab=new String[15];
    static String[] abto=new String[15];

    static void uOrder()  //�ֹ�ȭ�� ���
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("===================================================================================");
		System.out.println("   [�ֹ�ȭ��]                                          ��M=�ѷ����⡹��X=��ü��ҡ�");
		System.out.println("===================================================================================");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("   ��ǰ��          |  ����  |  ����  ");
		System.out.println("-------------------------------------------------------------------");

		for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
	      {
	    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_RandomFlower() + FlowerKiosk.CartDB_list.get(i).getSize() + FlowerKiosk.CartDB_list.get(i).getSu() + FlowerKiosk.CartDB_list.get(i).getPrice());
	      }
		System.out.println("-------------------------------------------------------------------");
	    System.out.printf("�� �� �ֹ��ݾ� : %d��\n", Money.userCash);
		CLIO.clearScreen(21-FlowerKiosk.CartDB_list.size());

		boolean flag=false;
		do {
		
			try {
				System.out.print(" �� �߰� ���Ÿ� �����Ͻðڽ��ϱ�(Y/N)? :");
				y=CLIO.S_input();
				if(y.equals("Y")||y.equals("y"))
				{
					CLIO.clearScreen_10();
					uOrderCon();
				}

				uOrderCon2();	
			}
			   catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException�� �ش�� ���(�ڸ��� ���� ���� ���)
	         {
	            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");      // ���Է� �ȳ�
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
		
		//else 
	}


	static void uOrderCon()//�߰����� 
   {
		System.out.println("\n\n");
		String[] z= {"�޼���ī��","�ٱ���","������","����","�̴ϲɴٹ�"};
		int[] zz= {1000,2000,2000,2000,4000};

		Scanner sc=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" �� �߰����� �ɼ� �� ");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" No. |\t��ǰ��\t|\t����\t|\t����");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" [��ǰ��ȣ]\t[�߰����� �ɼ�]\t\t\t[��ǰ �ݾ�]");
		System.out.println("\t1\t�޼���ī��\t\t\t1,000��");
		System.out.println("\t2\t�ٱ���\t\t\t\t2,000��");
		System.out.println("\t3\t������\t\t\t\t2,000��");
		System.out.println("\t4\t����\t\t\t\t2,000��");
		System.out.println("\t5\t�̴ϲɴٹ�(������ö��)\t4,000��"); 
		System.out.println("-----------------------------------------------------------------------------------");
		boolean flag=false;
	      do
	      {
	         try
	         {
	            do
	            {
			System.out.print(" �� �߰� ���Ÿ� ���ϴ� ��ǰ��ȣ�� ������ �Է��ϼ���[�ĸ�����] : ");
			CLIO.clearScreen(17);
			String s = CLIO.S_input();
			String str[] = s.split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]); 
			sc.nextLine(); //����(����)����

			
			//�߰����� ������
			if(a==1)
			{
				
				//Adp.msg-=b;
				adp_tot[0]+=b;
				if(Cho.adp_ob.getMsg()>=adp_tot[0]) {
				Money.userCash+=1000*b;
				//System.out.println("���� ī�� �� :"+Adp.msg); //�׽�Ʈ 
				System.out.println(" �� ������ ī�� �� :"+adp_tot[0]);
				System.out.println(" �� �ݾ�:"+Money.userCash);
				int v=Cho.adp_ob.getMsg();
				Cho.adp_ob.setMsg(v-b);
				}else {
					System.out.println("��������! ���� ��� : "+Cho.adp_ob.getMsg());
					adp_tot[0]-=b;
				}
			}
			else if(a==2)
			{
				
				adp_tot[1]+=b;
				if(Cho.adp_ob.getBasket()>=adp_tot[1]) {
				Money.userCash+=2000*b;
				System.out.println(" �� ������ �ٱ��� �� :"+adp_tot[1]);
				System.out.println(" �� �ݾ�:"+Money.userCash);
				int v=Cho.adp_ob.getBasket();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("��������! ���� ��� : "+Cho.adp_ob.getBasket());
				adp_tot[1]-=b;
			}
			}
			else if(a==3)
			{
				
				adp_tot[2]+=b;
				if(Cho.adp_ob.getPaper()>=adp_tot[2]) {
				Money.userCash+=2000*b;
				System.out.println(" �� ������ ������ �� :"+adp_tot[2]);
				System.out.println(" �� �ݾ�:"+Money.userCash);
				int v=Cho.adp_ob.getPaper();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("��������! ���� ��� : "+Cho.adp_ob.getPaper());
				adp_tot[2]-=b;
			}
			}
			else if(a==4)
			{
				
				adp_tot[3]+=b;
				if(Cho.adp_ob.getRibbon()>=adp_tot[3]) {
				Money.userCash+=2000*b;
				System.out.println(" �� ������ ���� �� :"+adp_tot[3]);
				System.out.println(" �� �ݾ�:"+Money.userCash);
				int v=Cho.adp_ob.getRibbon();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("��������! ���� ��� : "+Cho.adp_ob.getRibbon());
				adp_tot[3]-=b;
			}
			}
			else if(a==5)
			{
				
				adp_tot[4]+=b;//�̴ϲɴٹ�
				if(Cho.adp_ob.getMiniflo()>=adp_tot[4]) {
				Money.userCash+=4000*b;
				System.out.println(" �� ������ �̴ϲɴٹ� �� : "+adp_tot[4]);
				System.out.println(" �� �ݾ�:"+Money.userCash);
				int v=Cho.adp_ob.getMiniflo();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("��������! ���� ��� : "+Cho.adp_ob.getMsg());
				adp_tot[4]-=b;
			}
			}

			if(a==1)
			{
				for(int i=1;i<=b;i++)
				{
					System.out.print(" �� �޼����Է�(�ִ� 50����) : ");
					String strM=sc.nextLine();
				}
			}
			
			FlowerKiosk.CartDB_list.add(new CartDB("[�߰�����]"+ z[a-1],0, adp_tot[a-1],zz[a-1]));

			System.out.print(" �� ��� �����Ͻðڽ��ϱ�(Y/N)? : ");

			y=CLIO.S_input();
		}
		while(y.equals("Y")||y.equals("y"));
	    flag = false;
   }
	         catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException�� �ش�� ���(�ڸ��� ���� ���� ���)
	         {
	            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");      // ���Է� �ȳ�
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


   static void uOrderCon2()
	{
		String s;
		Scanner sc=new Scanner(System.in);
		 boolean flag=false;
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
		 
	      do
	      {
	         try
	         {
		System.out.println("-------------------------------------------------------------------");
		CLIO.clearScreen(22-FlowerKiosk.CartDB_list.size());
		System.out.print(" �� �� ���� �ݾ��� "+Money.userCash+" �Դϴ�. �������� ����Ͻðڽ��ϱ�(Y/N)? : ");
		y=CLIO.S_input();

		if(y.equals("Y")||y.equals("y"))
		{
			CLIO.clearScreen_10();
			J_CashPoint.useRewards_O();
		}

		Ran();

		do
		{
			System.out.print(" �� ������ ����Ͻðڽ��ϱ�(Y/N)? : ");
			y=CLIO.S_input();

			if(y.equals("Y")||y.equals("y")) //������� - ��ȣ����� �����ϰ��ϱ�(����)
			{
				//System.out.println(randcon);

				System.out.print(" �� ������ �Է��ϼ���: ");
				String conu=CLIO.S_input();

				//��÷������ ����ڰ� �Է��� �� �� �� ����� �����Ͱ� ������ 
				for(int i=0;i<UserInfo.prizeCo.size();i++){
					if(abto[i].equals(conu))
						{        
							System.out.println(" �� ������� �Ϸ�");
							//���ó��
							 if(ab[i].equals("A"))
							  Money.userCash-=5000;
							else if(ab[i].equals("B"))
							   Money.userCash-=3000;
							else if(ab[i].equals("C"))
							   Money.userCash-=1000;
						}
						else System.out.println(" �� ����������� ����");
						System.out.println("���� �ݾ� : "+Money.userCash);
					}		
			}

		}while(y.equals("Y")||y.equals("y"));   
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


		//��������
		do
		{
			 boolean flag2=false;
	         do
	         {
	            try
	            {

			System.out.print(" ������ ������ �������ֽʽÿ�. 1)���ݰ��� 2)ī����� :");
			n=CLIO.input();
			if(n==1)
			{
				System.out.println("===================================================================================");
				CLIO.clearScreen_10();
				H_CashPay.checkcal();
				H_CashPay.eventMsg();
			}
			else if(n==2)
			{
				System.out.println("===================================================================================");
				CLIO.clearScreen_10();
				I_CardPay.checkDigit();
				I_CardPay.eventMsg();
			}
			else
			System.out.println(" �� �ٽ� �Է����ּ���.");
		}
	            catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException�� �ش�� ���(�ڸ��� ���� ���� ���)
	            {
	               System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");      // ���Է� �ȳ�
	               flag2=true;                                                   // ���Է� ó��
	            }
	            catch (NumberFormatException e)
	            {
	               System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
	               flag2=true;
	            }
	            catch (IndexOutOfBoundsException e)
	            {
	               System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
	               flag2=true;
	            }
	         }
	         while (flag2);
	      }
		while (n!=1&&n!=2);
	}
	static void Ran(){
		for(int i=0;i<UserInfo.prizeCo.size();i++){
			String aa=UserInfo.prizeCo.get(i).substring(0,8);
			String bb=UserInfo.prizeCo.get(i).substring(8,9);
			if(bb.equals("A")){
				ab[i]="A";//"5000�� ��������";
				abto[i]=aa;
			}else if(bb.equals("B")){
				ab[i]="B";//"3000�� ��������";
				abto[i]=aa;
			}else if(bb.equals("C")){
				ab[i]="C";//"1000�� ��������";
				abto[i]=aa;
			}
		}
	}
}