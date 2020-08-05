package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class Flower
{
	String f_name;		// 꽃명
	String f_num;		// 상품코드
	int f_su;			// 수량
	int f_count =7;		// 카운트
	String f_wareDate;	// 입고날짜

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
	public void setFl_cl(int fl_clUser) //사용자가 입력한 값
    {
		this.f_su-=fl_clUser;
    }
  
}
