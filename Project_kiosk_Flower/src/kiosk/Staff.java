package kiosk;
import java.util.*;
import java.io.*;


class Staff
{
	                                                   
   private static final String STF_ID="4team";      //������ ID
   private static final String STF_PW = "123456789";// ������ PW
   private static int stf_sel;  //�޴� ���� ���� ��ȣ �޼ҵ�

   //--����������
   

   //--������ �α���
   public static void stf_login() 
   {   
      Scanner sc = new Scanner(System.in);

      String id="";
      String pw="";
	  CLIO.clearScreen_10();	
      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER �����ڷα���]                                      ��X = �����ϱ� ��");
      System.out.println("================================================================================");
      System.out.println();


      //�Է¹޴� id�� STF_ID ���� ��(�ƴҰ��...) �ݺ�
      while(!(id.equals(STF_ID) && pw.equals(STF_PW)))
      {
      
         System.out.print("�� ���̵� �Է�:");
         id = sc.next();
         
         //"X"&"x" �ϰ�� ����ó���� ���� ���� �޼ҵ� ���
         if(id.equals("X") || id.equals("x"))
        	 throw new s_MainException();

         System.out.print("�� ��й�ȣ �Է�:");
         pw = sc.next();
         
         //"X"&"x" �ϰ�� ����ó���� ���� ���� �޼ҵ� ���
         if(pw.equals("X") || pw.equals("x"))
        	 throw new s_MainException();

         //ID�� PW�� �ԷµǴ� ���� STF_ID/PW������ ����� ������ �ٸ����
         if(!(id.equals(STF_ID) && pw.equals(STF_PW)))
         System.out.println(" �� �߸� �Է��ϼ̽��ϴ�. ");
         System.out.println();
      }
      
      //ȭ�� ����� �޼ҵ� ȣ��
      clearScreen();

      //������ ���� ȭ�� �޼ҵ� ȣ��
      stf_menuDisp();

