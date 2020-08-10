package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class Cho
{   
	//꽃 담는 DB LinkedList 
	static List<Flower> fl;
	//꽃의 총량 DB ArrayList 
	static List<Flower_tot> tot;
	static Hashtable<String, UserInfo> ui;
	static Money money;
	static Flower_tot ft_o;
	static MyComparator<Flower_tot> mc;
	static MyComparator2<Flower> mc2;
	static MyComparator3<Flower> mc3;
	static int length, length1;
	//fl의 클론
	static List<Flower> fl_cl;
	//tot의 클론
    static List<Flower_tot> fl_tot_cl;
	static Adp adp_ob;
    
	static
	{
		fl= new LinkedList<Flower>();
		tot = new ArrayList<Flower_tot>();
		money = new Money();
		ft_o = new Flower_tot();
		mc = new  MyComparator<Flower_tot>();
		Flower f_ob = new Flower();
		mc = new MyComparator<Flower_tot>();
		mc2 = new MyComparator2<Flower>();
		mc3 = new MyComparator3<Flower>();
		adp_ob = new Adp();
		ui = new Hashtable<String, UserInfo>();

      
		  //tot 초기화
		  tot.add(new Flower_tot("1","수선화",50,1000, "자기 사랑, 자존심, 고결, 신비   "));
	      tot.add(new Flower_tot("2","물망초",50,2000,"날 잊지마세요, 진실한 사랑       "));
	      tot.add(new Flower_tot("3","노란장미",50,1000, "완벽한 성취, 질투, 시기       "));
	      tot.add(new Flower_tot("4","빨간장미",50,1000,"불타는 사랑, 사랑의 비밀, 아름다움"));
	      tot.add(new Flower_tot("5","데이지",50,1000,"명랑, 순수한 마음              "));
	      tot.add(new Flower_tot("6","프리지아",50,1000,"천진난만, 자기자랑, 청함       " ));
	      tot.add(new Flower_tot("7","벚꽃",50,2000,"순결, 절세미인                  "));
	      tot.add(new Flower_tot("8","라일락",50,2000, "첫사랑, 젊은 날의 추억         "));
	      tot.add(new Flower_tot("9","파란장미",50,2000, "신비로움, 불가능의 상징, 소원   "));
	      tot.add(new Flower_tot("10","수국",50,2000,"진심, 변덕                             "));
	      tot.add(new Flower_tot("11","카네이션",50,1000, "모정, 사랑                         "));
	      tot.add(new Flower_tot("12","분홍장미",50,2000, "사랑의 맹세, 행복한 사랑      "));
	      tot.add(new Flower_tot("13","라벤더",50,1000,"침묵                                "));
		  tot.add(new Flower_tot("14","해바라기",50, 2000,"숭배, 기다림                        "));
	      tot.add(new Flower_tot("15","코스모스",50,2000,"순정                              "));
	      tot.add(new Flower_tot("16","달리아",50,2000,"정열                                "));
	      tot.add(new Flower_tot("17","카라",50,1000,"천년의 사랑, 순수함             "));
	      tot.add(new Flower_tot("18","초롱꽃",50,2000,"감사, 성실                           "));
	      tot.add(new Flower_tot("19","흰장미",50,1000,"순수함, 순수한 사랑            "));
	      tot.add(new Flower_tot("20","목화",50,2000,"어머니의 사랑                         "));
	      tot.add(new Flower_tot("21","헬레보루스",50,2000,"나의 마음을 달래주세요        "));
	      tot.add(new Flower_tot("22","안개꽃",50,1000,"맑은 마음, 깨끗한 마음, 사랑의 성공"));
	      tot.add(new Flower_tot("23","유칼리투스",50,1000,"추억                              "));


	      //초기 꽃 재고
	      fl.add(new Flower("수선화","1",50, "2020-03-12",6));
	      fl.add(new Flower("물망초","2", 50,  "2020-03-12",6));
	      fl.add(new Flower("노란장미","3", 50,  "2020-03-11",5));
	      fl.add(new Flower("빨간장미","4", 50, "2020-03-06",0));
	      fl.add(new Flower("빨간장미","4", 50, "2020-03-06",0));
	      fl.add(new Flower("데이지","5", 50, "2020-03-06",0));
	      fl.add(new Flower("프리지아","6", 50, "2020-03-12"));
	      fl.add(new Flower("벚꽃","7", 50, "2020-03-12"));
	      fl.add(new Flower("라일락","8", 50,  "2020-03-12"));
	      fl.add(new Flower("파란장미","9", 50,  "2020-03-12"));
	      fl.add(new Flower("수국","10", 50, "2020-03-12"));
	      fl.add(new Flower("카네이션","11",50,"2020-03-12"));
	      fl.add(new Flower("분홍장미","12",50,  "2020-03-12"));
	      fl.add(new Flower("라벤더","13",50, "2020-03-12"));
	      fl.add(new Flower("해바라기","14",50, "2020-03-12"));
	      fl.add(new Flower("코스모스","15", 50,"2020-03-12"));
	      fl.add(new Flower("달리아","16", 50, "2020-03-12"));
	      fl.add(new Flower("카라","17", 50,  "2020-03-12"));
	      fl.add(new Flower("초롱꽃","18", 50, "2020-03-12"));
	      fl.add(new Flower("흰장미","19", 50,  "2020-03-12"));
	      fl.add(new Flower("목화","20", 50,  "2020-03-12"));
	      fl.add(new Flower("헬레보루스","21", 50, "2020-03-12"));
	      fl.add(new Flower("안개꽃", "22", 50, "2020-03-12"));
	      fl.add(new Flower("유칼립투스","23", 50, "2020-03-12"));


		length = tot.size();
		
		// 장바구니를 위해 기존에 있는 정보를 복사한 복사본 사용한다.
		fl_cl = new LinkedList<Flower>();
		fl_tot_cl = new LinkedList<Flower_tot>();

		fl_cl = boksa(fl);
		fl_tot_cl = boksa_tot(tot);
     
		//회원정보
		//UserInfo u_ob = new UserInfo();
		
	}
		// 기존에 있는 제품 재고 정보를 복사하는 함수
		public static List<Flower> boksa(List<Flower> list){
			List<Flower> temp = new ArrayList<Flower>();
			for(int i=0; i< list.size(); i++){
				temp.add(new Flower(list.get(i).getF_name()				// 제품명
									, list.get(i).getF_num() 			// 제품 코드
									, list.get(i).getF_su() 			// 재고량
									, list.get(i).getF_wareDate()));    // 입고 일자
			}
			return temp;      
		}
		// 기존에 있는 꽃 재고의 총합 정보를 복사하는 함수 
		public static List<Flower_tot> boksa_tot(List<Flower_tot> list){
			List<Flower_tot> temp = new ArrayList<Flower_tot>();
			
			for(int i=0; i< list.size(); i++){   
				temp.add(new Flower_tot(list.get(i).getFt_num()			// 선택 코드
										, list.get(i).getFt_name()		// 제품명
										, list.get(i).getFt_tot() 		// 총 재고량
										, list.get(i).getFt_price()		// 가격
										, list.get(i).getFt_mean()));	// 꽃말
			}
			return temp;      
		}
	}

