package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class Flower
{
	String f_name;		// �ɸ�
	String f_num;		// ��ǰ�ڵ�
	int f_su;			// ����
	int f_count =7;		// ī��Ʈ
	String f_wareDate;	// �԰�¥

	public Flower()
	{
	}

	public Flower(String f_name)
	{
		this.f_name=f_name;
	}

	public Flower(String f_name,String f_num , int f_su, String f_wareDate)
	{
		this.f_name=f_name;
		this.f_num = f_num;
		this.f_su=f_su;
		this.f_wareDate=f_wareDate;
	}
	 public Flower(String f_name,String f_num , int f_su, String f_wareDate, int f_count)
	{
		this.f_name=f_name;
		this.f_num = f_num;
		this.f_su=f_su;
		this.f_wareDate=f_wareDate;
		this.f_count = f_count;
    }

	public void setF_name(String f_name)
	{
		this.f_name=f_name;
	}

	public String getF_name()
	{
		return f_name;
	}

	public void setF_su(int f_su)
	{
		this.f_su=f_su;
	}

	public int getF_su()
	{
		return f_su;
	}

	public void setF_num(String f_num) 
	{
		this.f_num=f_num;
	}

	public String getF_num()
	{
		return f_num;
	}

	public void setF_wareDate(String f_wareDate)
	{
		this.f_wareDate=f_wareDate;
	}

	public String getF_wareDate()
	{
		return f_wareDate;
	}

	public int getF_count()
	{
		return f_count;
	}
	public void setFl_cl(int fl_clUser) //����ڰ� �Է��� ��
    {
		this.f_su-=fl_clUser;
    }
  
}