      System.out.println("================================================================================");
       
   }//end login�޼ҵ�
   
   //--- Staff �޴�
   class Stf_Menus
   {
	   private static final int STF_STACK= 1; //������ �޼ҵ�     
	   private static final int STF_MONEY = 2; //�ܰ���� �޼ҵ�          
      
   }
   
   //--- �����ڸ���ȭ��
   public static void stf_menuDisp()
   {
	   try
	   {
		   System.out.println("================================================================================");
		   System.out.println("[SMART FLOWER �����ڸ��]                                      ��X = �����ϱ� ��");
		   System.out.println("================================================================================");
		   System.out.println();
		   System.out.println("                                  1.��� ����");
		   System.out.println();
		   System.out.println("                                  2.�ܰ� ����");
		   System.out.println();
		   System.out.println("================================================================================");
		   System.out.println();

		   //�ܰ� ���� �� ȣ��
		   exc_Print();

		   //������� ����(������)��ǰ ���
		   stf_FExp_Del_print();
      
		   //��� ���� �޼ҵ� ȣ��
		   shortage();

		   //�޴� ���ø޼ҵ� ȣ�� 
		   stf_menuSelect();
	   }

      catch(s_MainException  m)
      {

         //ȭ�� ���� �޼ҵ�
         clearScreen();

         //���� �޼ҵ� ȣ��
         A_Main.cus_maindisp();
         A_Main.cus_maininput();
      }
   }//stf_menuDisp �޼ҵ� ���� 



   //--������ ȭ�� ���� �޼ҵ�
   public static void stf_menuSelect()
   {
      do{
         try
         {   System.out.println();
            System.out.print("�� ��� �������� �̵��Ͻðڽ��ϱ�? (���� �Է�) : ");
            stf_sel = input();

            //stf_sel������ 1�̳� 2�� �ƴϸ�..
            if(!(stf_sel==1 || stf_sel==2 ))
            {
                System.out.println(" �� ���� �޴��Դϴ� ��");                        
            }
         }

         //���� �̿ܿ� ���ڰ� ������ ����ó���� ���� �ݺ� ���
         catch (NumberFormatException n)
         {
            System.out.println("�� �ٽ� �Է����ּ��� ��");
            continue;
         } 

      //stf_sel������ 1�̳� 2�� �ƴϸ�..
      }while(!(stf_sel==1 || stf_sel==2 ));

      //�޴��� ȣ��
      stf_menuRun();
               
   }//stf_menuSelect �޼ҵ� ����

   //--������ ȭ�� ���õ� �޴� ���࿡ ���� ��� ȣ�� �޼ҵ�
   public static void stf_menuRun()
   {
     
      switch(stf_sel)
      {   
         //stf_sel�� ������ ���� STF_STACK�̸�  Ŭ���� ��ũ�� �޼ҵ� ȣ�� �� ������ �޼ҵ� ȣ�� 
         case Stf_Menus.STF_STACK: clearScreen();stf_StackDisp(); break;

         //stf_sel�� ������ ���� STF_MONEY�̸�  Ŭ���� ��ũ�� �޼ҵ� ȣ�� �� �ܰ���� �޼ҵ� ȣ�� 
         case Stf_Menus.STF_MONEY: clearScreen();stf_Money(); break;     
      }
   }

   //--������ ��� ����
   public static void stf_StackDisp() 
   {   
      //select ���� ����
      int select = 0;
      
      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER �� ��� ����]                     ��M = ������ ���Ρ� / ��X = �����ϱ⡹");
      System.out.println("================================================================================");
      System.out.println();
      System.out.println("                              1 . ��ǰ ���� ");
      System.out.println("                              2 . ������� ����");
      System.out.println();
	  CLIO.clearScreen(21);

      do
      {
         try
         {
         System.out.println();
         System.out.print("�� ��� �������� �̵��Ͻðڽ��ϱ�? (���� �Է�) : ");
         select = input();
         

         if(!(select==1 || select==2))
         System.out.println(" �� ���� �޴��Դϴ� ��");
         System.out.println();
         }
         
         //�����̿ܿ� ���ڰ� ������ continue�� ���� try�� ���
         catch(NumberFormatException n)
         {

            System.out.println("�� �ٽ� �Է����ּ���");   
            continue;
         
         }
      
     }while (!(select==1 || select==2));
      stf_StackRun(select); 

   }//stf_StackDisp ������ �޴����� �޼ҵ� ����
   
   //--������ �޴� �� �޼ҵ�
   public static void stf_StackRun(int select) 
    {
      
      switch(select)
        {   
         //select���� 1�̸� stf_FStackPrint() �޼ҵ� ȣ��
         case 1: stf_FStackPrint(); break;
            //select���� 2�̸� stf_FExp() �޼ҵ� ȣ��
         case 2: stf_FExp(); break;        
        }
    }
   public static void stf_FStackPrint()
   {
	   System.out.println("================================================================================");
	   System.out.println("[SMART FLOWER �� ��� ����]              ��M = ������ ���Ρ� / ��X = �����ϱ⡹");
       System.out.println("================================================================================");
       System.out.println();
       System.out.println("                              [�� ��� ��Ȳ]                                                 ");
       System.out.println("                     [No.]\t [��ǰ��]             [��������]  ");
       System.out.println();
      
      //������������ tot ArrayList ����
      Collections.sort(Cho.tot, Cho.mc);
      
      //�� ��� ��¹�
      Iterator<Flower_tot> it = Cho.tot.iterator();
         
         //it������ ����� ����Ҹ� �˻��ϸ� ������Ұ� ������ ��������
         while(it.hasNext())
         {

         Flower_tot to = it.next();
         System.out.printf("                       %-1s\t %-20s\t %-4d \n" ,to.getFt_num(),to.getFt_name(),to.getFt_tot());

         }

         System.out.println();
         System.out.println("                           [�߰����� ��� ��Ȳ]                                                  ");
         System.out.println();
         System.out.printf("\t\t\t1.   �޼���ī��\t:     %d\n",Cho.adp_ob.getMsg() );
         System.out.printf("\t\t\t2.     �ٱ���\t:     %d\n", Cho.adp_ob.getBasket());
         System.out.printf("\t\t\t3.     ������\t:     %d\n",Cho.adp_ob.getPaper() );
         System.out.printf("\t\t\t4.     ����\t:     %d\n",Cho.adp_ob.getRibbon() );
         System.out.printf("\t\t\t5.     �̴ϲɴٹ�\t:     %d\n",Cho.adp_ob.getMiniflo() );
         System.out.println();
         System.out.println("================================================================================");

         int select = 0 ;

                  System.out.println(" 1 . ��� �߰�  ");
                  System.out.println(" 2 . ���ο� ��ǰ�׸� �߰�");
                  System.out.println(" 3 . ���� ��ǰ�׸� ���� ");
         
         //stf_sel�� 1 �Ǵ�2 �Ǵ� 3�� ��� ����
         while(stf_sel==1 || stf_sel==2 || stf_sel==3)
         {
            try
            {
                  System.out.print("�� ��� �������� �̵��Ͻðڽ��ϱ�? (���� �Է�) : ");
                  select = input();
                  
                  //stf_sel�� 1�Ǵ� 2�Ǵ� 3�ƴҰ��...
                  if(!(stf_sel==1 || stf_sel==2 || stf_sel==3))
                  {
                   System.out.println(" �� ���� �޴��Դϴ� ��");
                   System.out.println();   
                  }
                  
                  switch(select)
                  {
                     // '1'��� stf_FStack()�޼ҵ� ȣ��
                     case 1: stf_FStack(); break;
                     
                     // '2'��� stf_ItemAdd()�޼ҵ� ȣ��
                     case 2: stf_ItemAdd();break;
                     
                     // '3'��� stf_ItemDel()�޼ҵ� ȣ��
                     case 3: stf_ItemDel();break;
                  }            
            }

            //M�� �ԷµǸ� ������ �������� �̵� �� cleanScreen/stf_menuDisp�޼ҵ� ȣ�� 
            catch(StaffMainException e)
            {
                  clearScreen();
                  stf_menuDisp();
                  
            }

            //���� �̿ܿ� ���ڰ� ������ ����ó���� ���� �ݺ� ���
            catch(NumberFormatException n)
            {

                  System.out.println("�� �ٽ� �Է����ּ���");   
                  continue;
            }

         }      

   }//stf_FStackPrint �� �����Ȳ �� �߰����� �޼ҵ� ����

   // ��ǰ �׸� �߰� �޼ҵ�
   public static void  stf_ItemAdd()
   {
      
	   try
	   {      
		   String select = "";     // �׸� �߰� ����
		   boolean check = false; // �ߺ� �׸� ����
		   String temp_item;     // ���ο� �߰� �׸� ����
         
           do{        	   
		        select = "";
		        // �׸� �߰� ���� �Է� �ݺ���
		        while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
		        {
		           // �׸��� �߰� �Ͻðڽ��ϱ�? �ȳ��� ���
		           System.out.print("�� �׸��� �߰� �Ͻðڽ��ϱ�?( Y / N) :");
		           select = s_input();
		              
		           // �Է°��� N�̳� n�� ��� ������ �������� ���ư���. 
		           if(select.equals("N") || select.equals("n"))
		        	   throw new StaffMainException();
		        }
		        // �׸� �ߺ� ���� �ݺ���
	            do{   
	            	check = false;
	            	// "�߰��� �Ҹ��� �̸��� �Է����ּ���" �ȳ��� ���
			        System.out.print("�� �߰��� �׸��� �̸��� �Է����ּ��� :");
			        temp_item =s_input().trim();
			        
			        // ��ǰ �ߺ� üũ 
			        for(int i = 0; i < Cho.tot.size()-1 ; i++)
			        {
			        	// �̸��� �ִٸ� check = true �ٽ� �Է� �޾ƾ� �Ѵ�.
			        	if(temp_item.equals(Cho.tot.get(i).getFt_name()))
			        		check = true;			
			        }
			        
			        if(check == true)
			        System.out.println(" �� �ٽ� �Է����ּ���");            
	
	            }while(check);
                     
	            //���ο� ���� �׸��� �߰�
	            Cho.tot.add(new Flower_tot(temp_item)); 

	            System.out.print("�� �߰��� �׸��� �ɸ��� �Է����ּ��� :");
	            String temp_mean =s_input().trim();
	           
	            // ������ �ε����� �ɸ����� �Է� 
                Cho.tot.get(Cho.tot.size()-1).setFt_mean(temp_mean);
                
                // ��ǰ ���� �Է� �ݺ���
	            while(true)
	            {
	               try
	               {
	                  System.out.print("�� �׸��� ������ �Է����ּ��� :");
	                  int temp_price =input();
	                  Cho.tot.get(Cho.tot.size()-1).setFt_price(temp_price);
	                  break;
	               }	               
	               //���� �̿ܿ� ���ڰ� ������ ����ó�� �߻� continue�� ���� try �� ���
	               catch(NumberFormatException n1)
	               {
	                  System.out.println("�ٽ� �Է����ּ���");
	                  continue;            
	               }
	            }

               String temp_num ="";
               temp_num += Cho.tot.size();
               Cho.tot.get(Cho.tot.size()-1).setFt_num(temp_num);

         }while(select.equals("Y") || select.equals("y"));
           
      }
      // M�� �ԷµǸ� ������ �������� �̵� �� cleanScreen/���Ű� main�޼ҵ� ȣ�� 
      catch(s_MainException m)
      {
    	  System.out.println("�������� ���ư��ϴ�.");
    	  clearScreen();
    	  A_Main.cus_maindisp();  
          A_Main.cus_maininput();
      }
   }// end stf_ItemAdd()

   //������ �׸� ���� �޼ҵ�
   public static void stf_ItemDel()
   {
      
      int idx = 0;
      boolean flag = true;
      String select="Y";      //�׸� ���� �޼ҵ�
      String temp_item="";

      do{
         try{
                  select="";
                  while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
                  {
                     
                     System.out.print("�� �׸��� ���� �Ͻðڽ��ϱ�?( Y / N) ");
                     select = s_input();

                        if(select.equals("n") || select.equals("N"))
                           throw new StaffMainException();
                  }
                  do{
                     System.out.print("�� ������ �׸��� �̸��� �Է����ּ���");
                     temp_item =s_input();
                     for(int i =0; i<Cho.tot.size(); i++)
                     {
                        //temp_item�� �ԷµǴ� �׸��� tot�� �׸� �ִ��� Ȯ���ϰ� ������ �����ȴ� 
                        if(temp_item.equals(Cho.tot.get(i).getFt_name()))
                        {
                           Cho.tot.remove(i);
                           //flag�� �ƴϸ�.. while������ ����������.
                           flag=false;         
                        }                        
                     }
                     if(flag==true)
                           System.out.println("�ٽ� �Է����ּ���");

                  }while(flag);

                  //�Է��� �׸��� tot�� �׸� ������ �׸���� ���.
                  System.out.println(temp_item +" "+"�׸��� ���� �Ǿ����ϴ�.");
            }

            //877�� while�� �ȿ� if�� ������ �����ϸ� ������ �������� �̵��� �� clearScreen() / stf_menuDisp()�޼ҵ� ȣ��
            catch(StaffMainException sm)
            {
                  clearScreen();
                  stf_menuDisp();      
      
            }

            //877�� while�� �ȿ� if�� ������ �����ϸ� ������ �������� �̵��� �� clearScreen() / main()�޼ҵ� ȣ��
            catch(s_MainException m)
            {
                  clearScreen();
                  A_Main.cus_maindisp();
                  A_Main.cus_maininput();
            }
            
         }while(select.equals("Y") || select.equals("y"));
   }


   //--������ ��� ���� �޼ҵ�
   public static void stf_FStack()
   {
      String select=""; //stringŸ�� select���� ����
      String temp=""; //��� ������ ������ ���� temp����
        int temp_Su=0;   //��� ����
        String temp_wareDate="";//��������� �԰�¥ ����
      boolean check= true; //������ �׸��� tot�� ������ �ִ��� ��ġ�ϴ��� Ȯ���ϴº���
        Scanner sc = new Scanner(System.in);
      int flag=0;


   //do- while ��
   do{   
         select="";
         while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
         {
            System.out.print("�� ��� ä��ðڽ��ϱ�? (Y / N) :");
            select = s_input();            
         }

         try
         {
            if(select.equals("N") || select.equals("n"))
               throw new StaffMainException();
         }
         //950�� if������ �����Ǹ� ����ó���� ���� clearScreen() ����� stf_menuDisp() �޼ҵ� ���
         catch(StaffMainException e)
         {
            clearScreen();
            stf_menuDisp();
         }// do-while ��� ä��ðڽ��ϱ� ��
         do{   

            System.out.print("�� ������ ������ �Է����ּ��� :");
            temp =s_input().trim();
         
            for(int i = 0; i < Cho.tot.size()-1 ; i++)
            {
               if(temp.equals(Cho.tot.get(i).getFt_name()))
               {
                  check=false;
                  flag= 0;
                  Cho.fl.add(new Flower(temp));      
               } 

            }
            if(temp.equals("�޼���ī��"))
            {
                  check=false;
                  flag =1;
            }
            
            else if(temp.equals("������"))
            {
                  check=false;
                  flag =2;   
            }
            
            else if(temp.equals("����"))
            {
                  check=false;
                  flag =3;      
            }

            else if(temp.equals("�ٱ���"))
            {
                  check=false;
                  flag =4;                  
            }else if(temp.equals("�̴ϲɴٹ�")) {
            	
            	  check=false;
            	  flag = 5;
            }

            //967�� �Է¹��� temp���� tot�� ���� ������ ���
            if(check==true)
               System.out.println(" �� �������� ���� ��ǰ�Դϴ� ��");
            
         }while(check);
                                                                                                               //������ ���� �ݺ� ��¹�
         while(true)
         {
            try
            {
            System.out.print("�� ������ ������ �Է����ּ��� :");               
            temp_Su = input();
               
               if(flag==0)
               {
                  Cho.fl.get(Cho.fl.size()-1).setF_su(temp_Su);
               }

               else if(flag==1)
               {
                  int temp_adp=Cho.adp_ob.getMsg()+temp_Su;
                  Cho.adp_ob.setMsg(temp_adp);
               }

               else if(flag==2)
               {
                  int temp_adp =Cho.adp_ob.getPaper()+temp_Su;
                  Cho.adp_ob.setPaper(temp_adp);
               }
               
               else if(flag==3)
               {
                  int temp_adp = Cho.adp_ob.getRibbon()+temp_Su;
                  Cho.adp_ob.setRibbon(temp_adp);
               }
               
               else if(flag==4)
               {
                  int temp_adp =Cho.adp_ob.getBasket()+temp_Su;
                  Cho.adp_ob.setBasket(temp_adp);
               }else if(flag==5)
               {
                   int temp_adp =Cho.adp_ob.getMiniflo()+temp_Su;
                   Cho.adp_ob.setMiniflo(temp_adp);
                }
            break;
            }
            //���ڰ� ������ "�ٽ��Է����ּ��� ���" continue������ try �����
            catch(NumberFormatException n)
            {
               System.out.println("�ٽ� �Է����ּ���");
               continue;
            }

         }
         int flag2=0;                                                                                                               //�԰�¥ �ݺ� ��¹�                        
         while(temp_wareDate.length()!=10 || flag2==0)
         {
            try
            {   
                  if(flag==1 ||flag==2 ||flag==3 ||flag==4 ||flag==5)
                  {
                     System.out.printf("%s %d�� �߰� �Ϸ�!\n",temp,temp_Su);
                     flag2=1;
                     break;
                     
                  }
                  else
                  {                  
                     System.out.print("�� �԰�¥�� �Է����ּ���(����:2020-03-03) :");
                     temp_wareDate = s_input();

                     if(temp_wareDate.length()==10)
                     {
                        Cho.fl.get(Cho.fl.size()-1).setF_wareDate(temp_wareDate);
                        System.out.printf("%s %d�� �߰� �Ϸ�!\n",Cho.fl.get(Cho.fl.size()-1).getF_name(),Cho.fl.get(Cho.fl.size()-1).getF_su());
                        break;
                     }
                     else
                     {
                        System.out.println("�� �ٽ� �Է����ּ��� ��");
                     }
                  }   
            }
            catch(NumberFormatException n)
            {
               System.out.println("�� �ٽ� �Է����ּ��� ��");
               continue;
            }
         }   
                                                                                                                              //�Է� ���� temp�� ��� �ִ��� Ȯ���ϱ�
         int idx=0;

            for(int i =0; i<Cho.tot.size(); i++)
            {
               
               if(Cho.tot.get(i).getFt_name().equals(temp))
               {
                   idx = i;
               }
            }

         //tot DB���� ������Ʈ         
         //System.out.println(Cho.tot.get(idx).getFt_tot());
         Cho.tot.get(idx).setFt_tot(temp_Su +Cho.tot.get(idx).getFt_tot());
         //System.out.println(Cho.tot.get(idx).getFt_tot());
         System.out.println("================================================================================");

      }while(select.equals("Y")||select.equals("y"));
    }

   //--������� ���� ��ǰ ������ִ� �޼ҵ�
   public static void stf_FExp_Del_print()
   {
	   //Calendar Ŭ���� ��� �ν��Ͻ� ���� (����ð��� ���� ��ü)
	   Calendar rightNow = Calendar.getInstance();
	   String nowDate = "";
	   //����ð� 
	   nowDate += rightNow.get(Calendar.YEAR);
	   nowDate += 0;
	   nowDate += (rightNow.get(Calendar.MONTH) + 1);
	   nowDate += rightNow.get(Calendar.DATE);

	   //������ ��� ��¹�
	   System.out.println();
	   System.out.println("\t\t\t      ��[ ������ ��� ]��");         //"%d %-6s\t%-6s\t\n"
	   System.out.println();
	   System.out.println("\t\t[ ��ǰ�� ]    [ �԰�� ��¥ ]     [����]"); 
	   System.out.println();

	   String temp_ware="";
      
	   for(int i =0; i<Cho.fl.size()-1; i++)
	   {
		   String[] a = (Cho.fl.get(i).getF_wareDate()).split("-");
		   for(int j = 0; j<a.length; j++)
		   {
			   temp_ware+= a[j];   //2020 03 20   //20200320 
		   }

		   if((Integer.parseInt(nowDate) - Integer.parseInt(temp_ware) >=7) )     //Ÿ�̸ӷ� �Ϸ翡 �ѹ� üũ���ֱ�
			   System.out.printf("\t\t%-6s\t%-10s\t    %-10s\t\n",Cho.fl.get(i).getF_name(),Cho.fl.get(i).getF_wareDate(),Cho.fl.get(i).getF_su());   
		   temp_ware="";   
      }
      System.out.println();
      System.out.println("================================================================================");          
   }








   //--������� ���� �޼ҵ�
   public static void stf_FExp()
   {

      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER ������� ����]      ��M = ������ ���Ρ� / ��X = �����ϱ⡹");
      System.out.println("================================================================================");
      System.out.println();
      System.out.println("[��ǰ��]          [�԰� ��¥]     [����]    [���� ����]");
      System.out.println();
         
         for(int i = 0; i<Cho.fl.size(); i++)
         {
            System.out.printf("%-6s\t%-6s\t%3d��\t%6d��\t\n",Cho.fl.get(i).getF_name() ,Cho.fl.get(i).getF_wareDate(),Cho.fl.get(i).getF_su(),Cho.fl.get(i).getF_count());
         }
         System.out.println("================================================================================");
         System.out.println();
         System.out.println("                      1. ������� ���� ���� ������ ���� ");//-------���� ������� ���� �� �������,,?
         System.out.println("                      2. ������� ���� ���� ������ ���� ");
         System.out.println();

     int select=0;   
      do{   
         try{

         System.out.print("�� �޴��� �Է����ּ��� (���� �Է�) : ");
         select = input();

         if(select==1)
         {
            Collections.sort(Cho.fl, Cho.mc2);
            stf_FExp();   
         }

         else if(select==2)
         {
            Collections.sort(Cho.fl, Cho.mc3);
            stf_FExp();   
            
         }

         }catch(NumberFormatException ne)

            {
               System.out.println(" �� �ٽ� �Է����ּ���");   
            }

         }while(select!=1 || select!=2);
   }
   //-- �ܵ� ���� �޼ҵ�
   public static void stf_Money()
   {
      
      Scanner sc = new Scanner(System.in);

      String select="";
      int temp_1000=0;
      int temp_5000=0;
      int temp_10000=0;
      
      
      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER �ܵ� ����]      ��M = ������ ���Ρ� / ��X = �����ϱ⡹");
      System.out.println("================================================================================");
      System.out.println();
      System.out.println("                              [����]        [����]       ");
      System.out.println();
        
      System.out.println("                            �� 1000��"  +"          "+ Cho.money.getExc_1000());
      System.out.println();
      System.out.println("                            �� 5000��"  +"          "+ Cho.money.getExc_5000());
      System.out.println();
      System.out.println("                            �� 10000��" +"         "+ Cho.money.getExc_10000());
      System.out.println(); 
      System.out.println("================================================================================");
	  CLIO.clearScreen(16);
      
      //�ܵ����� �� �� ��� �޼ҵ�
        exc_Print();
        
      do{
           select="";
         while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
         {
            System.out.print("�� �ܰ� ä��ðڽ��ϱ�?(Y/N):");
            select = s_input();
            if(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
            {
               System.out.println("�ٽ� �Է����ּ���");
            }
         }

         //n�� �������� ���      ��   ������ �������� ���ư���
         if(select.equals("N") || select.equals("n"))
         {
            clearScreen();
            stf_menuDisp();
         }
         
         //�ٸ� ���ڸ� �Է� ������� �ٽ� �Է� �ޱ� ���� ���� ó��
            try
         {

            System.out.print("�� ������ ������ �Է����ּ��� 1000����:");
            temp_1000 =input();         
            Cho.money.addExc_1000(temp_1000);
         System.out.print("�� ������ ������ �Է����ּ��� 5000����:");
            temp_5000 = input();
            Cho.money.addExc_5000(temp_5000);
         System.out.print("�� ������ ������ �Է����ּ��� 10000����:");
            temp_10000 = input();
            Cho.money.addExc_10000(temp_10000);
         
         //������ �ܰ��� ���� ���ϰ� ���� ���� ����
         int tot = (temp_1000*1000)+(temp_5000*5000)+(temp_10000*10000);
         
         //�����Ϸ� �ȳ��� ���
         System.out.printf("1000����  %d��, 5000����  %d��, 10000����  %d��   ----> �� %d�� �����Ϸ� ",temp_1000,temp_5000,temp_10000,tot);   
         System.out.println();


         }
         catch(NumberFormatException n)
         {
         
            System.out.println("�ٽ� �Է����ּ���.");
            continue;
            
         }
         
        }while(select.equals("Y") || select.equals("y"));   
        
   }
   
   //--- �ܰ� �����Ҷ� ��� �޼ҵ�
   public static void exc_Print()//-----------------------------------------------------------**�ܰ� �����մϴٷθ� �ϴϱ� �ɽ��ؼ� ������ ���� �ٿ��� �����غþ��...
    {
      if(Cho.money.getExc_1000() <10 || Cho.money.getExc_tot()<50000)
      {
         
         System.out.println("                                ��[ �ܰ� ���� ]��");
         System.out.println();

         if(Cho.money.getExc_1000() <10)
            System.out.println("                             1000���� �ܰ� �����մϴ�.");
         else if(Cho.money.getExc_tot()<50000)
            System.out.println("                             �Ž����� �Ѿ��� 5���� �����Դϴ�.");
   
         System.out.println();
         System.out.println("================================================================================");
         }
    }
   //--- ��� ���� ��� �޼ҵ�
   public static void shortage()
   {
      
      System.out.println();
      System.out.println("                                ��[ ��� ���� ]��");
      System.out.println();
      for(int i = 0 ; i < 3; i++)
      {
         System.out.printf("%40s\n",Cho.tot.get(i).getFt_name());
         System.out.println();
      }

      System.out.println();
      System.out.println("                                ������ �����մϴ�.");
      System.out.println("================================================================================");

   }
   
   //--- int input �޼ҵ�
   public static int input()
    {
      Scanner sc = new Scanner(System.in);
      // ����� �Է� �޾ƿ�
      String select = sc.next();
      
      // �Է� ���� M �Ǵ� m �� ��� 
      if(select.equals("M")  || select.equals("m"))
     {
         throw new StaffMainException();
      }
     
     else if(select.equals("X")  || select.equals("x")) 
     {
         throw new s_MainException();
      }

      int temp = Integer.parseInt(select);
      return temp;

      
    }
   //--- int String �޼ҵ�
   public static String s_input()   //��M = ������ ���Ρ� / ��X = �����ϱ⡹
    {
      Scanner sc = new Scanner(System.in);
      String select=sc.next();

      if(select.equals("M")  || select.equals("m"))
      {
         throw new StaffMainException();

      }

      else if(select.equals("X")  || select.equals("x"))
      {
         throw new s_MainException();
      }
      return select;
    }
   //����޼ҵ�      fl.add(new Flower("�������","4", 50, 20200312));
   public static List<Flower> boksa(List<Flower> list)
   {
      
      List<Flower> temp = new ArrayList<Flower>();

      for(int i=0; i< list.size(); i++)
     {

         temp.add(new Flower(list.get(i).getF_name(),list.get(i).getF_num() , list.get(i).getF_su() ,list.get(i).getF_wareDate()));
         
      }

      return temp;      

   }
   public static List<Flower_tot> boksa2(List<Flower_tot> list)
   {
      
      List<Flower_tot> temp = new ArrayList<Flower_tot>();

      for(int i=0; i< list.size(); i++)
      {

         temp.add(new Flower_tot(list.get(i).getFt_num(),list.get(i).getFt_name() , list.get(i).getFt_tot() ,list.get(i).getFt_price(),list.get(i).getFt_mean()));
         //tring ft_num , String ft_name ,int ft_tot,int ft_price,String ft_mean
      }

      return temp;      

   }
   //������� ���� ��ǰ �������ִ� �޼ҵ�
   public static void stf_FExp_Del()
   {
      
      //Calendar Ŭ���� ��� �ν��Ͻ� ���� (����ð��� ���� ��ü)
      Calendar rightNow = Calendar.getInstance();
      String nowDate = "";
      //����ð� 
      nowDate += rightNow.get(Calendar.YEAR);
      nowDate += 0;
      nowDate += (rightNow.get(Calendar.MONTH) + 1);
      nowDate += rightNow.get(Calendar.DATE);

      
      String temp_ware="";
      
      for(int i =0; i<Cho.fl.size()-1; i++)
      {
         String[] a = (Cho.fl.get(i).getF_wareDate()).split("-");
         for(int j = 0; j<a.length; j++)
         {
            temp_ware= temp_ware + a[j];   //2020 03 20   //20200320 
         }

         if((Integer.parseInt(nowDate) - Integer.parseInt(temp_ware) >=7) )     //Ÿ�̸ӷ� �Ϸ翡 �ѹ� üũ���ֱ�
            Cho.fl.remove(i);
               
         temp_ware="";      
      }       
   }
     
	 //�Ϸ翡 �ѹ� ������� count�� 1�� �����ϰ�  ������� 7�� ���� ��ǰ �ڵ� �������ִ� �޼ҵ�
	 public static void stf_CheckExp(){
         
		 // �ð��� ���� �Ҽ� �ְ� Calendar �� �����Ѵ�.
         Calendar cal = Calendar.getInstance();
         // ���� �� �ð��� �����Ѵ�.
         cal.set(2020,8,10,16,18); 
        
         
         //�ּ�Ǯ�ԵǸ� count�� �ϳ��� �پ�� �ϴ� �ּ�ó��
         Timer m_timer = new Timer();
         TimerTask m_task = new TimerTask(){
         
         @Override
            public void run(){
        	 
               //ī��Ʈ -1���ִ� �κ�
               System.out.println("����");
               for(int i =0; i<Cho.fl.size(); i++)
                  Cho.fl.get(i).setF_count((Cho.fl.get(i).getF_count()-1));
               
               //������� ���� ��ǰ �����ִ� �Լ� ȣ��
               stf_FExp_Del();               
            }
         };

        m_timer.scheduleAtFixedRate(m_task,cal.getTime(),8000);
      
   }

   public static void clearScreen()
   {
      for(int i =0; i<40; i++)
      {
         
         System.out.println("                                                                                                                        ");
      }
   }
   



}//end Staff class
//�������� ���� ���� ó�� Ŭ����
class s_MainException extends RuntimeException
{

}
//������ �������� ���� ���� ó�� Ŭ����
class StaffMainException extends RuntimeException
{

}