class MyComparator<T> implements Comparator<T>
{ 
	@Override
	public int compare(T o1, T o2)
	{   
		Flower_tot s1 = (Flower_tot) o1;                        
		Flower_tot s2 = (Flower_tot) o2;

		//총수 기준 (오름차순)
		return (s1.getFt_tot()) - (s2.getFt_tot());   
		//return (s1.getFt_name()).compareTo(s2.getFt_name());
	}
}

//유통기한 오름차순 정렬을 위한 클래스
class MyComparator2<T> implements Comparator<T>{ 

	@Override
		public int compare(T o1, T o2){   
		Flower s1 = (Flower) o1;                        
      Flower s2 = (Flower) o2;

 
       //총수 기준 (오름차순)
       return (s1.getF_count()) - (s2.getF_count());   
		//return (s1.getFt_name()).compareTo(s2.getFt_name());
     }

}

//유통기한 내림차순을 위한 클래스
class MyComparator3<T> implements Comparator<T>{ 

	@Override
		public int compare(T o1, T o2){   
		Flower s1 = (Flower) o1;                        
      Flower s2 = (Flower) o2;

 
       //총수 기준 (오름차순)
       return (s2.getF_count()) - (s1.getF_count());   
		//return (s1.getFt_name()).compareTo(s2.getFt_name());
     }

}
