package kiosk;
import java.util.*;
import java.io.*;

class D_RandomFlower
{
	
	static void randomFlower_O()
	{
		System.out.println("=============================================================");
		System.out.println("                [랜덤 꽃다발 구매]         N=둘러보기, X=종료");
		System.out.println("=============================================================");
		System.out.println("♥ 무슨 꽃을 구매해야할지 모르겠다면? 가벼운 마음으로 다양한 꽃을 만나보세요.");
		System.out.println("♥ 랜덤 꽃다발 구매는 무작위의 꽃을(S사이즈 10송이) 보다 저렴한 가격에\n 구입 하실 수 있습니다.");
		System.out.println("=============================================================");
		System.out.print("▶ 랜덤 꽃다발 구매(『Y』= 뽑기 ) : ");
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
				catch (StringIndexOutOfBoundsException e)										// StringIndexOutOfBoundsException에 해당될 경우(자리수 맞지 않을 경우)
				{
					System.out.println(" ☞ 자리수가 맞지 않습니다. 다시 입력해주세요. ");		// 재입력 안내
					flag=true;																	// 재입력 처리
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

		// 등수 매기기
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
				rd1 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
				rd2 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
				rd3 = rd.nextInt(count+Math.abs(count2-count)) + count;	// count 부터 22사이의 임의의 정수

				if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
				break;
			}
		}
		else if(count == count2 && count2 != 0)
		{
			while(true)
			{
				rd1 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
				rd2 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
				rd3 = rd.nextInt(count) + count;	// count 부터 22사이의 임의의 정수

				if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
				break;
			}
		}
		else if(count > count2 && count2 != 0)
		{
			while(true)
			{
				rd1 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
				rd2 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
				rd3 = rd.nextInt(count-Math.abs(count2-count)) + count;	// count 부터 22사이의 임의의 정수

				if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
				break;
			}
		}
		else if(count2 == 0)
		{
				while(true)
				{
					rd1 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
					rd2 = rd.nextInt(count);	// 0부터 count-1 사이의 임의의 정수
					rd3 = rd.nextInt(count);	// count 부터 22사이의 임의의 정수

					if (rd1 != rd2 && fl_su[rd1].ft_tot >= 4 && fl_su[rd2].ft_tot >= 4 && fl_su[rd3].ft_tot >= 2)
					break;
				}
		}
		
			CLIO.clearScreen_10();
			System.out.println("=============================================================");
			System.out.println("                [랜덤 꽃다발 구매]         M=둘러보기, X=종료");
			System.out.println("=============================================================");
			System.out.printf("\n♥ %s 4송이, %s 4송이, %s 2송이가 선택되었습니다.%n", fl_su[rd1].ft_name, fl_su[rd2].ft_name, fl_su[rd3].ft_name);
			System.out.println("♥ 가격은 7천원 입니다.");
			System.out.println("=============================================================");
			System.out.println("▶ 장바구니에 담으시겠습니까?(「Y=뽑기」「R=다시뽑기」) :");
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
					FlowerKiosk.CartDB_list.add(new CartDB("[랜덤꽃다발]" + fl_su[rd1].getFt_name(), 1, 4, 0));
					FlowerKiosk.CartDB_list.add(new CartDB("[랜덤꽃다발]" + fl_su[rd2].getFt_name(), 1, 4, 0));
					FlowerKiosk.CartDB_list.add(new CartDB("[랜덤꽃다발]" + fl_su[rd3].getFt_name(), 1, 2, 7000));
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
		            //fl.add(new Flower("수선화","1", 50, "2020-03-03"));
		            for(int i =0; i<Cho.fl_cl.size(); i++){
		            
		               if(f_select.equals(Cho.fl_cl.get(i).getF_name())){
		               
		               
		                  if(Cho.fl_cl.get(i).getF_su()-select > 0){
		                 System.out.println("작다");
		                     //Cho.fl_cl.get(i).getF_su()-select 뺀값을 수정
		                     Cho.fl_cl.get(i).setF_su(Cho.fl_cl.get(i).getF_su()-select);
		                     select=0;
		                     break;
		                     
		                  }else if(Cho.fl_cl.get(i).getF_su()-select==0){
		                	  System.out.println("같다");
		                 	Cho.fl_cl.get(i).setF_su(0);
		                 	Cho.fl_cl.get(i).setF_name(null);
		                     select=0;
		                  }else if(Cho.fl_cl.get(i).getF_su()-select<0){
		                     //tot값이랑 비교
		                     //Cho.fl_cl.get(i).getF_su()-select 뺀값 을 남겨두고
		                     //i번째 객체 지우려고 대기
		                     //다음객체 다시 찾고 없으면 재고가 부족합니다 
		                     //다음 객체 찾고 다시 비교
		                     if(Cho.tot.get(i).getFt_tot() >= select){
		                   System.out.println("크다");
		                        select=select-Cho.fl_cl.get(i).getF_su();
		                        Cho.fl_cl.get(i).setF_su(0);
			                 	Cho.fl_cl.get(i).setF_name(null);
		                        break;
		                     }else {
		                        System.out.println("재고가 부족합니다.");
		                  
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
		            //fl.add(new Flower("수선화","1", 50, "2020-03-03"));
		            for(int i =0; i<Cho.fl_tot_cl.size(); i++){
		            
		               if(f_select.equals(Cho.fl_tot_cl.get(i).getFt_name())){
		               
		               
		                  if(Cho.fl_tot_cl.get(i).getFt_tot()-select > 0){
		                 System.out.println("작다");
		                     //Cho.fl_cl.get(i).getF_su()-select 뺀값을 수정
		                     Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
		                     select=0;
		                     break;
		                     
		                  }else if(Cho.fl_tot_cl.get(i).getFt_tot()-select==0){
		                	  System.out.println("같다");
		                 	Cho.fl_tot_cl.get(i).setFt_tot(0);
		                 	Cho.fl_tot_cl.get(i).setFt_name(null);
		                     select=0;
		                  }else if(Cho.fl_tot_cl.get(i).getFt_tot()-select<0){
		                     //tot값이랑 비교
		                     //Cho.fl_cl.get(i).getF_su()-select 뺀값 을 남겨두고
		                     //i번째 객체 지우려고 대기
		                     //다음객체 다시 찾고 없으면 재고가 부족합니다 
		                     //다음 객체 찾고 다시 비교
		                     /*if(Cho.tot.get(i).getFt_tot() >= select){
		                   System.out.println("크다");
		                        select=select-Cho.fl_cl.get(i).getF_su();
		                        Cho.fl_cl.get(i).setF_su(0);
			                 	Cho.fl_cl.get(i).setF_name(null);
		                        break;
		                     }else {*/
		                	  
		                        System.out.println("재고가 부족합니다.");
		                  
		                     }

		                  }

		               }


		            }

		         }
	   
	   }
	
	/*
	 setName_추천(String 장미)
	 {
	 	return "추천꽃다발" + 장미;
	 }
	 setName_랜덤(String ㅇㅇㅇ)
	 
	 */

	// (Cho.fl.get(i)).fl_su

	


