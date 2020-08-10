package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class Cho
{   
	//�� ��� DB LinkedList 
	static List<Flower> fl;
	//���� �ѷ� DB ArrayList 
	static List<Flower_tot> tot;
	static Hashtable<String, UserInfo> ui;
	static Money money;
	static Flower_tot ft_o;
	static MyComparator<Flower_tot> mc;
	static MyComparator2<Flower> mc2;
	static MyComparator3<Flower> mc3;
	static int length, length1;
	//fl�� Ŭ��
	static List<Flower> fl_cl;
	//tot�� Ŭ��
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

      
		  //tot �ʱ�ȭ
		  tot.add(new Flower_tot("1","����ȭ",50,1000, "�ڱ� ���, ������, ���, �ź�   "));
	      tot.add(new Flower_tot("2","������",50,2000,"�� ����������, ������ ���       "));
	      tot.add(new Flower_tot("3","������",50,1000, "�Ϻ��� ����, ����, �ñ�       "));
	      tot.add(new Flower_tot("4","�������",50,1000,"��Ÿ�� ���, ����� ���, �Ƹ��ٿ�"));
	      tot.add(new Flower_tot("5","������",50,1000,"���, ������ ����              "));
	      tot.add(new Flower_tot("6","��������",50,1000,"õ������, �ڱ��ڶ�, û��       " ));
	      tot.add(new Flower_tot("7","����",50,2000,"����, ��������                  "));
	      tot.add(new Flower_tot("8","���϶�",50,2000, "ù���, ���� ���� �߾�         "));
	      tot.add(new Flower_tot("9","�Ķ����",50,2000, "�ź�ο�, �Ұ����� ��¡, �ҿ�   "));
	      tot.add(new Flower_tot("10","����",50,2000,"����, ����                             "));
	      tot.add(new Flower_tot("11","ī���̼�",50,1000, "����, ���                         "));
	      tot.add(new Flower_tot("12","��ȫ���",50,2000, "����� �ͼ�, �ູ�� ���      "));
	      tot.add(new Flower_tot("13","�󺥴�",50,1000,"ħ��                                "));
		  tot.add(new Flower_tot("14","�عٶ��",50, 2000,"����, ��ٸ�                        "));
	      tot.add(new Flower_tot("15","�ڽ���",50,2000,"����                              "));
	      tot.add(new Flower_tot("16","�޸���",50,2000,"����                                "));
	      tot.add(new Flower_tot("17","ī��",50,1000,"õ���� ���, ������             "));
	      tot.add(new Flower_tot("18","�ʷղ�",50,2000,"����, ����                           "));
	      tot.add(new Flower_tot("19","�����",50,1000,"������, ������ ���            "));
	      tot.add(new Flower_tot("20","��ȭ",50,2000,"��Ӵ��� ���                         "));
	      tot.add(new Flower_tot("21","�ﷹ���罺",50,2000,"���� ������ �޷��ּ���        "));
	      tot.add(new Flower_tot("22","�Ȱ���",50,1000,"���� ����, ������ ����, ����� ����"));
	      tot.add(new Flower_tot("23","��Į������",50,1000,"�߾�                              "));


	      //�ʱ� �� ���
	      fl.add(new Flower("����ȭ","1",50, "2020-03-12",6));
	      fl.add(new Flower("������","2", 50,  "2020-03-12",6));
	      fl.add(new Flower("������","3", 50,  "2020-03-11",5));
	      fl.add(new Flower("�������","4", 50, "2020-03-06",0));
	      fl.add(new Flower("�������","4", 50, "2020-03-06",0));
	      fl.add(new Flower("������","5", 50, "2020-03-06",0));
	      fl.add(new Flower("��������","6", 50, "2020-03-12"));
	      fl.add(new Flower("����","7", 50, "2020-03-12"));
	      fl.add(new Flower("���϶�","8", 50,  "2020-03-12"));
	      fl.add(new Flower("�Ķ����","9", 50,  "2020-03-12"));
	      fl.add(new Flower("����","10", 50, "2020-03-12"));
	      fl.add(new Flower("ī���̼�","11",50,"2020-03-12"));
	      fl.add(new Flower("��ȫ���","12",50,  "2020-03-12"));
	      fl.add(new Flower("�󺥴�","13",50, "2020-03-12"));
	      fl.add(new Flower("�عٶ��","14",50, "2020-03-12"));
	      fl.add(new Flower("�ڽ���","15", 50,"2020-03-12"));
	      fl.add(new Flower("�޸���","16", 50, "2020-03-12"));
	      fl.add(new Flower("ī��","17", 50,  "2020-03-12"));
	      fl.add(new Flower("�ʷղ�","18", 50, "2020-03-12"));
	      fl.add(new Flower("�����","19", 50,  "2020-03-12"));
	      fl.add(new Flower("��ȭ","20", 50,  "2020-03-12"));
	      fl.add(new Flower("�ﷹ���罺","21", 50, "2020-03-12"));
	      fl.add(new Flower("�Ȱ���", "22", 50, "2020-03-12"));
	      fl.add(new Flower("��Į������","23", 50, "2020-03-12"));


		length = tot.size();
		
		// ��ٱ��ϸ� ���� ������ �ִ� ������ ������ ���纻 ����Ѵ�.
		fl_cl = new LinkedList<Flower>();
		fl_tot_cl = new LinkedList<Flower_tot>();

		fl_cl = boksa(fl);
		fl_tot_cl = boksa_tot(tot);
     
		//ȸ������
		//UserInfo u_ob = new UserInfo();
		
	}
		// ������ �ִ� ��ǰ ��� ������ �����ϴ� �Լ�
		public static List<Flower> boksa(List<Flower> list){
			List<Flower> temp = new ArrayList<Flower>();
			for(int i=0; i< list.size(); i++){
				temp.add(new Flower(list.get(i).getF_name()				// ��ǰ��
									, list.get(i).getF_num() 			// ��ǰ �ڵ�
									, list.get(i).getF_su() 			// ���
									, list.get(i).getF_wareDate()));    // �԰� ����
			}
			return temp;      
		}
		// ������ �ִ� �� ����� ���� ������ �����ϴ� �Լ� 
		public static List<Flower_tot> boksa_tot(List<Flower_tot> list){
			List<Flower_tot> temp = new ArrayList<Flower_tot>();
			
			for(int i=0; i< list.size(); i++){   
				temp.add(new Flower_tot(list.get(i).getFt_num()			// ���� �ڵ�
										, list.get(i).getFt_name()		// ��ǰ��
										, list.get(i).getFt_tot() 		// �� ���
										, list.get(i).getFt_price()		// ����
										, list.get(i).getFt_mean()));	// �ɸ�
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

		//�Ѽ� ���� (��������)
		return (s1.getFt_tot()) - (s2.getFt_tot());   
		//return (s1.getFt_name()).compareTo(s2.getFt_name());
	}
}

//������� �������� ������ ���� Ŭ����
class MyComparator2<T> implements Comparator<T>{ 

	@Override
		public int compare(T o1, T o2){   
		Flower s1 = (Flower) o1;                        
      Flower s2 = (Flower) o2;

 
       //�Ѽ� ���� (��������)
       return (s1.getF_count()) - (s2.getF_count());   
		//return (s1.getFt_name()).compareTo(s2.getFt_name());
     }

}

//������� ���������� ���� Ŭ����
class MyComparator3<T> implements Comparator<T>{ 

	@Override
		public int compare(T o1, T o2){   
		Flower s1 = (Flower) o1;                        
      Flower s2 = (Flower) o2;

 
       //�Ѽ� ���� (��������)
       return (s2.getF_count()) - (s1.getF_count());   
		//return (s1.getFt_name()).compareTo(s2.getFt_name());
     }

}
