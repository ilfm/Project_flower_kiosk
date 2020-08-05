package kiosk;
class CartDB
{
   String ca_name;//꽃 이름
   int ca_price; //꽃 가격
   int ca_su; //꽃 수량
   int ca_size; //꽃다발 사이즈

   CartDB(String name,int size, int su, int price)
   {
	   ca_name = name;
	   ca_size = size;
	   ca_su = su;
	   ca_price = price;
   }
   
   public void setName_FlowerUser(String ca_name)
   {
      this.ca_name="[추천꽃다발]"+ca_name;
   }
   String getName_FlowerUser()
   {
      return ca_name;
   }
   public void setName_RandomFlower(String ca_name)
   {
      this.ca_name="[랜덤꽃다발]"+ca_name;
   }
    String getName_RandomFlower()
   {
      return ca_name;
   }
   public  void setName_DIYFlower(String ca_name)
   {
      this.ca_name="[DIY꽃다발]"+ca_name;
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
         return "S사이즈";
      }
      else if(ca_size == 2)
      {
         return "M사이즈";
      }
      else if(ca_size == 3)
      {
         return "L사이즈";
      }
      else if(ca_size == 4)
      {
         return "XL사이즈";
      }
      else
      {
         return "사이즈 알 수 없음";
      }
   }
}


