package kiosk;
class CartDB
{
   String ca_name;//�� �̸�
   int ca_price; //�� ����
   int ca_su; //�� ����
   int ca_size; //�ɴٹ� ������

   CartDB(String name,int size, int su, int price)
   {
	   ca_name = name;
	   ca_size = size;
	   ca_su = su;
	   ca_price = price;
   }
   
   public void setName_FlowerUser(String ca_name)
   {
      this.ca_name="[��õ�ɴٹ�]"+ca_name;
   }
   String getName_FlowerUser()
   {
      return ca_name;
   }
   public void setName_RandomFlower(String ca_name)
   {
      this.ca_name="[�����ɴٹ�]"+ca_name;
   }
    String getName_RandomFlower()
   {
      return ca_name;
   }
   public  void setName_DIYFlower(String ca_name)
   {
      this.ca_name="[DIY�ɴٹ�]"+ca_name;
   }
   String getName_DIYFlower()
   {
      return ca_name;
   }

   void setPrice(int price)
   {
      this.ca_price = price;
   }

   int getPrice()
   {
      return ca_price;
   }

   void setSu(int su)
   {
      this.ca_su = su;
   }

   int getSu()
   {
      return ca_su;
   }

   void setSize(int size)
   {
      this.ca_size = size;
   }
   
   String getSize()
   {
	   if (ca_size == 0)
	   {
		   return " ";
	   
	   }
	   else if (ca_size == 1)
      {
         return "S������";
      }
      else if(ca_size == 2)
      {
         return "M������";
      }
      else if(ca_size == 3)
      {
         return "L������";
      }
      else if(ca_size == 4)
      {
         return "XL������";
      }
      else
      {
         return "������ �� �� ����";
      }
   }
}


