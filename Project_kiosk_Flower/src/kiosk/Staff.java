package kiosk;
import java.util.*;
import java.io.*;


class Staff
{
	                                                   
   private static final String STF_ID="4team";      //관리자 ID
   private static final String STF_PW = "123456789";// 관리자 PW
   private static int stf_sel;  //메뉴 진입 선택 번호 메소드

   //--메인페이지
   

   //--관리자 로그인
   public static void stf_login() 
   {   
      Scanner sc = new Scanner(System.in);

      String id="";
      String pw="";
	  CLIO.clearScreen_10();	
      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER 관리자로그인]                                      「X = 종료하기 」");
      System.out.println("================================================================================");
      System.out.println();


      //입력받는 id와 STF_ID 변수 비교(아닐경우...) 반복
      while(!(id.equals(STF_ID) && pw.equals(STF_PW)))
      {
      
         System.out.print("▶ 아이디 입력:");
         id = sc.next();
         
         //"X"&"x" 일경우 예외처리를 통한 메인 메소드 출력
         if(id.equals("X") || id.equals("x"))
        	 throw new s_MainException();

         System.out.print("▶ 비밀번호 입력:");
         pw = sc.next();
         
         //"X"&"x" 일경우 예외처리를 통한 메인 메소드 출력
         if(pw.equals("X") || pw.equals("x"))
        	 throw new s_MainException();

         //ID와 PW에 입력되는 값이 STF_ID/PW변수에 저장된 정보와 다를경우
         if(!(id.equals(STF_ID) && pw.equals(STF_PW)))
         System.out.println(" ※ 잘못 입력하셨습니다. ");
         System.out.println();
      }
      
      //화면 지우는 메소드 호출
      clearScreen();

      //관리자 메인 화면 메소드 호출
      stf_menuDisp();

