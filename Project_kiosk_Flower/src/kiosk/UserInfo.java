package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class UserInfo
{
 	String cus_tel;			// 전화번호
 	String cus_pw;			// 비밀번호	
 	static int c_count;		// 쿠폰개수
	static String prize;	// 당첨상품
	int money;				// 적립금
	String ranCou;			// 랜덤 쿠폰
	static List<String> prizeCo=new LinkedList<String>();

	public UserInfo()
	{
	}
	
	public UserInfo(String cus_tel)
	{
		this.cus_tel=cus_tel;
	}

	public UserInfo(String cus_pw,int c_count)
	{
		this.cus_pw=cus_pw;
		this.c_count=c_count;
	}

	public UserInfo(String cus_tel,String cus_pw,int c_count)
	{
		this.cus_tel=cus_tel;
		this.cus_pw=cus_pw;
		this.c_count=c_count;
	}

	public void setCus_tel(String cus_tel)
	{
		this.cus_tel=cus_tel;
	}

	public String getCus_tel()
	{
		return cus_tel;
	}

	public void setCus_pw(String cus_pw)
	{
		this.cus_pw=cus_pw;
	}

	public String getCus_pw()
	{
		return cus_pw;
	}

	public void setPrize(String prize)
	{
		prizeCo.add(this.prize=prize);
	}

	public String getPrize()
	{
		return prize;
	}
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public int getMoney()
	{
		return money;
	}
}