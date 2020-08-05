package kiosk;
import java.util.*;
import java.io.*;
import java.text.*;

class Money
{
	static int userCash;			// 장바구니에 담은 금액
	static int cash;				// 수익금
	static int exc_10000 = 20;		// 잔돈
	static int exc_5000 = 20;		// 잔돈
	static int exc_1000 = 50;		// 잔돈
	static int exc_tot = (exc_10000*10000) + (exc_5000*5000) + (exc_1000*10000);	// 보유잔고 초기화

	public void setUserCash(int userCash)
	{
		this.userCash = userCash;
	}

	public int getUserCash()
	{
		return userCash;
	}

	public void setCash(int cash)
	{
		this.cash = cash;
	}

	public int getCash()
	{
		return cash;
	}

	public void setExc_10000(int exc_10000)
	{
		this.exc_10000 = exc_10000;
	}

	public int getExc_10000()
	{
		return exc_10000;
	}

	public void setExc_5000(int exc_5000)
	{
		this.exc_5000 = exc_5000;
	}

	public int getExc_5000()
	{
		return exc_5000;
	}

	public void setExc_1000(int exc_1000)
	{
		this.exc_1000 = exc_1000;
	}

	public int getExc_1000()
	{
		return exc_1000;
	}


	//10000원권 거스름돈 더해주는 메소드
	public void addExc_10000(int exc_10000)
	{
		this.exc_10000+=exc_10000;
	}


	//5000원권 거스름돈 더해주는 메소드
	public void addExc_5000(int exc_5000)
	{
		this.exc_5000+=exc_5000;
	}


	//1000원권 거스름돈 더해주는 메소드
	public void addExc_1000(int exc_1000)
	{
		this.exc_1000+=exc_1000;
	}
	public void setExc_tot(int exc_tot)
	{
	      this.exc_tot = exc_tot;
	}

   public int getExc_tot()
   {
      return exc_tot;
   }

}