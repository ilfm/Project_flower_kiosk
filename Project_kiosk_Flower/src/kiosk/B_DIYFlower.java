package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;



public class B_DIYFlower
{

   static void printDIYMenu()
    {   
      System.out.println("====================================================================================");
      System.out.println("  [ DIY 꽃다발 ]                                        「M=둘러보기」「X=전체취소」");
      System.out.println("====================================================================================");
      System.out.println("------------------------------------------------------------------------------------");
      System.out.println(" No. |    상품명    |              상품소개(꽃말)             |  가격  |  재고현황  ");
      System.out.println("------------------------------------------------------------------------------------");
      
      for(int i =0; i<Cho.tot.size(); i++)
      {
            System.out.printf("%3s\t%-6s\t%-50s\t%-5d\t%-5d\n",Cho.tot.get(i).getFt_num(),Cho.tot.get(i).getFt_name(),Cho.tot.get(i).getFt_mean(),Cho.tot.get(i).getFt_price(),Cho.fl_tot_cl.get(i).getFt_tot());
      }
      mainFlower();
      
   }

    // 메인플라워 주문 메소드
   static void mainFlower()
   {      
      boolean flag=false;                                                                     // 반복문 제어 변수 설정
     int selectNo=0;
     int putSu=0;
     
        do{
			System.out.println("====================================================================================");
            System.out.print(" ▶ 메인플라워를 골라주세요(숫자 입력) : ");                              // 메인꽃 선택번호 입력 안내
            selectNo=CLIO.input();   
         
         if(selectNo<1 || selectNo>Cho.fl_tot_cl.size()){
            System.out.println("다시 입력해주세요");
         }
      }while( selectNo<1 || selectNo>Cho.fl_tot_cl.size());

      int idx=0;

      for(int i =0; i<Cho.fl_tot_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_tot_cl.get(i).getFt_num()) == selectNo){
               idx=i;
            }
         }      
          
      do{
         System.out.print(" ▶ 메인플라워의 수량을 입력해주세요(숫자 입력) : ");               // 메인꽃 수량 입력 안내
         putSu=CLIO.input(); 

       //재고가 모자르다면
       if (putSu>Cho.fl_tot_cl.get(idx).getFt_tot()){
         System.out.println(" ☞ 재고가 모자랍니다. 다시 입력해주세요.");               
         System.out.println();
         flag=true;                                                        
        }

      }while(putSu>Cho.fl_tot_cl.get(idx).getFt_tot() || putSu<1);

       System.out.println(" ☞ "+selectNo+"번 꽃 "+putSu+"송이로 메인플라워 선택 완료!"); 

      
      
      
      //재고 처리해주는 반복문
      while(!(putSu==0)){

         //인덱스 찾기
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
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()==putSu){
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()<putSu){
            putSu = (putSu - Cho.fl_cl.get(idx).getF_su());
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-Cho.fl_cl.get(idx).getF_su();
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            
         }
       //FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
     // Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            
      }//while 문
      subFlower();
     
                                                              

   }//mainFlower()
   
   //서브 플라워 메소드
   public static void subFlower(){


     boolean flag = false;                                                                     // 반복문 제어 변수 설정
     int selectNo=0;
     int putSu=0;
     String select="";
     int idx=0;
     
     //System.out.println(f_cl.size());
     
      
      do{
         select="n";
         do{
            System.out.print(" ▶ 서브플라워를 골라주세요(숫자 입력) : ");                              // 메인꽃 선택번호 입력 안내
            selectNo=CLIO.input();   

            
            if(selectNo<1 || selectNo>Cho.fl_tot_cl.size()){
               System.out.println("다시 입력해주세요");
            }

            if(Cho.fl_tot_cl.get(selectNo-1).getFt_tot()==0){
               System.out.println("재고가 없습니다. 다른 꽃을 선택해주세요");
            }


         }while( selectNo<1 || selectNo>Cho.fl_tot_cl.size() || (Cho.fl_tot_cl.get(selectNo-1).getFt_tot()==0));

         //selectNo 인덱스 찾기
         for(int i =0; i<Cho.fl_tot_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_tot_cl.get(i).getFt_num()) == selectNo){
               idx=i;
            }
         }      
           
         do{

             System.out.print(" ▶ 서브플라워의 수량을 입력해주세요(숫자 입력) : ");               // 메인꽃 수량 입력 안내
             putSu=CLIO.input(); 

             //재고가 모자르다면
             if (putSu>Cho.fl_tot_cl.get(idx).getFt_tot()){
               System.out.println(" ☞ 재고가 모자랍니다. 다시 입력해주세요.");               
               System.out.println();
               flag=true;                                                        
             }

         }while(putSu>Cho.fl_tot_cl.get(idx).getFt_tot());

         System.out.println(" ☞ "+selectNo+"번 꽃 "+putSu+"송이로 서브플라워 선택 완료!"); 
      
      //재고 처리해주는 반복문
      while(!(putSu==0)){

         //인덱스 찾기
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
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_서브]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()==putSu){
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_서브]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            break;
         }else if(Cho.fl_cl.get(idx).getF_su()<putSu){
            putSu = (putSu - Cho.fl_cl.get(idx).getF_su());
            int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-Cho.fl_cl.get(idx).getF_su();
            Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
            Cho.fl_cl.remove(idx);
            FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_서브]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
            Money.userCash+=putSu*Cho.fl_tot_cl.get(idx).getFt_price();
            
         }

      }


		System.out.print(" ☞ 서브플라워를 더 선택하시겠습니까(Y/N)? : ");
		select=CLIO.S_input();
		if(select.equals("n")|| select.equals("N")){  
			System.out.println("현재 금액 : "+Money.userCash);
		System.out.println("결제 화면으로 넘어갑니다");

          }

   }while(select.equals("Y") ||select.equals("y"));
   Cart.User_Cart();
   }

}