      System.out.println("================================================================================");
       
   }//end login메소드
   
   //--- Staff 메뉴
   class Stf_Menus
   {
	   private static final int STF_STACK= 1; //재고관리 메소드     
	   private static final int STF_MONEY = 2; //잔고관리 메소드          
      
   }
   
   //--- 관리자메인화면
   public static void stf_menuDisp()
   {
	   try
	   {
		   System.out.println("================================================================================");
		   System.out.println("[SMART FLOWER 관리자모드]                                      「X = 종료하기 」");
		   System.out.println("================================================================================");
		   System.out.println();
		   System.out.println("                                  1.재고 관리");
		   System.out.println();
		   System.out.println("                                  2.잔고 관리");
		   System.out.println();
		   System.out.println("================================================================================");
		   System.out.println();

		   //잔고 없을 때 호출
		   exc_Print();

		   //유통기한 지난(삭제된)상품 출력
		   stf_FExp_Del_print();
      
		   //재고 부족 메소드 호출
		   shortage();

		   //메뉴 선택메소드 호출 
		   stf_menuSelect();
	   }

      catch(s_MainException  m)
      {

         //화면 정리 메소드
         clearScreen();

         //메인 메소드 호출
         A_Main.cus_maindisp();
         A_Main.cus_maininput();
      }
   }//stf_menuDisp 메소드 종료 



   //--관리자 화면 선택 메소드
   public static void stf_menuSelect()
   {
      do{
         try
         {   System.out.println();
            System.out.print("▶ 어느 페이지로 이동하시겠습니까? (숫자 입력) : ");
            stf_sel = input();

            //stf_sel변수가 1이나 2가 아니면..
            if(!(stf_sel==1 || stf_sel==2 ))
            {
                System.out.println(" ※ 없는 메뉴입니다 ※");                        
            }
         }

         //숫자 이외에 문자가 들어오면 예외처리를 통한 반복 출력
         catch (NumberFormatException n)
         {
            System.out.println("☞ 다시 입력해주세요 ※");
            continue;
         } 

      //stf_sel변수가 1이나 2가 아니면..
      }while(!(stf_sel==1 || stf_sel==2 ));

      //메뉴런 호출
      stf_menuRun();
               
   }//stf_menuSelect 메소드 종료

   //--관리자 화면 선택된 메뉴 실행에 따른 기능 호출 메소드
   public static void stf_menuRun()
   {
     
      switch(stf_sel)
      {   
         //stf_sel에 들어오는 값이 STF_STACK이면  클리어 스크린 메소드 호출 및 재고관리 메소드 호출 
         case Stf_Menus.STF_STACK: clearScreen();stf_StackDisp(); break;

         //stf_sel에 들어오는 값이 STF_MONEY이면  클리어 스크린 메소드 호출 및 잔고관리 메소드 호출 
         case Stf_Menus.STF_MONEY: clearScreen();stf_Money(); break;     
      }
   }

   //--관리자 재고 관리
   public static void stf_StackDisp() 
   {   
      //select 변수 선언
      int select = 0;
      
      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER 꽃 재고 관리]                     「M = 관리자 메인」 / 「X = 종료하기」");
      System.out.println("================================================================================");
      System.out.println();
      System.out.println("                              1 . 상품 관리 ");
      System.out.println("                              2 . 유통기한 관리");
      System.out.println();
	  CLIO.clearScreen(21);

      do
      {
         try
         {
         System.out.println();
         System.out.print("▶ 어느 페이지로 이동하시겠습니까? (숫자 입력) : ");
         select = input();
         

         if(!(select==1 || select==2))
         System.out.println(" ※ 없는 메뉴입니다 ※");
         System.out.println();
         }
         
         //숫자이외에 문자가 들어오면 continue를 통해 try재 출력
         catch(NumberFormatException n)
         {

            System.out.println("☞ 다시 입력해주세요");   
            continue;
         
         }
      
     }while (!(select==1 || select==2));
      stf_StackRun(select); 

   }//stf_StackDisp 재고관리 메뉴선택 메소드 종료
   
   //--관리자 메뉴 런 메소드
   public static void stf_StackRun(int select) 
    {
      
      switch(select)
        {   
         //select값이 1이면 stf_FStackPrint() 메소드 호출
         case 1: stf_FStackPrint(); break;
            //select값이 2이면 stf_FExp() 메소드 호출
         case 2: stf_FExp(); break;        
        }
    }
   public static void stf_FStackPrint()
   {
	   System.out.println("================================================================================");
	   System.out.println("[SMART FLOWER 꽃 재고 관리]              「M = 관리자 메인」 / 「X = 종료하기」");
       System.out.println("================================================================================");
       System.out.println();
       System.out.println("                              [꽃 재고 현황]                                                 ");
       System.out.println("                     [No.]\t [상품명]             [남은수량]  ");
       System.out.println();
      
      //오름차순으로 tot ArrayList 정렬
      Collections.sort(Cho.tot, Cho.mc);
      
      //꽃 재고 출력문
      Iterator<Flower_tot> it = Cho.tot.iterator();
         
         //it변수에 저장된 모든요소를 검색하며 다음요소가 없으면 멈춰진다
         while(it.hasNext())
         {

         Flower_tot to = it.next();
         System.out.printf("                       %-1s\t %-20s\t %-4d \n" ,to.getFt_num(),to.getFt_name(),to.getFt_tot());

         }

         System.out.println();
         System.out.println("                           [추가구매 재고 현황]                                                  ");
         System.out.println();
         System.out.printf("\t\t\t1.   메세지카드\t:     %d\n",Cho.adp_ob.getMsg() );
         System.out.printf("\t\t\t2.     바구니\t:     %d\n", Cho.adp_ob.getBasket());
         System.out.printf("\t\t\t3.     포장지\t:     %d\n",Cho.adp_ob.getPaper() );
         System.out.printf("\t\t\t4.     리본\t:     %d\n",Cho.adp_ob.getRibbon() );
         System.out.printf("\t\t\t5.     미니꽃다발\t:     %d\n",Cho.adp_ob.getMiniflo() );
         System.out.println();
         System.out.println("================================================================================");

         int select = 0 ;

                  System.out.println(" 1 . 재고 추가  ");
                  System.out.println(" 2 . 새로운 상품항목 추가");
                  System.out.println(" 3 . 기존 상품항목 삭제 ");
         
         //stf_sel이 1 또는2 또는 3일 경우 실행
         while(stf_sel==1 || stf_sel==2 || stf_sel==3)
         {
            try
            {
                  System.out.print("▶ 어느 페이지로 이동하시겠습니까? (숫자 입력) : ");
                  select = input();
                  
                  //stf_sel이 1또는 2또는 3아닐경우...
                  if(!(stf_sel==1 || stf_sel==2 || stf_sel==3))
                  {
                   System.out.println(" ※ 없는 메뉴입니다 ※");
                   System.out.println();   
                  }
                  
                  switch(select)
                  {
                     // '1'경우 stf_FStack()메소드 호출
                     case 1: stf_FStack(); break;
                     
                     // '2'경우 stf_ItemAdd()메소드 호출
                     case 2: stf_ItemAdd();break;
                     
                     // '3'경우 stf_ItemDel()메소드 호출
                     case 3: stf_ItemDel();break;
                  }            
            }

            //M이 입력되면 관리자 메인으로 이동 후 cleanScreen/stf_menuDisp메소드 호출 
            catch(StaffMainException e)
            {
                  clearScreen();
                  stf_menuDisp();
                  
            }

            //숫자 이외에 문자가 들어오면 예외처리를 통한 반복 출력
            catch(NumberFormatException n)
            {

                  System.out.println("☞ 다시 입력해주세요");   
                  continue;
            }

         }      

   }//stf_FStackPrint 꽃 재고현황 및 추가구매 메소드 종료

   // 상품 항목 추가 메소드
   public static void  stf_ItemAdd()
   {
      
	   try
	   {      
		   String select = "";     // 항목 추가 변수
		   boolean check = false; // 중복 항목 변수
		   String temp_item;     // 새로운 추가 항목 변수
         
           do{        	   
		        select = "";
		        // 항목 추가 여부 입력 반복문
		        while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
		        {
		           // 항목을 추가 하시겠습니까? 안내문 출력
		           System.out.print("▶ 항목을 추가 하시겠습니까?( Y / N) :");
		           select = s_input();
		              
		           // 입력값이 N이나 n일 경우 관리자 메인으로 돌아간다. 
		           if(select.equals("N") || select.equals("n"))
		        	   throw new StaffMainException();
		        }
		        // 항목 중복 여부 반복문
	            do{   
	            	check = false;
	            	// "추가할 할목의 이름을 입력해주세요" 안내문 출력
			        System.out.print("▶ 추가할 항목의 이름을 입력해주세요 :");
			        temp_item =s_input().trim();
			        
			        // 상품 중복 체크 
			        for(int i = 0; i < Cho.tot.size()-1 ; i++)
			        {
			        	// 이름이 있다면 check = true 다시 입력 받아야 한다.
			        	if(temp_item.equals(Cho.tot.get(i).getFt_name()))
			        		check = true;			
			        }
			        
			        if(check == true)
			        System.out.println(" ※ 다시 입력해주세요");            
	
	            }while(check);
                     
	            //새로운 꽃의 항목을 추가
	            Cho.tot.add(new Flower_tot(temp_item)); 

	            System.out.print("▶ 추가할 항목의 꽃말을 입력해주세요 :");
	            String temp_mean =s_input().trim();
	           
	            // 마지막 인덱스에 꽃말정보 입력 
                Cho.tot.get(Cho.tot.size()-1).setFt_mean(temp_mean);
                
                // 상품 가격 입력 반복문
	            while(true)
	            {
	               try
	               {
	                  System.out.print("▶ 항목의 가격을 입력해주세요 :");
	                  int temp_price =input();
	                  Cho.tot.get(Cho.tot.size()-1).setFt_price(temp_price);
	                  break;
	               }	               
	               //숫자 이외에 문자가 들어오면 예외처리 발생 continue를 통해 try 재 출력
	               catch(NumberFormatException n1)
	               {
	                  System.out.println("다시 입력해주세요");
	                  continue;            
	               }
	            }

               String temp_num ="";
               temp_num += Cho.tot.size();
               Cho.tot.get(Cho.tot.size()-1).setFt_num(temp_num);

         }while(select.equals("Y") || select.equals("y"));
           
      }
      // M이 입력되면 관리자 메인으로 이동 후 cleanScreen/구매가 main메소드 호출 
      catch(s_MainException m)
      {
    	  System.out.println("메인으로 돌아갑니다.");
    	  clearScreen();
    	  A_Main.cus_maindisp();  
          A_Main.cus_maininput();
      }
   }// end stf_ItemAdd()

   //관리자 항목 삭제 메소드
   public static void stf_ItemDel()
   {
      
      int idx = 0;
      boolean flag = true;
      String select="Y";      //항목 삭제 메소드
      String temp_item="";

      do{
         try{
                  select="";
                  while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
                  {
                     
                     System.out.print("▶ 항목을 삭제 하시겠습니까?( Y / N) ");
                     select = s_input();

                        if(select.equals("n") || select.equals("N"))
                           throw new StaffMainException();
                  }
                  do{
                     System.out.print("▶ 삭제할 항목의 이름을 입력해주세요");
                     temp_item =s_input();
                     for(int i =0; i<Cho.tot.size(); i++)
                     {
                        //temp_item에 입력되는 항목이 tot의 항목에 있는지 확인하고 있으면 삭제된다 
                        if(temp_item.equals(Cho.tot.get(i).getFt_name()))
                        {
                           Cho.tot.remove(i);
                           //flag로 아니면.. while밖으로 빠져나간다.
                           flag=false;         
                        }                        
                     }
                     if(flag==true)
                           System.out.println("다시 입력해주세요");

                  }while(flag);

                  //입력한 항목이 tot의 항목에 있으면 항목삭제 출력.
                  System.out.println(temp_item +" "+"항목이 삭제 되었습니다.");
            }

            //877번 while문 안에 if문 조건이 성립하면 관리자 메인으로 이동된 후 clearScreen() / stf_menuDisp()메소드 호출
            catch(StaffMainException sm)
            {
                  clearScreen();
                  stf_menuDisp();      
      
            }

            //877번 while문 안에 if문 조건이 성립하면 관리자 메인으로 이동된 후 clearScreen() / main()메소드 호출
            catch(s_MainException m)
            {
                  clearScreen();
                  A_Main.cus_maindisp();
                  A_Main.cus_maininput();
            }
            
         }while(select.equals("Y") || select.equals("y"));
   }


   //--관리자 재고 관리 메소드
   public static void stf_FStack()
   {
      String select=""; //string타입 select변수 선언
      String temp=""; //재고 투입할 종류를 담을 temp변수
        int temp_Su=0;   //재고 수량
        String temp_wareDate="";//재고투입한 입고날짜 변수
      boolean check= true; //투입할 항목이 tot에 정보에 있는지 일치하는지 확인하는변수
        Scanner sc = new Scanner(System.in);
      int flag=0;


   //do- while 문
   do{   
         select="";
         while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
         {
            System.out.print("▶ 재고를 채우시겠습니까? (Y / N) :");
            select = s_input();            
         }

         try
         {
            if(select.equals("N") || select.equals("n"))
               throw new StaffMainException();
         }
         //950번 if조건이 성립되면 예외처리를 통한 clearScreen() 출력후 stf_menuDisp() 메소드 출력
         catch(StaffMainException e)
         {
            clearScreen();
            stf_menuDisp();
         }// do-while 재고 채우시겠습니까 끝
         do{   

            System.out.print("▶ 투입할 종류를 입력해주세요 :");
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
            if(temp.equals("메세지카드"))
            {
                  check=false;
                  flag =1;
            }
            
            else if(temp.equals("포장지"))
            {
                  check=false;
                  flag =2;   
            }
            
            else if(temp.equals("리본"))
            {
                  check=false;
                  flag =3;      
            }

            else if(temp.equals("바구니"))
            {
                  check=false;
                  flag =4;                  
            }else if(temp.equals("미니꽃다발")) {
            	
            	  check=false;
            	  flag = 5;
            }

            //967번 입력받은 temp값이 tot의 값에 없으면 출력
            if(check==true)
               System.out.println(" ※ 존재하지 않은 상품입니다 ※");
            
         }while(check);
                                                                                                               //투입할 개수 반복 출력문
         while(true)
         {
            try
            {
            System.out.print("▶ 투입할 개수를 입력해주세요 :");               
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
            //문자가 들어오면 "다시입력해주세요 출력" continue로인한 try 재출력
            catch(NumberFormatException n)
            {
               System.out.println("다시 입력해주세요");
               continue;
            }

         }
         int flag2=0;                                                                                                               //입고날짜 반복 출력문                        
         while(temp_wareDate.length()!=10 || flag2==0)
         {
            try
            {   
                  if(flag==1 ||flag==2 ||flag==3 ||flag==4 ||flag==5)
                  {
                     System.out.printf("%s %d개 추가 완료!\n",temp,temp_Su);
                     flag2=1;
                     break;
                     
                  }
                  else
                  {                  
                     System.out.print("▶ 입고날짜를 입력해주세요(예시:2020-03-03) :");
                     temp_wareDate = s_input();

                     if(temp_wareDate.length()==10)
                     {
                        Cho.fl.get(Cho.fl.size()-1).setF_wareDate(temp_wareDate);
                        System.out.printf("%s %d개 추가 완료!\n",Cho.fl.get(Cho.fl.size()-1).getF_name(),Cho.fl.get(Cho.fl.size()-1).getF_su());
                        break;
                     }
                     else
                     {
                        System.out.println("※ 다시 입력해주세요 ※");
                     }
                  }   
            }
            catch(NumberFormatException n)
            {
               System.out.println("※ 다시 입력해주세요 ※");
               continue;
            }
         }   
                                                                                                                              //입력 받은 temp가 어디에 있는지 확인하기
         int idx=0;

            for(int i =0; i<Cho.tot.size(); i++)
            {
               
               if(Cho.tot.get(i).getFt_name().equals(temp))
               {
                   idx = i;
               }
            }

         //tot DB에도 업데이트         
         //System.out.println(Cho.tot.get(idx).getFt_tot());
         Cho.tot.get(idx).setFt_tot(temp_Su +Cho.tot.get(idx).getFt_tot());
         //System.out.println(Cho.tot.get(idx).getFt_tot());
         System.out.println("================================================================================");

      }while(select.equals("Y")||select.equals("y"));
    }

   //--유통기한 지난 상품 출력해주는 메소드
   public static void stf_FExp_Del_print()
   {
	   //Calendar 클래스 기반 인스턴스 생성 (현재시간을 위한 객체)
	   Calendar rightNow = Calendar.getInstance();
	   String nowDate = "";
	   //현재시간 
	   nowDate += rightNow.get(Calendar.YEAR);
	   nowDate += 0;
	   nowDate += (rightNow.get(Calendar.MONTH) + 1);
	   nowDate += rightNow.get(Calendar.DATE);

	   //삭제된 재고 출력문
	   System.out.println();
	   System.out.println("\t\t\t      ▶[ 삭제된 재고 ]◀");         //"%d %-6s\t%-6s\t\n"
	   System.out.println();
	   System.out.println("\t\t[ 상품명 ]    [ 입고된 날짜 ]     [수량]"); 
	   System.out.println();

	   String temp_ware="";
      
	   for(int i =0; i<Cho.fl.size()-1; i++)
	   {
		   String[] a = (Cho.fl.get(i).getF_wareDate()).split("-");
		   for(int j = 0; j<a.length; j++)
		   {
			   temp_ware+= a[j];   //2020 03 20   //20200320 
		   }

		   if((Integer.parseInt(nowDate) - Integer.parseInt(temp_ware) >=7) )     //타이머로 하루에 한번 체크해주기
			   System.out.printf("\t\t%-6s\t%-10s\t    %-10s\t\n",Cho.fl.get(i).getF_name(),Cho.fl.get(i).getF_wareDate(),Cho.fl.get(i).getF_su());   
		   temp_ware="";   
      }
      System.out.println();
      System.out.println("================================================================================");          
   }








   //--유통기한 관리 메소드
   public static void stf_FExp()
   {

      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER 유통기한 관리]      「M = 관리자 메인」 / 「X = 종료하기」");
      System.out.println("================================================================================");
      System.out.println();
      System.out.println("[상품명]          [입고 날짜]     [수량]    [남은 기한]");
      System.out.println();
         
         for(int i = 0; i<Cho.fl.size(); i++)
         {
            System.out.printf("%-6s\t%-6s\t%3d개\t%6d일\t\n",Cho.fl.get(i).getF_name() ,Cho.fl.get(i).getF_wareDate(),Cho.fl.get(i).getF_su(),Cho.fl.get(i).getF_count());
         }
         System.out.println("================================================================================");
         System.out.println();
         System.out.println("                      1. 유통기한 적게 남은 순으로 보기 ");//-------좀더 고급지게 말할 수 없을까요,,?
         System.out.println("                      2. 유통기한 많이 남은 순으로 보기 ");
         System.out.println();

     int select=0;   
      do{   
         try{

         System.out.print("▶ 메뉴를 입력해주세요 (숫자 입력) : ");
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
               System.out.println(" ▶ 다시 입력해주세요");   
            }

         }while(select!=1 || select!=2);
   }
   //-- 잔돈 관리 메소드
   public static void stf_Money()
   {
      
      Scanner sc = new Scanner(System.in);

      String select="";
      int temp_1000=0;
      int temp_5000=0;
      int temp_10000=0;
      
      
      System.out.println("================================================================================");
      System.out.println("[SMART FLOWER 잔돈 관리]      「M = 관리자 메인」 / 「X = 종료하기」");
      System.out.println("================================================================================");
      System.out.println();
      System.out.println("                              [지폐]        [수량]       ");
      System.out.println();
        
      System.out.println("                            ￦ 1000원"  +"          "+ Cho.money.getExc_1000());
      System.out.println();
      System.out.println("                            ￦ 5000원"  +"          "+ Cho.money.getExc_5000());
      System.out.println();
      System.out.println("                            ￦ 10000원" +"         "+ Cho.money.getExc_10000());
      System.out.println(); 
      System.out.println("================================================================================");
	  CLIO.clearScreen(16);
      
      //잔돈부족 할 때 출력 메소드
        exc_Print();
        
      do{
           select="";
         while(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
         {
            System.out.print("▶ 잔고를 채우시겠습니까?(Y/N):");
            select = s_input();
            if(!(select.equals("N") || select.equals("n") || select.equals("Y") || select.equals("y")))
            {
               System.out.println("다시 입력해주세요");
            }
         }

         //n을 선택했을 경우      →   관리자 메인으로 돌아간다
         if(select.equals("N") || select.equals("n"))
         {
            clearScreen();
            stf_menuDisp();
         }
         
         //다른 문자를 입력 했을경우 다시 입력 받기 위한 예외 처리
            try
         {

            System.out.print("▶ 투입할 개수를 입력해주세요 1000원권:");
            temp_1000 =input();         
            Cho.money.addExc_1000(temp_1000);
         System.out.print("▶ 투입할 개수를 입력해주세요 5000원권:");
            temp_5000 = input();
            Cho.money.addExc_5000(temp_5000);
         System.out.print("▶ 투입할 개수를 입력해주세요 10000원권:");
            temp_10000 = input();
            Cho.money.addExc_10000(temp_10000);
         
         //투입한 잔고의 총합 구하고 총합 변수 선언
         int tot = (temp_1000*1000)+(temp_5000*5000)+(temp_10000*10000);
         
         //충전완료 안내문 출력
         System.out.printf("1000원권  %d개, 5000원권  %d개, 10000원권  %d개   ----> 총 %d원 충전완료 ",temp_1000,temp_5000,temp_10000,tot);   
         System.out.println();


         }
         catch(NumberFormatException n)
         {
         
            System.out.println("다시 입력해주세요.");
            continue;
            
         }
         
        }while(select.equals("Y") || select.equals("y"));   
        
   }
   
   //--- 잔고 부족할때 출력 메소드
   public static void exc_Print()//-----------------------------------------------------------**잔고가 부족합니다로만 하니깐 심심해서 조건을 조금 붙여서 수정해봤어요...
    {
      if(Cho.money.getExc_1000() <10 || Cho.money.getExc_tot()<50000)
      {
         
         System.out.println("                                ▶[ 잔고 부족 ]◀");
         System.out.println();

         if(Cho.money.getExc_1000() <10)
            System.out.println("                             1000원권 잔고가 부족합니다.");
         else if(Cho.money.getExc_tot()<50000)
            System.out.println("                             거스름돈 총액이 5만원 이하입니다.");
   
         System.out.println();
         System.out.println("================================================================================");
         }
    }
   //--- 재고 부족 출력 메소드
   public static void shortage()
   {
      
      System.out.println();
      System.out.println("                                ▶[ 재고 부족 ]◀");
      System.out.println();
      for(int i = 0 ; i < 3; i++)
      {
         System.out.printf("%40s\n",Cho.tot.get(i).getFt_name());
         System.out.println();
      }

      System.out.println();
      System.out.println("                                수량이 부족합니다.");
      System.out.println("================================================================================");

   }
   
   //--- int input 메소드
   public static int input()
    {
      Scanner sc = new Scanner(System.in);
      // 사용자 입력 받아옴
      String select = sc.next();
      
      // 입력 값이 M 또는 m 일 경우 
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
   //--- int String 메소드
   public static String s_input()   //「M = 관리자 메인」 / 「X = 종료하기」
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
   //복사메소드      fl.add(new Flower("빨간장미","4", 50, 20200312));
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
   //유통기한 지난 상품 삭제해주는 메소드
   public static void stf_FExp_Del()
   {
      
      //Calendar 클래스 기반 인스턴스 생성 (현재시간을 위한 객체)
      Calendar rightNow = Calendar.getInstance();
      String nowDate = "";
      //현재시간 
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

         if((Integer.parseInt(nowDate) - Integer.parseInt(temp_ware) >=7) )     //타이머로 하루에 한번 체크해주기
            Cho.fl.remove(i);
               
         temp_ware="";      
      }       
   }
     
	 //하루에 한번 유통기한 count가 1씩 감소하고  유통기한 7일 지난 상품 자동 삭제해주는 메소드
	 public static void stf_CheckExp(){
         
		 // 시간을 설정 할수 있게 Calendar 를 생성한다.
         Calendar cal = Calendar.getInstance();
         // 시작 할 시간을 설정한다.
         cal.set(2020,8,10,16,18); 
        
         
         //주석풀게되면 count가 하나씩 줄어들어서 일단 주석처리
         Timer m_timer = new Timer();
         TimerTask m_task = new TimerTask(){
         
         @Override
            public void run(){
        	 
               //카운트 -1해주는 부분
               System.out.println("시작");
               for(int i =0; i<Cho.fl.size(); i++)
                  Cho.fl.get(i).setF_count((Cho.fl.get(i).getF_count()-1));
               
               //유통기한 지난 상품 지워주는 함수 호출
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
//메인으로 가는 예외 처리 클래스
class s_MainException extends RuntimeException
{

}
//관리자 메인으로 가는 예외 처리 클래스
class StaffMainException extends RuntimeException
{

}
