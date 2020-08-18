package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;



public class B_DIYFlower
{
	// DIY 메인화면 출력 메소드 
    static void printDIYMenu()
    {  
	  // DIY 메인화면 출력 구문
	  System.out.println("====================================================================================");
	  System.out.println("  [ DIY 꽃다발 ]                                        「M=둘러보기」「X=전체취소」");
	  System.out.println("====================================================================================");
	  System.out.println("------------------------------------------------------------------------------------");
	  System.out.println(" No. |    상품명    |              상품소개(꽃말)             |  가격  |  재고현황  ");
	  System.out.println("------------------------------------------------------------------------------------");
	  
      // 꽃 총 재고량의 정보를 담은 ArrayList tot에서 상품명에 따른 총 재고현황 출력
      for(int i =0; i<Cho.tot.size(); i++)
      {
            System.out.printf("%3s\t%-6s\t%-50s\t%-5d\t%-5d\n",Cho.fl_tot_cl.get(i).getFt_num(),Cho.fl_tot_cl.get(i).getFt_name()	// 상품번호, 상품이름
            												  ,Cho.fl_tot_cl.get(i).getFt_mean(),Cho.fl_tot_cl.get(i).getFt_price() // 꽃말, 상품가격
            												  ,Cho.fl_tot_cl.get(i).getFt_tot());									// 상품재고
      }
      
      // 메인플라워 주문 메소드 호출
      mainFlower();      
    }// end printDIYMenu()

