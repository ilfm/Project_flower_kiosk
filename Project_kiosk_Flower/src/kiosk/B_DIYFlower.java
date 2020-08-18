package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;



public class B_DIYFlower
{
	// DIY ����ȭ�� ��� �޼ҵ� 
    static void printDIYMenu()
    {  
	  // DIY ����ȭ�� ��� ����
	  System.out.println("====================================================================================");
	  System.out.println("  [ DIY �ɴٹ� ]                                        ��M=�ѷ����⡹��X=��ü��ҡ�");
	  System.out.println("====================================================================================");
	  System.out.println("------------------------------------------------------------------------------------");
	  System.out.println(" No. |    ��ǰ��    |              ��ǰ�Ұ�(�ɸ�)             |  ����  |  �����Ȳ  ");
	  System.out.println("------------------------------------------------------------------------------------");
	  
      // �� �� ����� ������ ���� ArrayList tot���� ��ǰ�� ���� �� �����Ȳ ���
      for(int i =0; i<Cho.tot.size(); i++)
      {
            System.out.printf("%3s\t%-6s\t%-50s\t%-5d\t%-5d\n",Cho.fl_tot_cl.get(i).getFt_num(),Cho.fl_tot_cl.get(i).getFt_name()	// ��ǰ��ȣ, ��ǰ�̸�
            												  ,Cho.fl_tot_cl.get(i).getFt_mean(),Cho.fl_tot_cl.get(i).getFt_price() // �ɸ�, ��ǰ����
            												  ,Cho.fl_tot_cl.get(i).getFt_tot());									// ��ǰ���
      }
      
      // �����ö�� �ֹ� �޼ҵ� ȣ��
      mainFlower();      
    }// end printDIYMenu()

