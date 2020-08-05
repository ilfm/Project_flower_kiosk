package kiosk;
import java.util.*;
import java.io.*;

//주문화면
class G_UserOrder extends E_RandEvent
{
	static int ran,count;
	static String tel,pwd;
	static String y; //y or n 입력받는 변수
	static int n;
	static int[] adp_tot = new int[5];
	//0:메세지, 1:바구니, 2:포장지, 3:리본, 4:미니꽃다발 
	static String[] ab=new String[15];
    static String[] abto=new String[15];

    static void uOrder()  //주문화면 출력
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("===================================================================================");
		System.out.println("   [주문화면]                                          「M=둘러보기」「X=전체취소」");
		System.out.println("===================================================================================");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("   상품명          |  수량  |  가격  ");
		System.out.println("-------------------------------------------------------------------");

		for(int i=0; i<FlowerKiosk.CartDB_list.size(); i++)
	      {
	    	  System.out.println(FlowerKiosk.CartDB_list.get(i).getName_RandomFlower() + FlowerKiosk.CartDB_list.get(i).getSize() + FlowerKiosk.CartDB_list.get(i).getSu() + FlowerKiosk.CartDB_list.get(i).getPrice());
	      }
		System.out.println("-------------------------------------------------------------------");
	    System.out.printf("→ 총 주문금액 : %d원\n", Money.userCash);
		CLIO.clearScreen(21-FlowerKiosk.CartDB_list.size());