   // 메인플라워 주문 메소드
   static void mainFlower()
   {      
	   // 변수선언
	   boolean flag = false;	// 반복문 제어 변수                                                                     
	   int selectNo = 0;		// 선택한 상품 번호 변수
	   int putSu = 0;			// 입력한 상품 개수 변수
     
	   do{
        	System.out.println("====================================================================================");
            System.out.print(" ▶ 메인플라워를 골라주세요(숫자 입력) : ");	// 메인꽃 선택번호 입력 안내
            
            // 정수 입력 메소드 호출
            selectNo = CLIO.input();   
            // 선택한 상품 번호 유효성 검사 (상품 번호가 1보다 작거나 기존의 상품번호보다 큰 수를 입력하면 "다시 입력해 주세요 " 출력)
	         if(selectNo < 1 || selectNo > Cho.fl_tot_cl.size())
	            System.out.println("다시 입력해주세요");         
         
	   }while( selectNo < 1 || selectNo > Cho.fl_tot_cl.size());

	   	// 입력받은 상품번호와 일치하는 상품의 ArrayList의 인덱스 위치 변수
	   	int idx = 0;

	   	// 입력받은 상품번호와 일치하는 상품의  ArryaList 인덱스 찾는 반복문
	   	for(int i =0; i<Cho.fl_tot_cl.size(); i++){
            if(Integer.parseInt(Cho.fl_tot_cl.get(i).getFt_num()) == selectNo)
            	idx=i; 
         }      
          
	   	do{
	   		// 메인꽃 수량 입력 안내
	   		System.out.print(" ▶ 메인플라워의 수량을 입력해주세요(숫자 입력) : ");
	   		
	   		// 정수 입력 메소드 호출
	   		putSu = CLIO.input(); 
	   		
	   		// 재고가 모자른 경우 
	   		if (putSu>Cho.fl_tot_cl.get(idx).getFt_tot()){
	   			
	   			// 재고가 부족 안내 출력
	   			System.out.println(" ☞ 재고가 모자랍니다. 다시 입력해주세요.");               
	   			System.out.println();
	   			// 다시 입력 받기 위해 반복문 제어 변수 true 담기 
	   			flag = true;                                                        
	   		}
	   	// 입력 받은 수가 재고 보다 크거나 1보다 작을 경우 반복문이 돌아간다.
	   	}while(putSu > Cho.fl_tot_cl.get(idx).getFt_tot() || putSu < 1);

	   	System.out.println(" ☞ "+selectNo+"번 꽃 "+putSu+"송이로 메인플라워 선택 완료!");    
            
	  // 재고 처리해주는 반복문
	  // (선입 선출이 되어야 하므로 fl_cl에서 앞에 상품부터 차례대로 출고 된다.)
	  // 입력 받은 수량이 0일 될 때까지 반복된다.
      while(!(putSu==0)){
    	  
    	  // 반복문이 돌아 갈때 마다 fl_cl에 같은 상품 중 제일 앞에 있는 상품의 인덱스 찾기
          for(int i =0; i<Cho.fl_cl.size(); i++){
        	  if(Integer.parseInt(Cho.fl_cl.get(i).getF_num()) == selectNo){
        		  idx = i;
        		  break;
             }
          } 
          
          // 1. 입력한 상품의 수량보다 재고가 많은 경우
    	  if(Cho.fl_cl.get(idx).getF_su() > putSu){
    		  
    		  // 재고 - 입력수량 을 temp 에 담고 수량을 변경해준다.
	          int temp = Cho.fl_cl.get(idx).getF_su() - putSu;
	          int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
	          Cho.fl_cl.get(idx).setF_su(temp);
	          Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
	          
	          // 사용자가 구매한 상품수량, 이름, 가격을 장바구니에 담는다.
	          FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]" + Cho.fl_cl.get(idx).getF_name(), 1, putSu, Cho.fl_tot_cl.get(idx).getFt_price() * putSu));
	          // 장바구니에 담긴 금액
	          Money.userCash += putSu * Cho.fl_tot_cl.get(idx).getFt_price();
	          // 입력한 수량이 모두 반영 되었으므로 반복문을 빠져나간다.
	          break;
	     
	      // 2. 입력한 상품의 수량과 재고가 같은 경우 
         }else if(Cho.fl_cl.get(idx).getF_su()==putSu){
        	 
        	 // 재고 - 입력수량 을 temp 에 담고 수량을 변경해준다. 
        	 int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-putSu;
        	 Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
        	 
        	 // 더이상 재고가 없으므로 fl_cl에 있는 상품을 제거한다.
        	 Cho.fl_cl.remove(idx);
        	 // 사용자가 구매한 상품수량, 이름, 가격을 장바구니에 담는다.
        	 FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]"+Cho.fl_cl.get(idx).getF_name(),1,putSu,Cho.fl_tot_cl.get(idx).getFt_price()*putSu));
        	 // 장바구니에 담긴 금액
        	 Money.userCash += putSu * Cho.fl_tot_cl.get(idx).getFt_price();
        	// 입력한 수량이 모두 반영 되었으므로 반복문을 빠져나간다.
        	 break;
        	 
         // 3. 입력한 상품의 수량이 재고 보다 적은 경우
         }else if(Cho.fl_cl.get(idx).getF_su()<putSu){
        	 
        	 // 입력수량에 현재 있는 재고를 뺀 수량을 다시 입력 수량에 넣는다 -> putSu가 0이 아니므로 다시 반복문이 돌아간다.
        	 putSu = (putSu - Cho.fl_cl.get(idx).getF_su());
        	 int temp_tot = Cho.fl_tot_cl.get(selectNo-1).getFt_tot()-Cho.fl_cl.get(idx).getF_su();
        	 Cho.fl_tot_cl.get(selectNo-1).setFt_tot(temp_tot);
        	 // 더이상 재고가 없으므로 fl_cl에 있는 상품을 제거한다.
        	 Cho.fl_cl.remove(idx);
        	 // 사요자가 구매한 상품수량, 이름, 가격을 장바구니에 담는다.
        	 FlowerKiosk.CartDB_list.add(new CartDB("[DIY꽃다발_메인]" + Cho.fl_cl.get(idx).getF_name(), 1, putSu, Cho.fl_tot_cl.get(idx).getFt_price() * putSu));
        	 // 장바구니에 담긴 금액
        	 Money.userCash += putSu * Cho.fl_tot_cl.get(idx).getFt_price();
            
         }
      
            
      }//while 문
      
      // 서브플라워 주문 메소드 호출
      subFlower();
     
                                                              

   }//end mainFlower()
   
   //서브 플라워 주문 메소드
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