package kiosk;
import java.util.*;
import java.io.*;

class C_FlowerUser extends Cho
{
	static Scanner sc;
	static String y,u,u2; //y or n 입력받는 변수 / u:선택한 꽃다발
	static int m,j;
	static int n;
	static String size,sizesu;
   

	void offer() //추천 꽃다발
	{
		boolean f=true; 
			sc=new Scanner(System.in);
			CLIO.clearScreen_10();
			System.out.println("======================================================================================================");
			System.out.println("   [추천꽃다발]                                                          「M=둘러보기」/「X=전체취소」");
			System.out.println("======================================================================================================");
			System.out.print(" ▶ 연도, 월을 입력하세요. ");
			CLIO.clearScreen(25);
			cal();
			do
			{
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.printf(" No.  |      추천 기념일      |        상품명        |                   상품소개\n");
				System.out.println("------------------------------------------------------------------------------------------------------");
				if(m==1){
					System.out.println(" 1.\t1월의 탄생화(1월)\t\t한결같은마음\t이달의 탄생화 수선화 부케로 겨울나기~\t→ 수선화");
					System.out.println(" 2.\t파란장미(1월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
					System.out.println(" 3.\t빨간장미(1월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
					System.out.println("-----------------------------------------------------------------------------------\n");
					
					 do{
						 try{  
								System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
								CLIO.clearScreen(4);
								n=CLIO.input();
								if (n>=1 && n<=3){ //1~3까지
								switch(n)
								{
									case 1: u="수선화"; u2="한결같은마음";break;
									case 2: u="파란장미";u2="파란장미";break;
									case 3: u="빨간장미";u2="빨간장미";
								}f=false;
								}else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
							}
							catch (NumberFormatException e){
						  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
						  f=true;}
			  }while(f);
			}
			else if(m==2)
			{
				System.out.println(" 1.\t2월의 탄생화(2월)\t\t미씽유포에버\t이달의 탄생화 물방초 부케로 봄맞이 준비!\t→ 물망초");
				System.out.println(" 2.\t졸업식 시즌(2월)\t\t당신의내일\t아름다운 마무리를 함께해요~\t\t\t→ 노란장미");
				System.out.println(" 3.\t발렌타인데이(2/14)\t\t스위트초코\t초콜릿과 함께 주는 꽃다발로 감동지수UP!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
				
				do{
					 try{  
							System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
							CLIO.clearScreen(4);
							n=CLIO.input();
							if (n>=1 && n<=3){ //1~3까지
							switch(n)
						   {
							  case 1: u="물망초"; u2="미씽유포에버";break;
							  case 2: u="노란장미";u2="당신의내일";break;
							  case 3: u="빨간장미";u2="스위트초코";
						   }
					   f=false;
					  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
				 }
		 
					catch (NumberFormatException e)
					   {
						  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
						  f=true;
					   }
			  }while(f);
			}
			else if(m==3)
			{      
				System.out.println(" 1.\t3월의 탄생화(3월)\t\t데이리데이지\t이달의 탄생화 데이지 부케로 싱그러운 봄맞이!\t→ 데이지");
				System.out.println(" 2.\t입학식 시즌(3월)\t\t피어라새싹\t소중한 당신의 새로운 출발을 축하합니다~\t\t→ 프리지아");
				System.out.println(" 3.\t화이트데이(3/14)\t\t블링프로포즈\t달달한 사탕과 어울리는 화려한 부케\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
		do
		  {
			 try
			 {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				 if (n>=1 && n<=3){ //1~3까지
				switch(n)
				   {
					  case 1: u="데이지"; u2="데이리데이지"; break;
					  case 2: u="프리지아";u2="피어라새싹";break;
					  case 3: u="빨간장미";u2="t블링프로포즈";
				   }  
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==4)
			{
				System.out.println(" 1.\t4월의 탄생화(4월)\t\t벚꽃아피어라\t벚꽃놀이 갈때, 포인트로 한다발!\t→ 벚꽃");
				System.out.println(" 2.\t파란장미(4월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 3.\t빨간장미(4월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
				do
      {
         try
         {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				if (n>=1 && n<=3){ //1~3까지
				  switch(n)
				  {
					 case 1: u="벚꽃"; u2="벚꽃아피어라";break;
					 case 2: u="파란장미";u2="파란장미";break;
					 case 3: u="빨간장미";u2="빨간장미";
				  } 
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==5)
			{
				System.out.println(" 1.\t5월의 탄생화(5월)\t보라해\t\t이달의 탄생화 라일락으로 환성적인 연출을~!\t\t→ 라일락");
				System.out.println(" 2.\t성년의날(5월)\t\t퍼퓸앤어덜트\t스무살의 추억을 완벽하게 마무리하는 방법!\t\t→ 파란장미");
				System.out.println(" 3.\t어린이날(5/5)\t\t우리들세상\t우리아이 앞으로도 잘 자라길 기도하는 마음으로~\t\t→ 수국");
				System.out.println(" 4.\t어버이날(5/8)\t\t어버이된마음\t카네이션 부케로 감사함을 전해요~\t\t\t→ 카네이션");
				System.out.println(" 5.\t로즈데이(5/14)\t\t평생함께할래\t그다음엔 근처 꽃집으로가서 빨간장미 한송일 샀죠~♬\t→ 레드로즈");
				System.out.println(" 6.\t스승의날(5/15)\t\t존경하는그대\t보답하리, 스승의 은혜-  \t\t\t\t→ 카네이션");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(2);
				n=CLIO.input();
				if (n>=1 && n<=6){ 
				 switch(n)
				   {
					  case 1: u="라일락"; u2="보라해";break;
					  case 2: u="파란장미"; u2="퍼퓸앤어덜트"; break;
					  case 3: u="수국";u2="우리들세상";break;
					  case 4: u="카네이션";u2="어버이된마음";break;
					  case 5: u="빨간장미";u2="평생함께할래";break;
					  case 6: u="카네이션";u2="존경하는그대";
				   }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==6)
			{
				System.out.println(" 1.\t6월의 탄생화(6월)\t로지로즈\t이달의 탄생화 핑크&화이트 장미로 화사하게~\t→ 분홍장미");
				System.out.println(" 2.\t파란장미(6월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 3.\t빨간장미(6월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				if (n>=1 && n<=3){ //1~3까지
				  switch(n)
				  {
					 case 1: u="분홍장미"; u2="로지로즈";break;
					 case 2: u="파란장미";u2="파란장미";break;
					 case 3: u="빨간장미";u2="빨간장미";
				  }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==7)
			{
				System.out.println(" 1.\t7월의 탄생화(7월)\t여름여행\t이달의 탄생화 라벤더 부케로 마음을 편안하게-\t→ 라벤더");
				System.out.println(" 2.\t파란장미(7월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				 System.out.println(" 3.\t빨간장미(7월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
					  do
      {
         try
         {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				 if (n>=1 && n<=3){ //1~3까지
				  switch(n)
				  {
					 case 1: u="라벤더"; u2="여름여행";break;
					 case 2: u="파란장미";u2="파란장미";break;
					 case 3: u="빨간장미";u2="빨간장미";
				  }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}

			else if(m==8)
			{
				System.out.println(" 1.\t8월의 탄생화(8월)\t썬플라워투유\t이달의 탄생화는 당신만 바라보는 해바라기!\t→ 해바라기");
				System.out.println(" 2.\t졸업식 시즌(8월)\t특별한마지막\t코스모스 졸업에 어울리는 특별제작 부케!\t\t→ 코스모스");
				System.out.println(" 3.\t파란장미(8월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 4.\t빨간장미(8월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
				 if (n>=1 && n<=4){ 
				switch(n)
				   {
					  case 1: u="해바라기"; u2="썬플라워투유";break;
					  case 2: u="코스모스"; u2="특별한마지막";break;
					  case 3: u="파란장미"; u2="파란장미";break;
					  case 4: u="빨간장미"; u2="빨간장미";
				   }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==9)
			{
				System.out.println(" 1.\t9월의 탄생화(9월)\t달리아\t이달의 탄생화 달리아 부케로 다가오는 가을맞이!\t→ 달리아");
				System.out.println(" 2.\t파란장미(9월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 3.\t빨간장미(9월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
	
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				
							  if (n>=1 && n<=3){ //1~3까지
				  switch(n)
				  {
					 case 1: u="달리아"; u2="달리아";break;
					 case 2: u="파란장미";u2="파란장미";break;
					 case 3: u="빨간장미";u2="빨간장미";
				  }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==10)
			{
				System.out.println(" 1.\t10월의 탄생화(10월)\t카라\t이달의 탄생화 카라 부케로 외롭지 않아!\t→ 카라");
				System.out.println(" 2.\t파란장미(10월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 3.\t빨간장미(10월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
	do
      {
         try
         {  System.out.println("------------------------------------------------------------------------------------------------------\n");
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
			  if (n>=1 && n<=3){ //1~3까지
				  switch(n)
				  {
					 case 1: u="카라"; u2="카라";break;
					 case 2: u="파란장미";u2="파란장미";break;
					 case 3: u="빨간장미";u2="빨간장미";
				  }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==11)
			{
				System.out.println(" 1.\t11월의 탄생화(11월)\t초롱꽃\t이달의 탄생화 초롱꽃 부케로 아기자기하게 연출해요~ \t→ 초롱꽃");
				System.out.println(" 2.\t빼빼로데이(11/11)\t입술을맞춰\t빼빼로만 선물하기는 심심하잖아요~\t\t→ 흰장미");
				System.out.println(" 3.\t파란장미(11월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 4.\t빨간장미(11월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
			  if (n>=1 && n<=4){
				switch(n)
				   {
					  case 1: u="초롱꽃"; u2="초롱꽃";break;
					  case 2: u="흰장미"; u2="입술을맞춰";break;
					  case 3: u="파란장미";u2="파란장미";break;
					  case 4: u="빨간장미";u2="빨간장미";
				   }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}

			else if(m==12)
			{
				System.out.println(" 1.\t12월의 탄생화(12월)\t눈꽃살포시\t흰 눈과 어울릴 이달의 탄생화 목화부케! \t→ 목화");
				System.out.println(" 2.\t크리스마스(12월)\t화이트스노우\t트리 오너먼트로 장식하고, 사진도 찍고! \t→ 헬레보루스");
				System.out.println(" 3.\t파란장미(12월)\t\t파란장미\t파란장미!\t\t→ 파란장미");
				System.out.println(" 4.\t빨간장미(12월)\t\t빨간장미\t빨간장미!\t\t→ 빨간장미");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ▶ 구매를 원하시는 상품번호를 선택해주세요.(숫자 입력) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
			  if (n>=1 && n<=4){ 
					switch(n)
				   {
					  case 1: u="목화"; u2="눈꽃살포시"; break;
					  case 2: u="헬레보루스"; u2="화이트스노우";break;
					  case 3: u="파란장미";u2="파란장미";break;
					  case 4: u="빨간장미";u2="빨간장미";
				   }
			   f=false;
			  
			  }else System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
                  f=true;
               }
	  }while(f);
	}    

			System.out.println(" ☞ '"+u2+"'를 선택하셨습니다!");

			System.out.println();
			System.out.println(" ♥ 가격 안내 ♥ ");
			System.out.println("-----------------------------------------------------");
			System.out.printf(" No.\t|\t사이즈\t    |   \t가격\n");
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1.\t\tS(10pcs)\t\t10,000￦");
			System.out.println(" 2.\t\tM(20pcs)\t\t20,000￦");
			System.out.println(" 3.\t\tL(30pcs)\t\t30,000￦");
			System.out.println(" 4.\t\tXL(40pcs)\t\t40,000￦");
			System.out.println("-----------------------------------------------------\n");
			  
	do
      {
         try
         {  	 
			System.out.print(" ▶ 구매를 원하시는 사이즈를 선택해주세요.(숫자 입력) : ");
			size=CLIO.S_input();
			if (size.equals("1")||size.equals("2")||size.equals("3")||size.equals("4")) {
			System.out.print(" ▶ 구매를 원하시는 개수를 입력해주세요.(숫자 입력) : ");
			sizesu=CLIO.S_input();
			f=false;
			}else{ f=true;
			System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
			}
		 } catch (NumberFormatException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            f=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
            f=true;
         }
      }
      while (f);                     

			 int select=Integer.parseInt(size)*10*Integer.parseInt(sizesu);
			   for (int i=0; i<Cho.length; i++)
			  {
			  
				  if(fl_cl.get(i).f_name.equals(u))
				  j=i;
			  }
			boolean flag=true;

			 while(true){

          if(select==0)
             break;
            for(int i =0; i<fl_cl.size(); i++){
            
               if(fl_cl.get(i).f_name.equals(u)&&Cho.fl_tot_cl.get(i).getFt_tot() >= select){
                  if(fl_cl.get(i).getF_su()-select > 0){
                     
                     fl_cl.get(i).setF_su(fl_cl.get(i).getF_su()-select);
                Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
                select=0;
                     break;
                     
                  }else if(fl_cl.get(i).getF_su()-select==0&&Cho.fl_tot_cl.get(j).ft_tot!=0){
                     //fl_cl.remove(i);
                 fl_cl.get(i).setF_su(0);
                 Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
                     select=0;
                break;
                  }else if(fl_cl.get(i).getF_su()-select<0){
                    
                     if(Cho.fl_tot_cl.get(i).getFt_tot() >= select){
                        select=select-fl_cl.get(i).getF_su();
                  Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
                        break;
                     }
                  }
               }
            else { 
                           if(fl_cl.get(j).f_name.equals(u)&&Cho.fl_tot_cl.get(j).ft_tot<select){
                           do{
                           System.out.println("▶ 수량부족! "+Cho.fl_tot_cl.get(j).ft_tot+"개 남음");      
                           System.out.println("☞ 구매에 실패하셨습니다.");
                           System.out.print("▶ 수량을 계속 구매하시겠습니까(Y/N)? : "); 
                           y=CLIO.S_input();
                           flag=false;
                           if(y.equals("N")||y.equals("n")){ select=0; break;}
                           System.out.print("▶ 구매를 원하시는 사이즈를 선택해주세요.(숫자 입력):");
                           size=CLIO.S_input();
                           System.out.print("▶구매를 원하시는 개수를 입력해주세요.(숫자 입력):");
                           sizesu=CLIO.S_input();
                           select=Integer.parseInt(size)*10*Integer.parseInt(sizesu);
                        if(fl_cl.get(j).f_name.equals(u)&Cho.fl_tot_cl.get(j).ft_tot>=select){
                        //fl_cl.get(j).f_su-=select;
                           //Money.userCash+=Integer.parseInt(size)*10000*Integer.parseInt(sizesu);
                        y="N";
						flag=true;
                        }
                 
                         }while(Cho.fl_tot_cl.get(j).ft_tot<select&&y.equals("Y")||y.equals("y"));
                           }
                     } 
            }
         }          
			 
		 // 라일락, 사이즈1 , 1개, 1000원 => 10개구입하는거니까 10000원 
         //ob1.setSize(Integer.parseInt(size));
         //ob1.setSu(Integer.parseInt(sizesu));
         FlowerKiosk.CartDB_list.add(new CartDB("[추천꽃다발]"+ u, Integer.parseInt(size), Integer.parseInt(sizesu), Integer.parseInt(size)*10000*Integer.parseInt(sizesu)));
         if(flag==true)
         Money.userCash+=Integer.parseInt(size)*10000*Integer.parseInt(sizesu);
         
          
         System.out.println("현재 금액 : "+Money.userCash);
         //System.out.println("남은 꽃 수량 : "+fl_cl.get(j).f_su);
      System.out.print("▶ 추천꽃을 계속 구매하시겠습니까(Y/N)? : ");   
     y=CLIO.S_input();   
     for(int i=0;i<fl_cl.size();i++)
     System.out.println("이름:"+fl_cl.get(i).f_name+"수:"+fl_cl.get(i).f_su);
      
      }
      while(y.equals("Y")||y.equals("y"));
		
        System.out.println("===================================================================================");   
		  CLIO.clearScreen_10();
		  Cart.User_Cart();
		  
   }


   void cal()
   {
		Scanner sc=new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		int y, m;      //-- 년, 월
		int w;         //-- 요일
		int i;         //-- 루프 변수
		
		do
		{
			System.out.print(" ▶ 연도 입력 : "); //추춴 꽃을 월마다 확인하기 위해 입력받움
			y=CLIO.input(); 
		}
		while (y<1);

		do
		{
			System.out.print(" ▶ 월 입력   : ");
			m=CLIO.input();
			this.m=m;
		}
		while (m<1 || m>12);

		cal.set(y, m-1, 1);
		w = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println();
		System.out.println("\t[ " + y + "년 " + m + "월 ]\n");
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");

		for (i=1; i<w; i++)
			System.out.print("    ");
		for (i=1; i<=cal.getActualMaximum(Calendar.DATE); i++)
		{
			System.out.printf("%4d", i);
			w++;   
			if(w%7==1)   
			System.out.println();   
		}
		if(w%7!=1)
			System.out.println();   
		System.out.println("============================");
	} //end cal

}