		boolean flag=false;
		do {
		
			try {
				System.out.print(" ▶ 추가 구매를 진행하시겠습니까(Y/N)? :");
				y=CLIO.S_input();
				if(y.equals("Y")||y.equals("y"))
				{
					CLIO.clearScreen_10();
					uOrderCon();
				}

				uOrderCon2();	
			}
			   catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요. ");      // 재입력 안내
	            flag=true;                                                   // 재입력 처리
	         }
	         catch (NumberFormatException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
	            flag=true;
	         }
	         catch (IndexOutOfBoundsException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
	            flag=true;
	         }
	      }
	      while (flag);
		
		//else 
	}


	static void uOrderCon()//추가구매 
   {
		System.out.println("\n\n");
		String[] z= {"메세지카드","바구니","포장지","리본","미니꽃다발"};
		int[] zz= {1000,2000,2000,2000,4000};

		Scanner sc=new Scanner(System.in);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" ♥ 추가구매 옵션 ♥ ");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" No. |\t상품명\t|\t개수\t|\t가격");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(" [상품번호]\t[추가구매 옵션]\t\t\t[상품 금액]");
		System.out.println("\t1\t메세지카드\t\t\t1,000원");
		System.out.println("\t2\t바구니\t\t\t\t2,000원");
		System.out.println("\t3\t포장지\t\t\t\t2,000원");
		System.out.println("\t4\t리본\t\t\t\t2,000원");
		System.out.println("\t5\t미니꽃다발(드라이플라워)\t4,000원"); 
		System.out.println("-----------------------------------------------------------------------------------");
		boolean flag=false;
	      do
	      {
	         try
	         {
	            do
	            {
			System.out.print(" ▶ 추가 구매를 원하는 상품번호와 개수를 입력하세요[컴마구분] : ");
			CLIO.clearScreen(17);
			String s = CLIO.S_input();
			String str[] = s.split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]); 
			sc.nextLine(); //엔터(개행)제거

			
			//추가구매 재고관리
			if(a==1)
			{
				
				//Adp.msg-=b;
				adp_tot[0]+=b;
				if(Cho.adp_ob.getMsg()>=adp_tot[0]) {
				Money.userCash+=1000*b;
				//System.out.println("남은 카드 수 :"+Adp.msg); //테스트 
				System.out.println(" ☞ 선택한 카드 수 :"+adp_tot[0]);
				System.out.println(" ☞ 금액:"+Money.userCash);
				int v=Cho.adp_ob.getMsg();
				Cho.adp_ob.setMsg(v-b);
				}else {
					System.out.println("☞재고부족! 현재 재고 : "+Cho.adp_ob.getMsg());
					adp_tot[0]-=b;
				}
			}
			else if(a==2)
			{
				
				adp_tot[1]+=b;
				if(Cho.adp_ob.getBasket()>=adp_tot[1]) {
				Money.userCash+=2000*b;
				System.out.println(" ☞ 선택한 바구니 수 :"+adp_tot[1]);
				System.out.println(" ☞ 금액:"+Money.userCash);
				int v=Cho.adp_ob.getBasket();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("☞재고부족! 현재 재고 : "+Cho.adp_ob.getBasket());
				adp_tot[1]-=b;
			}
			}
			else if(a==3)
			{
				
				adp_tot[2]+=b;
				if(Cho.adp_ob.getPaper()>=adp_tot[2]) {
				Money.userCash+=2000*b;
				System.out.println(" ☞ 선택한 포장지 수 :"+adp_tot[2]);
				System.out.println(" ☞ 금액:"+Money.userCash);
				int v=Cho.adp_ob.getPaper();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("☞재고부족! 현재 재고 : "+Cho.adp_ob.getPaper());
				adp_tot[2]-=b;
			}
			}
			else if(a==4)
			{
				
				adp_tot[3]+=b;
				if(Cho.adp_ob.getRibbon()>=adp_tot[3]) {
				Money.userCash+=2000*b;
				System.out.println(" ☞ 선택한 리본 수 :"+adp_tot[3]);
				System.out.println(" ☞ 금액:"+Money.userCash);
				int v=Cho.adp_ob.getRibbon();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("☞재고부족! 현재 재고 : "+Cho.adp_ob.getRibbon());
				adp_tot[3]-=b;
			}
			}
			else if(a==5)
			{
				
				adp_tot[4]+=b;//미니꽃다발
				if(Cho.adp_ob.getMiniflo()>=adp_tot[4]) {
				Money.userCash+=4000*b;
				System.out.println(" ☞ 선택한 미니꽃다발 수 : "+adp_tot[4]);
				System.out.println(" ☞ 금액:"+Money.userCash);
				int v=Cho.adp_ob.getMiniflo();
				Cho.adp_ob.setMsg(v-b);
			}else {
				System.out.println("☞재고부족! 현재 재고 : "+Cho.adp_ob.getMsg());
				adp_tot[4]-=b;
			}
			}

			if(a==1)
			{
				for(int i=1;i<=b;i++)
				{
					System.out.print(" ▶ 메세지입력(최대 50글자) : ");
					String strM=sc.nextLine();
				}
			}
			
			FlowerKiosk.CartDB_list.add(new CartDB("[추가구매]"+ z[a-1],0, adp_tot[a-1],zz[a-1]));

			System.out.print(" ▶ 계속 구매하시겠습니까(Y/N)? : ");

			y=CLIO.S_input();
		}
		while(y.equals("Y")||y.equals("y"));
	    flag = false;
   }
	         catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요. ");      // 재입력 안내
	            flag=true;                                                   // 재입력 처리
	         }
	         catch (NumberFormatException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
	            flag=true;
	         }
	         catch (IndexOutOfBoundsException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
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
	      System.out.println("[ SMART FLOWER 장바구니 ]              「M=둘러보기」「X=전체취소」");
	      System.out.println("===================================================================");
	      System.out.println("-------------------------------------------------------------------");
	      System.out.println("   상품명   |  수량  |  가격  ");
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
		System.out.print(" ▶ 총 결제 금액은 "+Money.userCash+" 입니다. 적립금을 사용하시겠습니까(Y/N)? : ");
		y=CLIO.S_input();

		if(y.equals("Y")||y.equals("y"))
		{
			CLIO.clearScreen_10();
			J_CashPoint.useRewards_O();
		}

		Ran();

		do
		{
			System.out.print(" ▶ 쿠폰을 사용하시겠습니까(Y/N)? : ");
			y=CLIO.S_input();

			if(y.equals("Y")||y.equals("y")) //쿠폰사용 - 번호출력후 선택하게하기(수정)
			{
				//System.out.println(randcon);

				System.out.print(" ▶ 쿠폰을 입력하세요: ");
				String conu=CLIO.S_input();

				//당첨정보와 사용자가 입력한 값 비교 후 저장된 데이터가 같을때 
				for(int i=0;i<UserInfo.prizeCo.size();i++){
					if(abto[i].equals(conu))
						{        
							System.out.println(" ☞ 쿠폰사용 완료");
							//재고처리
							 if(ab[i].equals("A"))
							  Money.userCash-=5000;
							else if(ab[i].equals("B"))
							   Money.userCash-=3000;
							else if(ab[i].equals("C"))
							   Money.userCash-=1000;
						}
						else System.out.println(" ☞ 쿠폰등록정보 없음");
						System.out.println("현재 금액 : "+Money.userCash);
					}		
			}

		}while(y.equals("Y")||y.equals("y"));   
	         }
		  catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
	         {
	            System.out.println(" ☞ 자리수가 맞지 않습니다. 다시 입력해주세요. ");      // 재입력 안내
	            flag=true;                                                   // 재입력 처리
	         }
	         catch (NumberFormatException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
	            flag=true;
	         }
	         catch (IndexOutOfBoundsException e)
	         {
	            System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
	            flag=true;
	         }
	      }
	      while (flag);


		//결제수단
		do
		{
			 boolean flag2=false;
	         do
	         {
	            try
	            {

			System.out.print(" ▶결제 수단을 선택해주십시오. 1)현금결제 2)카드결제 :");
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
			System.out.println(" ☞ 다시 입력해주세요.");
		}
	            catch (StringIndexOutOfBoundsException e)                              // StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
	            {
	               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요. ");      // 재입력 안내
	               flag2=true;                                                   // 재입력 처리
	            }
	            catch (NumberFormatException e)
	            {
	               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
	               flag2=true;
	            }
	            catch (IndexOutOfBoundsException e)
	            {
	               System.out.println(" ☞ 입력값이 올바르지 않습니다. 다시 입력해주세요.");
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
				ab[i]="A";//"5000원 할인쿠폰";
				abto[i]=aa;
			}else if(bb.equals("B")){
				ab[i]="B";//"3000원 할인쿠폰";
				abto[i]=aa;
			}else if(bb.equals("C")){
				ab[i]="C";//"1000원 할인쿠폰";
				abto[i]=aa;
			}
		}
	}
}