   // �����ö�� �ֹ� �޼ҵ�
   static void mainFlower()
   {      
	   // ��������
	   boolean flag = false;	// �ݺ��� ���� ����                                                                     
	   int selectNo = 0;		// ������ ��ǰ ��ȣ ����
	   int putSu = 0;			// �Է��� ��ǰ ���� ����
     
	   do{
        	System.out.println("====================================================================================");
            System.out.print(" �� �����ö���� ����ּ���(���� �Է�) : ");	// ���β� ���ù�ȣ �Է� �ȳ�
            
            // ���� �Է� �޼ҵ� ȣ��
            selectNo = CLIO.input();   
            // ������ ��ǰ ��ȣ ��ȿ�� �˻� (��ǰ ��ȣ�� 1���� �۰ų� ������ ��ǰ��ȣ���� ū ���� �Է��ϸ� "�ٽ� �Է��� �ּ��� " ���)
	         if(selectNo < 1 || selectNo > Cho.fl_tot_cl.size())
	            System.out.println("�ٽ� �Է����ּ���");         
         
	   }while( selectNo < 1 || selectNo > Cho.fl_tot_cl.size());

	   	// �Է¹��� ��ǰ��ȣ�� ��ġ�ϴ� ��ǰ�� ArrayList�� �ε��� ��ġ ����
	   	int idx = 0;

	   	// �Է¹��� ��ǰ��ȣ�� ��ġ�ϴ� ��ǰ��  ArryaList �ε��� ã�� �ݺ���
	   	for(int i =0; i<Cho.fl_tot_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_tot_cl.get(i).getFt_num()) == selectNo)
            	idx=i; 
         }      
          
	   	do{
	   		// ���β� ���� �Է� �ȳ�
	   		System.out.print(" �� �����ö���� ������ �Է����ּ���(���� �Է�) : ");
	   		
	   		// ���� �Է� �޼ҵ� ȣ��
	   		putSu = CLIO.input(); 
	   		
	   		// ��� ���ڸ� ��� 
	   		if (putSu>Cho.fl_tot_cl.get(idx).getFt_tot()){
	   			
	   			// ��� ���� �ȳ� ���
	   			System.out.println(" �� ��� ���ڶ��ϴ�. �ٽ� �Է����ּ���.");               
	   			System.out.println();
	   			// �ٽ� �Է� �ޱ� ���� �ݺ��� ���� ���� true ��� 
	   			flag = true;                                                        
	   		}
	   	// �Է� ���� ���� ��� ���� ũ�ų� 1���� ���� ��� �ݺ����� ���ư���.
	   	}while(putSu > Cho.fl_tot_cl.get(idx).getFt_tot() || putSu < 1);

	   	System.out.println(" �� "+selectNo+"�� �� "+putSu+"���̷� �����ö�� ���� �Ϸ�!");    
            
	  // ��� ó�����ִ� �ݺ���
	  // (���� ������ �Ǿ�� �ϹǷ� fl_cl���� �տ� ��ǰ���� ���ʴ�� ��� �ȴ�.)
	  // �Է� ���� ������ 0�� �� ������ �ݺ��ȴ�.
      while(!(putSu==0)){
    	  
    	  // �ݺ����� ���� ���� ���� fl_cl�� ���� ��ǰ �� ���� �տ� �ִ� ��ǰ�� �ε��� ã��
          for(int i =0; i<Cho.fl_cl.size(); i++){
        	  if(Integer.parseInt(Cho.fl_cl.get(i).getF_num()) == selectNo){
        		  idx = i;
        		  break;
             }
          } 
          
          // 1. �Է��� ��ǰ�� �������� ��� ���� ���
    	  if(Cho.fl_cl.get(idx).getF_su() > putSu){
    		  
    		  // ��� - �Է¼��� �� temp �� ��� ������ �������ش�.
	          int temp = Cho.fl_cl.get(idx).getF_su() - putSu;
	          int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
	          Cho.fl_cl.get(idx).setF_su(temp);
	          Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
	          
	          // ����ڰ� ������ ��ǰ����, �̸�, ������ ��ٱ��Ͽ� ��´�.
	          FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]" + Cho.fl_cl.get(idx).getF_name(), 1, putSu, Cho.fl_tot_cl.get(idx).getFt_price() * putSu));
	          // ��ٱ��Ͽ� ��� �ݾ�
	          Money.userCash += putSu * Cho.fl_tot_cl.get(idx).getFt_price();
	          // �Է��� ������ ��� �ݿ� �Ǿ����Ƿ� �ݺ����� ����������.
	          break;
	     
	      // 2. �Է��� ��ǰ�� ������ ��� ���� ��� 
         }else if(Cho.fl_cl.get(idx).getF_su()==putSu){
        	 
        	 // ��� - �Է¼��� �� temp �� ��� ������ �������ش�. 
        	 int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
        	 Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
        	 
        	 // ���̻� ��� �����Ƿ� fl_cl�� �ִ� ��ǰ�� �����Ѵ�.
        	 Cho.fl_cl.remove(idx);
        	 // ����ڰ� ������ ��ǰ����, �̸�, ������ ��ٱ��Ͽ� ��´�.
        	 FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
        	 // ��ٱ��Ͽ� ��� �ݾ�
        	 Money.userCash += putSu * Cho.fl_tot_cl.get(idx).getFt_price();
        	// �Է��� ������ ��� �ݿ� �Ǿ����Ƿ� �ݺ����� ����������.
        	 break;
        	 
         // 3. �Է��� ��ǰ�� ������ ��� ���� ���� ���
         }else if(Cho.fl_cl.get(idx).getF_su()<putSu){
        	 
        	 // �Է¼����� ���� �ִ� ��� �� ������ �ٽ� �Է� ������ �ִ´� -> putSu�� 0�� �ƴϹǷ� �ٽ� �ݺ����� ���ư���.
        	 putSu = (putSu - Cho.fl_cl.get(idx).getF_su());
        	 int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-Cho.fl_cl.get(idx).getF_su();
        	 Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
        	 // ���̻� ��� �����Ƿ� fl_cl�� �ִ� ��ǰ�� �����Ѵ�.
        	 Cho.fl_cl.remove(idx);
        	 // ����ڰ� ������ ��ǰ����, �̸�, ������ ��ٱ��Ͽ� ��´�.
        	 FlowerKiosk.CartDB_list.add(new CartDB("[DIY�ɴٹ�_����]" + Cho.fl_cl.get(idx).getF_name(), 1, putSu, Cho.fl_tot_cl.get(idx).getFt_price() * putSu));
        	 // ��ٱ��Ͽ� ��� �ݾ�
        	 Money.userCash += putSu * Cho.fl_tot_cl.get(idx).getFt_price();
            
         }
      
            
      }//while ��
      
      // �����ö�� �ֹ� �޼ҵ� ȣ��
      subFlower();
     
                                                              

   }//end mainFlower()
   
   //���� �ö�� �ֹ� �޼ҵ�
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