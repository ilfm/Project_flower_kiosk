package kiosk;
class Flower_tot
{
	String ft_num;		// ���ù�ȣ
	String ft_name;		// ��ǰ��
	String ft_mean;		// �ɸ�
	int ft_tot;			// ���
	int ft_price;		// ����
	int ft_rank = 1;
	int ft_realrank = 1;

	public Flower_tot()
	{
	}

	public Flower_tot(String ft_num , String ft_name ,int ft_tot,int ft_price, String ft_mean)
	{
		this.ft_num= ft_num;
		this.ft_name=ft_name;
		this.ft_tot =ft_tot;
		this.ft_price = ft_price;
		this.ft_mean = ft_mean;
	}
	
	public Flower_tot(String ft_name)
	{
		this.ft_name = ft_name;
	}
   
	public Flower_tot(String ft_num , String ft_name ,int ft_tot)
	{
		this.ft_num= ft_num;
		this.ft_name=ft_name;
		this.ft_tot =ft_tot;
	}

	public void setFt_num(String ft_num)
	{
		this.ft_num=ft_num;
	}

	public String getFt_num()
	{
		return ft_num;
	}

	public void setFt_name(String ft_name)
	{
		this.ft_name=ft_name;
	}

	public String getFt_name()
	{
		return ft_name;
	}

	public void setFt_tot(int ft_tot)
	{
		this.ft_tot=ft_tot;
	}

	public int getFt_tot()
	{
		return ft_tot;
	}

	public void setFt_price(int ft_price)
	{
		this.ft_price=ft_price;
	}

	public int getFt_price()
	{
		return ft_price;
	}
	
	public void setFt_mean(String ft_mean){
	      this.ft_mean=ft_mean;
	   }

	   public String getFt_mean(){
	      return ft_mean;
	   }
	
	
}