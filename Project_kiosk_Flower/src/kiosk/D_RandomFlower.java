package kiosk;
import java.util.*;
import java.io.*;

class D_RandomFlower
{
	
	static void randomFlower_O()
	{
		System.out.println("=============================================================");
		System.out.println("                [���� �ɴٹ� ����]         N=�ѷ�����, X=����");
		System.out.println("=============================================================");
		System.out.println("�� ���� ���� �����ؾ����� �𸣰ڴٸ�? ������ �������� �پ��� ���� ����������.");
		System.out.println("�� ���� �ɴٹ� ���Ŵ� �������� ����(S������ 10����) ���� ������ ���ݿ�\n ���� �Ͻ� �� �ֽ��ϴ�.");
		System.out.println("=============================================================");
		System.out.print("�� ���� �ɴٹ� ����(��Y��= �̱� ) : ");
		CLIO.clearScreen(22);
	}

	static void randomFlower_I()
	{
		String sel;
		boolean flag = false;

		while (true)
		{
			do
			{
				try
				{
					Scanner sc = new Scanner(System.in);
					sel = CLIO.S_input();

					switch (sel)
					{
						case "Y" :
						case "y" :
						randomFlower_O2(); return;
					}
				}
				catch (StringIndexOutOfBoundsException e)										// StringIndexOutOfBoundsException�� �ش�� ���(�ڸ��� ���� ���� ���)
				{
					System.out.println(" �� �ڸ����� ���� �ʽ��ϴ�. �ٽ� �Է����ּ���. ");		// ���Է� �ȳ�
					flag=true;																	// ���Է� ó��
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

	static void randomFlower_O2()
	{
		Random rd = new Random();

		while(true)
		{
			int a;
			int b;
			int c;
			
			int count = 0;
			int count2 = 0;
			int rd1 = 0;
			int rd2 = 0;
			int rd3 = 0;
			
			int z = Cho.length;
			Flower_tot[] fl_su = new Flower_tot[z];
			Flower[] fl_su2 = new Flower[z];
		
			Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<Cho.length; i++)
		{
			fl_su[i] = Cho.fl_tot_cl.get(i);
		}

		// ��� �ű��
		for (int i=0; i<Cho.length-1; i++)
		{
			for (int j=i+1; j<Cho.length; j++)
			{
				if (fl_su[i].ft_tot < fl_su[j].ft_tot)
				{
					(fl_su[i].ft_rank)++;
				}
				else if (fl_su[i].ft_tot > fl_su[j].ft_tot)
				{
					(fl_su[j].ft_rank)++;
				}
			}
		}

		for (int i=0; i<Cho.length-1; i++)
		{
			for (int j=i+1; j<Cho.length; j++)
			{
					
				if (fl_su[i].ft_tot < fl_su[j].ft_tot)
				{
					Flower_tot temp = fl_su[i];
					fl_su[i] = fl_su[j];
					fl_su[j] = temp;
				}

			}
		}

		for (int i=1; i<Cho.length; i++)
		{
			fl_su[i].ft_realrank = fl_su[i-1].ft_realrank;

			if (fl_su[i-1].ft_rank < fl_su[i].ft_rank)
			{
				fl_su[i].ft_realrank++;
			}
		}

		for (int i=0; i<Cho.length; i++)
		{
			if (fl_su[i].ft_realrank <= 3)
				count++;
		}

		count2 = Cho.length - count;

		if (count < count2 && count2 != 0)
		{
			while(true)
			{
				rd1 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
				rd2 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
				rd3 = rd.nextInt(count+Math.abs(count2-count)) + count;	// count ���� 22������ ������ ����

				if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
				break;
			}
		}
		else if(count == count2 && count2 != 0)
		{
			while(true)
			{
				rd1 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
				rd2 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
				rd3 = rd.nextInt(count) + count;	// count ���� 22������ ������ ����

				if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
				break;
			}
		}
		else if(count > count2 && count2 != 0)
		{
			while(true)
			{
				rd1 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
				rd2 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
				rd3 = rd.nextInt(count-Math.abs(count2-count)) + count;	// count ���� 22������ ������ ����

				if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
				break;
			}
		}
		else if(count2 == 0)
		{
				while(true)
				{
					rd1 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
					rd2 = rd.nextInt(count);	// 0���� count-1 ������ ������ ����
					rd3 = rd.nextInt(count);	// count ���� 22������ ������ ����

					if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
					break;
				}
		}
		
			CLIO.clearScreen_10();
			System.out.println("=============================================================");
			System.out.println("                [���� �ɴٹ� ����]         M=�ѷ�����, X=����");
			System.out.println("=============================================================");
			System.out.printf("\n�� %s 4����, %s 4����, %s 2���̰� ���õǾ����ϴ�.%n", fl_su[rd1].ft_name, fl_su[rd2].ft_name, fl_su[rd3].ft_name);
			System.out.println("�� ������ 7õ�� �Դϴ�.");
			System.out.println("=============================================================");
			System.out.println("�� ��ٱ��Ͽ� �����ðڽ��ϱ�?(��Y=�̱⡹��R=�ٽû̱⡹) :");
			CLIO.clearScreen(21);
			String sel = CLIO.S_input();
			switch (sel)
			{
				case "Y" : 
				case "y" : 
					// fl_su2[rd1].setF_su(fl_su2[rd1].getF_su()-4);
					fl_cl_minus(fl_su[rd1].getFt_name(), 4);
					tot_minus(fl_su[rd1].getFt_name(), 4);
					// fl_su2[rd2].setF_su(fl_su2[rd2].getF_su()-4);
					fl_cl_minus(fl_su[rd2].getFt_name(), 4);
					tot_minus(fl_su[rd2].getFt_name(), 4);
					// fl_su2[rd3].setF_su(fl_su2[rd3].getF_su()-2);
					fl_cl_minus(fl_su[rd3].getFt_name(), 2);
					tot_minus(fl_su[rd3].getFt_name(), 2);
					FlowerKiosk.CartDB_list.add(new CartDB("[�����ɴٹ�]" + fl_su[rd1].getFt_name(), 1, 4, 0));
					FlowerKiosk.CartDB_list.add(new CartDB("[�����ɴٹ�]" + fl_su[rd2].getFt_name(), 1, 4, 0));
					FlowerKiosk.CartDB_list.add(new CartDB("[�����ɴٹ�]" + fl_su[rd3].getFt_name(), 1, 2, 7000));
					Money.userCash += 7000;
					Cart.User_Cart();
					return;
				case "R" :
				case "r" :
					continue;
			}
		}

	}
	
	public static void fl_cl_minus(String f_select, int select)
	   {
		   while(true){

		          if(select==0)
		             break;
		            //fl.add(new Flower("����ȭ","1", 50, "2020-03-03"));
		            for(int i =0; i<Cho.fl_cl.size(); i++){
		            
		               if(f_select.equals(Cho.fl_cl.get(i).getF_name())){
		               
		               
		                  if(Cho.fl_cl.get(i).getF_su()-select > 0){
		                 System.out.println("�۴�");
		                     //Cho.fl_cl.get(i).getF_su()-select ������ ����
		                     Cho.fl_cl.get(i).setF_su(Cho.fl_cl.get(i).getF_su()-select);
		                     select=0;
		                     break;
		                     
		                  }else if(Cho.fl_cl.get(i).getF_su()-select==0){
		                	  System.out.println("����");
		                 	Cho.fl_cl.get(i).setF_su(0);
		                 	Cho.fl_cl.get(i).setF_name(null);
		                     select=0;
		                  }else if(Cho.fl_cl.get(i).getF_su()-select<0){
		                     //tot���̶� ��
		                     //Cho.fl_cl.get(i).getF_su()-select ���� �� ���ܵΰ�
		                     //i��° ��ü ������� ���
		                     //������ü �ٽ� ã�� ������ ��� �����մϴ� 
		                     //���� ��ü ã�� �ٽ� ��
		                     if(Cho.tot.get(i).getFt_tot() >= select){
		                   System.out.println("ũ��");
		                        select=select-Cho.fl_cl.get(i).getF_su();
		                        Cho.fl_cl.get(i).setF_su(0);
			                 	Cho.fl_cl.get(i).setF_name(null);
		                        break;
		                     }else {
		                        System.out.println("��� �����մϴ�.");
		                  
		                     }

		                  }

		               }


		            }

		         }
	   
	   }
	
	public static void tot_minus(String f_select, int select)
	   {
		   while(true){

		          if(select==0)
		             break;
		            //fl.add(new Flower("����ȭ","1", 50, "2020-03-03"));
		            for(int i =0; i<Cho.fl_tot_cl.size(); i++){
		            
		               if(f_select.equals(Cho.fl_tot_cl.get(i).getFt_name())){
		               
		               
		                  if(Cho.fl_tot_cl.get(i).getFt_tot()-select > 0){
		                 System.out.println("�۴�");
		                     //Cho.fl_cl.get(i).getF_su()-select ������ ����
		                     Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
		                     select=0;
		                     break;
		                     
		                  }else if(Cho.fl_tot_cl.get(i).getFt_tot()-select==0){
		                	  System.out.println("����");
		                 	Cho.fl_tot_cl.get(i).setFt_tot(0);
		                 	Cho.fl_tot_cl.get(i).setFt_name(null);
		                     select=0;
		                  }else if(Cho.fl_tot_cl.get(i).getFt_tot()-select<0){
		                     //tot���̶� ��
		                     //Cho.fl_cl.get(i).getF_su()-select ���� �� ���ܵΰ�
		                     //i��° ��ü ������� ���
		                     //������ü �ٽ� ã�� ������ ��� �����մϴ� 
		                     //���� ��ü ã�� �ٽ� ��
		                     /*if(Cho.tot.get(i).getFt_tot() >= select){
		                   System.out.println("ũ��");
		                        select=select-Cho.fl_cl.get(i).getF_su();
		                        Cho.fl_cl.get(i).setF_su(0);
			                 	Cho.fl_cl.get(i).setF_name(null);
		                        break;
		                     }else {*/
		                	  
		                        System.out.println("��� �����մϴ�.");
		                  
		                     }

		                  }

		               }


		            }

		         }
	   
	   }
	
	/*
	 setName_��õ(String ���)
	 {
	 	return "��õ�ɴٹ�" + ���;
	 }
	 setName_����(String ������)
	 
	 */

	// (Cho.fl.get(i)).fl_su

	


