package kiosk;
import java.util.*;
import java.io.*;

class C_FlowerUser extends Cho
{
	static Scanner sc;
	static String y,u,u2; //y or n ÀÔ·Â¹Þ´Â º¯¼ö / u:¼±ÅÃÇÑ ²É´Ù¹ß
	static int m,j;
	static int n;
	static String size,sizesu;
   

	void offer() //ÃßÃµ ²É´Ù¹ß
	{
		boolean f=true; 
			sc=new Scanner(System.in);
			CLIO.clearScreen_10();
			System.out.println("======================================================================================================");
			System.out.println("   [ÃßÃµ²É´Ù¹ß]                                                          ¡¸M=µÑ·¯º¸±â¡¹/¡¸X=ÀüÃ¼Ãë¼Ò¡¹");
			System.out.println("======================================================================================================");
			System.out.print(" ¢º ¿¬µµ, ¿ùÀ» ÀÔ·ÂÇÏ¼¼¿ä. ");
			CLIO.clearScreen(25);
			cal();
			do
			{
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.printf(" No.  |      ÃßÃµ ±â³äÀÏ      |        »óÇ°¸í        |                   »óÇ°¼Ò°³\n");
				System.out.println("------------------------------------------------------------------------------------------------------");
				if(m==1){
					System.out.println(" 1.\t1¿ùÀÇ Åº»ýÈ­(1¿ù)\t\tÇÑ°á°°Àº¸¶À½\tÀÌ´ÞÀÇ Åº»ýÈ­ ¼ö¼±È­ ºÎÄÉ·Î °Ü¿ï³ª±â~\t¡æ ¼ö¼±È­");
					System.out.println(" 2.\tÆÄ¶õÀå¹Ì(1¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
					System.out.println(" 3.\t»¡°£Àå¹Ì(1¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
					System.out.println("-----------------------------------------------------------------------------------\n");
					
					 do{
						 try{  
								System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
								CLIO.clearScreen(4);
								n=CLIO.input();
								if (n>=1 && n<=3){ //1~3±îÁö
								switch(n)
								{
									case 1: u="¼ö¼±È­"; u2="ÇÑ°á°°Àº¸¶À½";break;
									case 2: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
									case 3: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
								}f=false;
								}else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
							}
							catch (NumberFormatException e){
						  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
						  f=true;}
			  }while(f);
			}
			else if(m==2)
			{
				System.out.println(" 1.\t2¿ùÀÇ Åº»ýÈ­(2¿ù)\t\t¹Ì¾ÅÀ¯Æ÷¿¡¹ö\tÀÌ´ÞÀÇ Åº»ýÈ­ ¹°¹æÃÊ ºÎÄÉ·Î º½¸ÂÀÌ ÁØºñ!\t¡æ ¹°¸ÁÃÊ");
				System.out.println(" 2.\tÁ¹¾÷½Ä ½ÃÁð(2¿ù)\t\t´ç½ÅÀÇ³»ÀÏ\t¾Æ¸§´Ù¿î ¸¶¹«¸®¸¦ ÇÔ²²ÇØ¿ä~\t\t\t¡æ ³ë¶õÀå¹Ì");
				System.out.println(" 3.\t¹ß·»Å¸ÀÎµ¥ÀÌ(2/14)\t\t½ºÀ§Æ®ÃÊÄÚ\tÃÊÄÝ¸´°ú ÇÔ²² ÁÖ´Â ²É´Ù¹ß·Î °¨µ¿Áö¼öUP!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
				
				do{
					 try{  
							System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
							CLIO.clearScreen(4);
							n=CLIO.input();
							if (n>=1 && n<=3){ //1~3±îÁö
							switch(n)
						   {
							  case 1: u="¹°¸ÁÃÊ"; u2="¹Ì¾ÅÀ¯Æ÷¿¡¹ö";break;
							  case 2: u="³ë¶õÀå¹Ì";u2="´ç½ÅÀÇ³»ÀÏ";break;
							  case 3: u="»¡°£Àå¹Ì";u2="½ºÀ§Æ®ÃÊÄÚ";
						   }
					   f=false;
					  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
				 }
		 
					catch (NumberFormatException e)
					   {
						  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
						  f=true;
					   }
			  }while(f);
			}
			else if(m==3)
			{      
				System.out.println(" 1.\t3¿ùÀÇ Åº»ýÈ­(3¿ù)\t\tµ¥ÀÌ¸®µ¥ÀÌÁö\tÀÌ´ÞÀÇ Åº»ýÈ­ µ¥ÀÌÁö ºÎÄÉ·Î ½Ì±×·¯¿î º½¸ÂÀÌ!\t¡æ µ¥ÀÌÁö");
				System.out.println(" 2.\tÀÔÇÐ½Ä ½ÃÁð(3¿ù)\t\tÇÇ¾î¶ó»õ½Ï\t¼ÒÁßÇÑ ´ç½ÅÀÇ »õ·Î¿î Ãâ¹ßÀ» ÃàÇÏÇÕ´Ï´Ù~\t\t¡æ ÇÁ¸®Áö¾Æ");
				System.out.println(" 3.\tÈ­ÀÌÆ®µ¥ÀÌ(3/14)\t\tºí¸µÇÁ·ÎÆ÷Áî\t´Þ´ÞÇÑ »çÅÁ°ú ¾î¿ï¸®´Â È­·ÁÇÑ ºÎÄÉ\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
		do
		  {
			 try
			 {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				 if (n>=1 && n<=3){ //1~3±îÁö
				switch(n)
				   {
					  case 1: u="µ¥ÀÌÁö"; u2="µ¥ÀÌ¸®µ¥ÀÌÁö"; break;
					  case 2: u="ÇÁ¸®Áö¾Æ";u2="ÇÇ¾î¶ó»õ½Ï";break;
					  case 3: u="»¡°£Àå¹Ì";u2="tºí¸µÇÁ·ÎÆ÷Áî";
				   }  
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==4)
			{
				System.out.println(" 1.\t4¿ùÀÇ Åº»ýÈ­(4¿ù)\t\tº¢²É¾ÆÇÇ¾î¶ó\tº¢²É³îÀÌ °¥¶§, Æ÷ÀÎÆ®·Î ÇÑ´Ù¹ß!\t¡æ º¢²É");
				System.out.println(" 2.\tÆÄ¶õÀå¹Ì(4¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 3.\t»¡°£Àå¹Ì(4¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
				do
      {
         try
         {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				if (n>=1 && n<=3){ //1~3±îÁö
				  switch(n)
				  {
					 case 1: u="º¢²É"; u2="º¢²É¾ÆÇÇ¾î¶ó";break;
					 case 2: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					 case 3: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				  } 
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==5)
			{
				System.out.println(" 1.\t5¿ùÀÇ Åº»ýÈ­(5¿ù)\tº¸¶óÇØ\t\tÀÌ´ÞÀÇ Åº»ýÈ­ ¶óÀÏ¶ôÀ¸·Î È¯¼ºÀûÀÎ ¿¬ÃâÀ»~!\t\t¡æ ¶óÀÏ¶ô");
				System.out.println(" 2.\t¼º³âÀÇ³¯(5¿ù)\t\tÆÛÇ¾¾Ø¾î´úÆ®\t½º¹«»ìÀÇ Ãß¾ïÀ» ¿Ïº®ÇÏ°Ô ¸¶¹«¸®ÇÏ´Â ¹æ¹ý!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 3.\t¾î¸°ÀÌ³¯(5/5)\t\t¿ì¸®µé¼¼»ó\t¿ì¸®¾ÆÀÌ ¾ÕÀ¸·Îµµ Àß ÀÚ¶ó±æ ±âµµÇÏ´Â ¸¶À½À¸·Î~\t\t¡æ ¼ö±¹");
				System.out.println(" 4.\t¾î¹öÀÌ³¯(5/8)\t\t¾î¹öÀÌµÈ¸¶À½\tÄ«³×ÀÌ¼Ç ºÎÄÉ·Î °¨»çÇÔÀ» ÀüÇØ¿ä~\t\t\t¡æ Ä«³×ÀÌ¼Ç");
				System.out.println(" 5.\t·ÎÁîµ¥ÀÌ(5/14)\t\tÆò»ýÇÔ²²ÇÒ·¡\t±×´ÙÀ½¿£ ±ÙÃ³ ²ÉÁýÀ¸·Î°¡¼­ »¡°£Àå¹Ì ÇÑ¼ÛÀÏ »òÁÒ~¢Ý\t¡æ ·¹µå·ÎÁî");
				System.out.println(" 6.\t½º½ÂÀÇ³¯(5/15)\t\tÁ¸°æÇÏ´Â±×´ë\tº¸´äÇÏ¸®, ½º½ÂÀÇ ÀºÇý-  \t\t\t\t¡æ Ä«³×ÀÌ¼Ç");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(2);
				n=CLIO.input();
				if (n>=1 && n<=6){ 
				 switch(n)
				   {
					  case 1: u="¶óÀÏ¶ô"; u2="º¸¶óÇØ";break;
					  case 2: u="ÆÄ¶õÀå¹Ì"; u2="ÆÛÇ¾¾Ø¾î´úÆ®"; break;
					  case 3: u="¼ö±¹";u2="¿ì¸®µé¼¼»ó";break;
					  case 4: u="Ä«³×ÀÌ¼Ç";u2="¾î¹öÀÌµÈ¸¶À½";break;
					  case 5: u="»¡°£Àå¹Ì";u2="Æò»ýÇÔ²²ÇÒ·¡";break;
					  case 6: u="Ä«³×ÀÌ¼Ç";u2="Á¸°æÇÏ´Â±×´ë";
				   }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==6)
			{
				System.out.println(" 1.\t6¿ùÀÇ Åº»ýÈ­(6¿ù)\t·ÎÁö·ÎÁî\tÀÌ´ÞÀÇ Åº»ýÈ­ ÇÎÅ©&È­ÀÌÆ® Àå¹Ì·Î È­»çÇÏ°Ô~\t¡æ ºÐÈ«Àå¹Ì");
				System.out.println(" 2.\tÆÄ¶õÀå¹Ì(6¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 3.\t»¡°£Àå¹Ì(6¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				if (n>=1 && n<=3){ //1~3±îÁö
				  switch(n)
				  {
					 case 1: u="ºÐÈ«Àå¹Ì"; u2="·ÎÁö·ÎÁî";break;
					 case 2: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					 case 3: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				  }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==7)
			{
				System.out.println(" 1.\t7¿ùÀÇ Åº»ýÈ­(7¿ù)\t¿©¸§¿©Çà\tÀÌ´ÞÀÇ Åº»ýÈ­ ¶óº¥´õ ºÎÄÉ·Î ¸¶À½À» Æí¾ÈÇÏ°Ô-\t¡æ ¶óº¥´õ");
				System.out.println(" 2.\tÆÄ¶õÀå¹Ì(7¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				 System.out.println(" 3.\t»¡°£Àå¹Ì(7¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
					  do
      {
         try
         {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				 if (n>=1 && n<=3){ //1~3±îÁö
				  switch(n)
				  {
					 case 1: u="¶óº¥´õ"; u2="¿©¸§¿©Çà";break;
					 case 2: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					 case 3: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				  }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}

			else if(m==8)
			{
				System.out.println(" 1.\t8¿ùÀÇ Åº»ýÈ­(8¿ù)\t½ãÇÃ¶ó¿öÅõÀ¯\tÀÌ´ÞÀÇ Åº»ýÈ­´Â ´ç½Å¸¸ ¹Ù¶óº¸´Â ÇØ¹Ù¶ó±â!\t¡æ ÇØ¹Ù¶ó±â");
				System.out.println(" 2.\tÁ¹¾÷½Ä ½ÃÁð(8¿ù)\tÆ¯º°ÇÑ¸¶Áö¸·\tÄÚ½º¸ð½º Á¹¾÷¿¡ ¾î¿ï¸®´Â Æ¯º°Á¦ÀÛ ºÎÄÉ!\t\t¡æ ÄÚ½º¸ð½º");
				System.out.println(" 3.\tÆÄ¶õÀå¹Ì(8¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 4.\t»¡°£Àå¹Ì(8¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
				 if (n>=1 && n<=4){ 
				switch(n)
				   {
					  case 1: u="ÇØ¹Ù¶ó±â"; u2="½ãÇÃ¶ó¿öÅõÀ¯";break;
					  case 2: u="ÄÚ½º¸ð½º"; u2="Æ¯º°ÇÑ¸¶Áö¸·";break;
					  case 3: u="ÆÄ¶õÀå¹Ì"; u2="ÆÄ¶õÀå¹Ì";break;
					  case 4: u="»¡°£Àå¹Ì"; u2="»¡°£Àå¹Ì";
				   }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==9)
			{
				System.out.println(" 1.\t9¿ùÀÇ Åº»ýÈ­(9¿ù)\t´Þ¸®¾Æ\tÀÌ´ÞÀÇ Åº»ýÈ­ ´Þ¸®¾Æ ºÎÄÉ·Î ´Ù°¡¿À´Â °¡À»¸ÂÀÌ!\t¡æ ´Þ¸®¾Æ");
				System.out.println(" 2.\tÆÄ¶õÀå¹Ì(9¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 3.\t»¡°£Àå¹Ì(9¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
	
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				
							  if (n>=1 && n<=3){ //1~3±îÁö
				  switch(n)
				  {
					 case 1: u="´Þ¸®¾Æ"; u2="´Þ¸®¾Æ";break;
					 case 2: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					 case 3: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				  }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==10)
			{
				System.out.println(" 1.\t10¿ùÀÇ Åº»ýÈ­(10¿ù)\tÄ«¶ó\tÀÌ´ÞÀÇ Åº»ýÈ­ Ä«¶ó ºÎÄÉ·Î ¿Ü·ÓÁö ¾Ê¾Æ!\t¡æ Ä«¶ó");
				System.out.println(" 2.\tÆÄ¶õÀå¹Ì(10¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 3.\t»¡°£Àå¹Ì(10¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
	do
      {
         try
         {  System.out.println("------------------------------------------------------------------------------------------------------\n");
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
			  if (n>=1 && n<=3){ //1~3±îÁö
				  switch(n)
				  {
					 case 1: u="Ä«¶ó"; u2="Ä«¶ó";break;
					 case 2: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					 case 3: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				  }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==11)
			{
				System.out.println(" 1.\t11¿ùÀÇ Åº»ýÈ­(11¿ù)\tÃÊ·Õ²É\tÀÌ´ÞÀÇ Åº»ýÈ­ ÃÊ·Õ²É ºÎÄÉ·Î ¾Æ±âÀÚ±âÇÏ°Ô ¿¬ÃâÇØ¿ä~ \t¡æ ÃÊ·Õ²É");
				System.out.println(" 2.\t»©»©·Îµ¥ÀÌ(11/11)\tÀÔ¼úÀ»¸ÂÃç\t»©»©·Î¸¸ ¼±¹°ÇÏ±â´Â ½É½ÉÇÏÀÝ¾Æ¿ä~\t\t¡æ ÈòÀå¹Ì");
				System.out.println(" 3.\tÆÄ¶õÀå¹Ì(11¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 4.\t»¡°£Àå¹Ì(11¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
			  if (n>=1 && n<=4){
				switch(n)
				   {
					  case 1: u="ÃÊ·Õ²É"; u2="ÃÊ·Õ²É";break;
					  case 2: u="ÈòÀå¹Ì"; u2="ÀÔ¼úÀ»¸ÂÃç";break;
					  case 3: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					  case 4: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				   }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}

			else if(m==12)
			{
				System.out.println(" 1.\t12¿ùÀÇ Åº»ýÈ­(12¿ù)\t´«²É»ìÆ÷½Ã\tÈò ´«°ú ¾î¿ï¸± ÀÌ´ÞÀÇ Åº»ýÈ­ ¸ñÈ­ºÎÄÉ! \t¡æ ¸ñÈ­");
				System.out.println(" 2.\tÅ©¸®½º¸¶½º(12¿ù)\tÈ­ÀÌÆ®½º³ë¿ì\tÆ®¸® ¿À³Ê¸ÕÆ®·Î Àå½ÄÇÏ°í, »çÁøµµ Âï°í! \t¡æ Çï·¹º¸·ç½º");
				System.out.println(" 3.\tÆÄ¶õÀå¹Ì(12¿ù)\t\tÆÄ¶õÀå¹Ì\tÆÄ¶õÀå¹Ì!\t\t¡æ ÆÄ¶õÀå¹Ì");
				System.out.println(" 4.\t»¡°£Àå¹Ì(12¿ù)\t\t»¡°£Àå¹Ì\t»¡°£Àå¹Ì!\t\t¡æ »¡°£Àå¹Ì");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »óÇ°¹øÈ£¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
			  if (n>=1 && n<=4){ 
					switch(n)
				   {
					  case 1: u="¸ñÈ­"; u2="´«²É»ìÆ÷½Ã"; break;
					  case 2: u="Çï·¹º¸·ç½º"; u2="È­ÀÌÆ®½º³ë¿ì";break;
					  case 3: u="ÆÄ¶õÀå¹Ì";u2="ÆÄ¶õÀå¹Ì";break;
					  case 4: u="»¡°£Àå¹Ì";u2="»¡°£Àå¹Ì";
				   }
			   f=false;
			  
			  }else System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
                  f=true;
               }
	  }while(f);
	}    

			System.out.println(" ¢Ñ '"+u2+"'¸¦ ¼±ÅÃÇÏ¼Ì½À´Ï´Ù!");

			System.out.println();
			System.out.println(" ¢¾ °¡°Ý ¾È³» ¢¾ ");
			System.out.println("-----------------------------------------------------");
			System.out.printf(" No.\t|\t»çÀÌÁî\t    |   \t°¡°Ý\n");
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1.\t\tS(10pcs)\t\t10,000£Ü");
			System.out.println(" 2.\t\tM(20pcs)\t\t20,000£Ü");
			System.out.println(" 3.\t\tL(30pcs)\t\t30,000£Ü");
			System.out.println(" 4.\t\tXL(40pcs)\t\t40,000£Ü");
			System.out.println("-----------------------------------------------------\n");
			  
	do
      {
         try
         {  	 
			System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »çÀÌÁî¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
			size=CLIO.S_input();
			if (size.equals("1")||size.equals("2")||size.equals("3")||size.equals("4")) {
			System.out.print(" ¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â °³¼ö¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â) : ");
			sizesu=CLIO.S_input();
			f=false;
			}else{ f=true;
			System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			}
		 } catch (NumberFormatException e)
         {
            System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
            f=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" ¢Ñ ÀÔ·Â°ªÀÌ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
            f=true;
         }
      }
      while (f);                     

			 int select=Integer.parseInt(size)*10*Integer.parseInt(sizesu);
			   for (int i=0; i<Cho.length; i++)
			  {
			  
				  if(fl_cl.get(i).f_name.equals(u))
				  j=i;
			  }
			boolean flag=true;

			 while(true){

          if(select==0)
             break;
            for(int i =0; i<fl_cl.size(); i++){
            
               if(fl_cl.get(i).f_name.equals(u)&&Cho.fl_tot_cl.get(i).getFt_tot() >= select){
                  if(fl_cl.get(i).getF_su()-select > 0){
                     
                     fl_cl.get(i).setF_su(fl_cl.get(i).getF_su()-select);
                Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
                select=0;
                     break;
                     
                  }else if(fl_cl.get(i).getF_su()-select==0&&Cho.fl_tot_cl.get(j).ft_tot!=0){
                     //fl_cl.remove(i);
                 fl_cl.get(i).setF_su(0);
                 Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
                     select=0;
                break;
                  }else if(fl_cl.get(i).getF_su()-select<0){
                    
                     if(Cho.fl_tot_cl.get(i).getFt_tot() >= select){
                        select=select-fl_cl.get(i).getF_su();
                  Cho.fl_tot_cl.get(i).setFt_tot(Cho.fl_tot_cl.get(i).getFt_tot()-select);
                        break;
                     }
                  }
               }
            else { 
                           if(fl_cl.get(j).f_name.equals(u)&&Cho.fl_tot_cl.get(j).ft_tot<select){
                           do{
                           System.out.println("¢º ¼ö·®ºÎÁ·! "+Cho.fl_tot_cl.get(j).ft_tot+"°³ ³²À½");      
                           System.out.println("¢Ñ ±¸¸Å¿¡ ½ÇÆÐÇÏ¼Ì½À´Ï´Ù.");
                           System.out.print("¢º ¼ö·®À» °è¼Ó ±¸¸ÅÇÏ½Ã°Ú½À´Ï±î(Y/N)? : "); 
                           y=CLIO.S_input();
                           flag=false;
                           if(y.equals("N")||y.equals("n")){ select=0; break;}
                           System.out.print("¢º ±¸¸Å¸¦ ¿øÇÏ½Ã´Â »çÀÌÁî¸¦ ¼±ÅÃÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â):");
                           size=CLIO.S_input();
                           System.out.print("¢º±¸¸Å¸¦ ¿øÇÏ½Ã´Â °³¼ö¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.(¼ýÀÚ ÀÔ·Â):");
                           sizesu=CLIO.S_input();
                           select=Integer.parseInt(size)*10*Integer.parseInt(sizesu);
                        if(fl_cl.get(j).f_name.equals(u)&Cho.fl_tot_cl.get(j).ft_tot>=select){
                        //fl_cl.get(j).f_su-=select;
                           //Money.userCash+=Integer.parseInt(size)*10000*Integer.parseInt(sizesu);
                        y="N";
						flag=true;
                        }
                 
                         }while(Cho.fl_tot_cl.get(j).ft_tot<select&&y.equals("Y")||y.equals("y"));
                           }
                     } 
            }
         }          
			 
		 // ¶óÀÏ¶ô, »çÀÌÁî1 , 1°³, 1000¿ø => 10°³±¸ÀÔÇÏ´Â°Å´Ï±î 10000¿ø 
         //ob1.setSize(Integer.parseInt(size));
         //ob1.setSu(Integer.parseInt(sizesu));
         FlowerKiosk.CartDB_list.add(new CartDB("[ÃßÃµ²É´Ù¹ß]"+ u, Integer.parseInt(size), Integer.parseInt(sizesu), Integer.parseInt(size)*10000*Integer.parseInt(sizesu)));
         if(flag==true)
         Money.userCash+=Integer.parseInt(size)*10000*Integer.parseInt(sizesu);
         
          
         System.out.println("ÇöÀç ±Ý¾× : "+Money.userCash);
         //System.out.println("³²Àº ²É ¼ö·® : "+fl_cl.get(j).f_su);
      System.out.print("¢º ÃßÃµ²ÉÀ» °è¼Ó ±¸¸ÅÇÏ½Ã°Ú½À´Ï±î(Y/N)? : ");   
     y=CLIO.S_input();   
     for(int i=0;i<fl_cl.size();i++)
     System.out.println("ÀÌ¸§:"+fl_cl.get(i).f_name+"¼ö:"+fl_cl.get(i).f_su);
      
      }
      while(y.equals("Y")||y.equals("y"));
		
        System.out.println("===================================================================================");   
		  CLIO.clearScreen_10();
		  Cart.User_Cart();
		  
   }


   void cal()
   {
		Scanner sc=new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		int y, m;      //-- ³â, ¿ù
		int w;         //-- ¿äÀÏ
		int i;         //-- ·çÇÁ º¯¼ö
		
		do
		{
			System.out.print(" ¢º ¿¬µµ ÀÔ·Â : "); //Ãß­ ²ÉÀ» ¿ù¸¶´Ù È®ÀÎÇÏ±â À§ÇØ ÀÔ·Â¹Þ¿ò
			y=CLIO.input(); 
		}
		while (y<1);

		do
		{
			System.out.print(" ¢º ¿ù ÀÔ·Â   : ");
			m=CLIO.input();
			this.m=m;
		}
		while (m<1 || m>12);

		cal.set(y, m-1, 1);
		w = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println();
		System.out.println("\t[ " + y + "³â " + m + "¿ù ]\n");
		System.out.println("  ÀÏ  ¿ù  È­  ¼ö  ¸ñ  ±Ý  Åä");
		System.out.println("============================");

		for (i=1; i<w; i++)
			System.out.print("    ");
		for (i=1; i<=cal.getActualMaximum(Calendar.DATE); i++)
		{
			System.out.printf("%4d", i);
			w++;   
			if(w%7==1)   
			System.out.println();   
		}
		if(w%7!=1)
			System.out.println();   
		System.out.println("============================");
	} //end cal

}