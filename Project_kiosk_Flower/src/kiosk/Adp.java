package kiosk;
import java.util.*;
import java.text.*;
import java.io.*;

class Adp
{
	static int msg = 50;			// �޼���ī�� ����
	static int basket = 50;			// �ٱ���
	static int paper = 50;			// ������
	static int ribbon = 50;			// ����
	static int miniflo = 50;		// �̴ϲɴٹ�
	
	public void setMsg(int msg)
	{
		this.msg=msg;
	}

	public int getMsg()
	{
		return msg;
	}

	public void setBasket(int basket)
	{
		this.basket=basket;
	}

	public int getBasket()
	{
		return basket;
	}

	public void setPaper(int paper)
	{
		this.paper=paper;
	}

	public int getPaper()
	{
		return paper;
	}

	public void setRibbon(int ribbon)
	{
		this.ribbon=ribbon;
	}

	public int getRibbon()
	{
		return ribbon;
	}

	public void setMiniflo(int miniflo)
	{
		this.miniflo = miniflo;
	}

	public int getMiniflo()
	{
		return miniflo;
	}
}