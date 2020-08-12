package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;



public class B_DIYFlower
{

   static void printDIYMenu()
    {   
      System.out.println("====================================================================================");
      System.out.println("  [ DIY �ɴٹ� ]                                        ��M=�ѷ����⡹��X=��ü��ҡ�");
      System.out.println("====================================================================================");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println(" No. |    ��ǰ��    |              ��ǰ�Ұ�(�ɸ�)             |  ����  |  �����Ȳ  ");
      System.out.println("------------------------------------------------------------------------------------");
      
      for(int i =0; i<Cho.tot.size(); i++)
      {
            System.out.printf("%3s\t%-6s\t%-50s\t%-5d\t%-5d\n",Cho.tot.get(i).getFt_num(),Cho.tot.get(i).getFt_name(),Cho.tot.get(i).getFt_mean(),Cho.tot.get(i).getFt_price(),Cho.fl_tot_cl.get(i).getFt_tot());
      }
      mainFlower();
      
   }

    // �����ö�� �ֹ� �޼ҵ�
   static void mainFlower()
   {      
      boolean flag=false;                                                                     // �ݺ��� ���� ���� ����
     int selectNo=0;
     int putSu=0;
     
        do{
			System.out.println("====================================================================================");
            System.out.print(" �� �����ö���� ����ּ���(���� �Է�) : ");                              // ���β� ���ù�ȣ �Է� �ȳ�
            selectNo=CLIO.input();   
         
         if(selectNo<1 || selectNo>Cho.fl_tot_cl.size()){
            System.out.println("�ٽ� �Է����ּ���");
         }
      }while( selectNo<1 || selectNo>Cho.fl_tot_cl.size());

      int idx=0;

      for(int i =0; i<Cho.fl_tot_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_tot_cl.get(i).getFt_num()) == selectNo){
               idx=i;
            }
         }      
          
      do{
         System.out.print(" �� �����ö���� ������ �Է����ּ���(���� �Է�) : ");               // ���β� ���� �Է� �ȳ�
         putSu=CLIO.input(); 

       //��� ���ڸ��ٸ�
       if (putSu>Cho.fl_tot_cl.get(idx).getFt_tot()){
         System.out.println(" �� ��� ���ڶ��ϴ�. �ٽ� �Է����ּ���.");               
         System.out.println();
         flag=true;                                                        
        }

      }while(putSu>Cho.fl_tot_cl.get(idx).getFt_tot() || putSu<1);

       System.out.println(" �� "+selectNo+"�� �� "+putSu+"���̷� �����ö�� ���� �Ϸ�!"); 

      
      
      
      //��� ó�����ִ� �ݺ���
      while(!(putSu==0)){

         //�ε��� ã��
         for(int i =0; i<Cho.fl_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_cl.get(i).getF_num()) == selectNo){
               idx=i;
               break;
            }
         }         
            
         if(Cho.fl_cl.get(idx).getF_su()>putSu){
            int temp = Cho.fl_cl.get(idx).getF_su() - putSu;
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
            Cho.fl_cl.get(idx).setF_su(temp);
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()==putSu){
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()<putSu){
            putSu = (putSu - Cho.fl_cl.get(idx).getF_su());
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-Cho.fl_cl.get(idx).getF_su();
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            
         }
       //FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
     // Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            
      }//while ��
      subFlower();
     
                                                              

   }//mainFlower()
   
   //���� �ö�� �޼ҵ�
   public static void subFlower(){


     boolean flag = false;                                                                     // �ݺ��� ���� ���� ����
     int selectNo=0;
     int putSu=0;
     String select="";
     int idx=0;
     
     //System.out.println(f_cl.size());
     
      
      do{
         select="n";
         do{
            System.out.print(" �� �����ö���� ����ּ���(���� �Է�) : ");                              // ���β� ���ù�ȣ �Է� �ȳ�
            selectNo=CLIO.input();   

            
            if(selectNo<1 || selectNo>Cho.fl_tot_cl.size()){
               System.out.println("�ٽ� �Է����ּ���");
            }

            if(Cho.fl_tot_cl.get(selectNo-1).getFt_tot()==0){
               System.out.println("��� �����ϴ�. �ٸ� ���� �������ּ���");
            }


         }while( selectNo<1 || selectNo>Cho.fl_tot_cl.size() || (Cho.fl_tot_cl.get(selectNo-1).getFt_tot()==0));

         //selectNo �ε��� ã��
         for(int i =0; i<Cho.fl_tot_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_tot_cl.get(i).getFt_num()) == selectNo){
               idx=i;
            }
         }      
           
         do{

             System.out.print(" �� �����ö���� ������ �Է����ּ���(���� �Է�) : ");               // ���β� ���� �Է� �ȳ�
             putSu=CLIO.input(); 

             //��� ���ڸ��ٸ�
             if (putSu>Cho.fl_tot_cl.get(idx).getFt_tot()){
               System.out.println(" �� ��� ���ڶ��ϴ�. �ٽ� �Է����ּ���.");               
               System.out.println();
               flag=true;                                                        
             }

         }while(putSu>Cho.fl_tot_cl.get(idx).getFt_tot());

         System.out.println(" �� "+selectNo+"�� �� "+putSu+"���̷� �����ö�� ���� �Ϸ�!"); 
      
      //��� ó�����ִ� �ݺ���
      while(!(putSu==0)){

         //�ε��� ã��
         for(int i =0; i<Cho.fl_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_cl.get(i).getF_num()) == selectNo){
               idx=i;
              
            }
         }         
            
         if(Cho.fl_cl.get(idx).getF_su()>putSu){
            int temp = Cho.fl_cl.get(idx).getF_su() - putSu;
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.get(idx).setF_su(temp);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()==putSu){
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()<putSu){
            putSu = (putSu - Cho.fl_cl.get(idx).getF_su());
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-Cho.fl_cl.get(idx).getF_su();
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            
         }

      }


		System.out.print(" �� �����ö���� �� �����Ͻðڽ��ϱ�(Y/N)? : ");
		select=CLIO.S_input();
		if(select.equals("n")|| select.equals("N")){  
			System.out.println("���� �ݾ� : "+Money.userCash);
		System.out.println("���� ȭ������ �Ѿ�ϴ�");

          }

   }while(select.equals("Y") ||select.equals("y"));
   Cart.User_Cart();
   }

}