package kiosk;
import java.util.*;
import java.io.*;

class C_FlowerUser extends Cho
{
	static Scanner sc;
	static String y,u,u2; //y or n �Է¹޴� ���� / u:������ �ɴٹ�
	static int m,j;
	static int n;
	static String size,sizesu;
   

	void offer() //��õ �ɴٹ�
	{
		boolean f=true; 
			sc=new Scanner(System.in);
			CLIO.clearScreen_10();
			System.out.println("======================================================================================================");
			System.out.println("   [��õ�ɴٹ�]                                                          ��M=�ѷ����⡹/��X=��ü��ҡ�");
			System.out.println("======================================================================================================");
			System.out.print(" �� ����, ���� �Է��ϼ���. ");
			CLIO.clearScreen(25);
			cal();
			do
			{
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.printf(" No.  |      ��õ �����      |        ��ǰ��        |                   ��ǰ�Ұ�\n");
				System.out.println("------------------------------------------------------------------------------------------------------");
				if(m==1){
					System.out.println(" 1.\t1���� ź��ȭ(1��)\t\t�Ѱᰰ������\t�̴��� ź��ȭ ����ȭ ���ɷ� �ܿﳪ��~\t�� ����ȭ");
					System.out.println(" 2.\t�Ķ����(1��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
					System.out.println(" 3.\t�������(1��)\t\t�������\t�������!\t\t�� �������");
					System.out.println("-----------------------------------------------------------------------------------\n");
					
					 do{
						 try{  
								System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
								CLIO.clearScreen(4);
								n=CLIO.input();
								if (n>=1 && n<=3){ //1~3����
								switch(n)
								{
									case 1: u="����ȭ"; u2="�Ѱᰰ������";break;
									case 2: u="�Ķ����";u2="�Ķ����";break;
									case 3: u="�������";u2="�������";
								}f=false;
								}else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
							}
							catch (NumberFormatException e){
						  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
						  f=true;}
			  }while(f);
			}
			else if(m==2)
			{
				System.out.println(" 1.\t2���� ź��ȭ(2��)\t\t�̾���������\t�̴��� ź��ȭ ������ ���ɷ� ������ �غ�!\t�� ������");
				System.out.println(" 2.\t������ ����(2��)\t\t����ǳ���\t�Ƹ��ٿ� �������� �Բ��ؿ�~\t\t\t�� ������");
				System.out.println(" 3.\t�߷�Ÿ�ε���(2/14)\t\t����Ʈ����\t���ݸ��� �Բ� �ִ� �ɴٹ߷� ��������UP!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
				
				do{
					 try{  
							System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
							CLIO.clearScreen(4);
							n=CLIO.input();
							if (n>=1 && n<=3){ //1~3����
							switch(n)
						   {
							  case 1: u="������"; u2="�̾���������";break;
							  case 2: u="������";u2="����ǳ���";break;
							  case 3: u="�������";u2="����Ʈ����";
						   }
					   f=false;
					  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				 }
		 
					catch (NumberFormatException e)
					   {
						  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
						  f=true;
					   }
			  }while(f);
			}
			else if(m==3)
			{      
				System.out.println(" 1.\t3���� ź��ȭ(3��)\t\t���̸�������\t�̴��� ź��ȭ ������ ���ɷ� �̱׷��� ������!\t�� ������");
				System.out.println(" 2.\t���н� ����(3��)\t\t�Ǿ�����\t������ ����� ���ο� ����� �����մϴ�~\t\t�� ��������");
				System.out.println(" 3.\tȭ��Ʈ����(3/14)\t\t����������\t�޴��� ������ ��︮�� ȭ���� ����\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
		do
		  {
			 try
			 {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				 if (n>=1 && n<=3){ //1~3����
				switch(n)
				   {
					  case 1: u="������"; u2="���̸�������"; break;
					  case 2: u="��������";u2="�Ǿ�����";break;
					  case 3: u="�������";u2="t����������";
				   }  
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==4)
			{
				System.out.println(" 1.\t4���� ź��ȭ(4��)\t\t���ɾ��Ǿ��\t���ɳ��� ����, ����Ʈ�� �Ѵٹ�!\t�� ����");
				System.out.println(" 2.\t�Ķ����(4��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 3.\t�������(4��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
				do
      {
         try
         {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				if (n>=1 && n<=3){ //1~3����
				  switch(n)
				  {
					 case 1: u="����"; u2="���ɾ��Ǿ��";break;
					 case 2: u="�Ķ����";u2="�Ķ����";break;
					 case 3: u="�������";u2="�������";
				  } 
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==5)
			{
				System.out.println(" 1.\t5���� ź��ȭ(5��)\t������\t\t�̴��� ź��ȭ ���϶����� ȯ������ ������~!\t\t�� ���϶�");
				System.out.println(" 2.\t�����ǳ�(5��)\t\t��Ǿ�ؾ��Ʈ\t�������� �߾��� �Ϻ��ϰ� �������ϴ� ���!\t\t�� �Ķ����");
				System.out.println(" 3.\t��̳�(5/5)\t\t�츮�鼼��\t�츮���� �����ε� �� �ڶ�� �⵵�ϴ� ��������~\t\t�� ����");
				System.out.println(" 4.\t����̳�(5/8)\t\t����̵ȸ���\tī���̼� ���ɷ� �������� ���ؿ�~\t\t\t�� ī���̼�");
				System.out.println(" 5.\t�����(5/14)\t\t����Բ��ҷ�\t�״����� ��ó �������ΰ��� ������� �Ѽ��� ����~��\t�� �������");
				System.out.println(" 6.\t�����ǳ�(5/15)\t\t�����ϴ±״�\t�����ϸ�, ������ ����-  \t\t\t\t�� ī���̼�");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(2);
				n=CLIO.input();
				if (n>=1 && n<=6){ 
				 switch(n)
				   {
					  case 1: u="���϶�"; u2="������";break;
					  case 2: u="�Ķ����"; u2="��Ǿ�ؾ��Ʈ"; break;
					  case 3: u="����";u2="�츮�鼼��";break;
					  case 4: u="ī���̼�";u2="����̵ȸ���";break;
					  case 5: u="�������";u2="����Բ��ҷ�";break;
					  case 6: u="ī���̼�";u2="�����ϴ±״�";
				   }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==6)
			{
				System.out.println(" 1.\t6���� ź��ȭ(6��)\t��������\t�̴��� ź��ȭ ��ũ&ȭ��Ʈ ��̷� ȭ���ϰ�~\t�� ��ȫ���");
				System.out.println(" 2.\t�Ķ����(6��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 3.\t�������(6��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				if (n>=1 && n<=3){ //1~3����
				  switch(n)
				  {
					 case 1: u="��ȫ���"; u2="��������";break;
					 case 2: u="�Ķ����";u2="�Ķ����";break;
					 case 3: u="�������";u2="�������";
				  }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==7)
			{
				System.out.println(" 1.\t7���� ź��ȭ(7��)\t��������\t�̴��� ź��ȭ �󺥴� ���ɷ� ������ ����ϰ�-\t�� �󺥴�");
				System.out.println(" 2.\t�Ķ����(7��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				 System.out.println(" 3.\t�������(7��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
					  do
      {
         try
         {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				 if (n>=1 && n<=3){ //1~3����
				  switch(n)
				  {
					 case 1: u="�󺥴�"; u2="��������";break;
					 case 2: u="�Ķ����";u2="�Ķ����";break;
					 case 3: u="�������";u2="�������";
				  }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}

			else if(m==8)
			{
				System.out.println(" 1.\t8���� ź��ȭ(8��)\t���ö������\t�̴��� ź��ȭ�� ��Ÿ� �ٶ󺸴� �عٶ��!\t�� �عٶ��");
				System.out.println(" 2.\t������ ����(8��)\tƯ���Ѹ�����\t�ڽ��� ������ ��︮�� Ư������ ����!\t\t�� �ڽ���");
				System.out.println(" 3.\t�Ķ����(8��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 4.\t�������(8��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
				 if (n>=1 && n<=4){ 
				switch(n)
				   {
					  case 1: u="�عٶ��"; u2="���ö������";break;
					  case 2: u="�ڽ���"; u2="Ư���Ѹ�����";break;
					  case 3: u="�Ķ����"; u2="�Ķ����";break;
					  case 4: u="�������"; u2="�������";
				   }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==9)
			{
				System.out.println(" 1.\t9���� ź��ȭ(9��)\t�޸���\t�̴��� ź��ȭ �޸��� ���ɷ� �ٰ����� ��������!\t�� �޸���");
				System.out.println(" 2.\t�Ķ����(9��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 3.\t�������(9��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
	
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
				
							  if (n>=1 && n<=3){ //1~3����
				  switch(n)
				  {
					 case 1: u="�޸���"; u2="�޸���";break;
					 case 2: u="�Ķ����";u2="�Ķ����";break;
					 case 3: u="�������";u2="�������";
				  }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==10)
			{
				System.out.println(" 1.\t10���� ź��ȭ(10��)\tī��\t�̴��� ź��ȭ ī�� ���ɷ� �ܷ��� �ʾ�!\t�� ī��");
				System.out.println(" 2.\t�Ķ����(10��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 3.\t�������(10��)\t\t�������\t�������!\t\t�� �������");
	do
      {
         try
         {  System.out.println("------------------------------------------------------------------------------------------------------\n");
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(4);
				n=CLIO.input();
			  if (n>=1 && n<=3){ //1~3����
				  switch(n)
				  {
					 case 1: u="ī��"; u2="ī��";break;
					 case 2: u="�Ķ����";u2="�Ķ����";break;
					 case 3: u="�������";u2="�������";
				  }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}
			else if(m==11)
			{
				System.out.println(" 1.\t11���� ź��ȭ(11��)\t�ʷղ�\t�̴��� ź��ȭ �ʷղ� ���ɷ� �Ʊ��ڱ��ϰ� �����ؿ�~ \t�� �ʷղ�");
				System.out.println(" 2.\t�����ε���(11/11)\t�Լ�������\t�����θ� �����ϱ�� �ɽ����ݾƿ�~\t\t�� �����");
				System.out.println(" 3.\t�Ķ����(11��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 4.\t�������(11��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
			  if (n>=1 && n<=4){
				switch(n)
				   {
					  case 1: u="�ʷղ�"; u2="�ʷղ�";break;
					  case 2: u="�����"; u2="�Լ�������";break;
					  case 3: u="�Ķ����";u2="�Ķ����";break;
					  case 4: u="�������";u2="�������";
				   }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}

			else if(m==12)
			{
				System.out.println(" 1.\t12���� ź��ȭ(12��)\t���ɻ�����\t�� ���� ��︱ �̴��� ź��ȭ ��ȭ����! \t�� ��ȭ");
				System.out.println(" 2.\tũ��������(12��)\tȭ��Ʈ�����\tƮ�� ���ʸ�Ʈ�� ����ϰ�, ������ ���! \t�� �ﷹ���罺");
				System.out.println(" 3.\t�Ķ����(12��)\t\t�Ķ����\t�Ķ����!\t\t�� �Ķ����");
				System.out.println(" 4.\t�������(12��)\t\t�������\t�������!\t\t�� �������");
				System.out.println("------------------------------------------------------------------------------------------------------\n");
	do
      {
         try
         {  
				System.out.print(" �� ���Ÿ� ���Ͻô� ��ǰ��ȣ�� �������ּ���.(���� �Է�) : ");
				CLIO.clearScreen(3);
				n=CLIO.input();
			  if (n>=1 && n<=4){ 
					switch(n)
				   {
					  case 1: u="��ȭ"; u2="���ɻ�����"; break;
					  case 2: u="�ﷹ���罺"; u2="ȭ��Ʈ�����";break;
					  case 3: u="�Ķ����";u2="�Ķ����";break;
					  case 4: u="�������";u2="�������";
				   }
			   f=false;
			  
			  }else System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		 }
 
			catch (NumberFormatException e)
               {
                  System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
                  f=true;
               }
	  }while(f);
	}    

			System.out.println(" �� '"+u2+"'�� �����ϼ̽��ϴ�!");

			System.out.println();
			System.out.println(" �� ���� �ȳ� �� ");
			System.out.println("-----------------------------------------------------");
			System.out.printf(" No.\t|\t������\t    |   \t����\n");
			System.out.println("-----------------------------------------------------");
			System.out.println(" 1.\t\tS(10pcs)\t\t10,000��");
			System.out.println(" 2.\t\tM(20pcs)\t\t20,000��");
			System.out.println(" 3.\t\tL(30pcs)\t\t30,000��");
			System.out.println(" 4.\t\tXL(40pcs)\t\t40,000��");
			System.out.println("-----------------------------------------------------\n");
			  
	do
      {
         try
         {  	 
			System.out.print(" �� ���Ÿ� ���Ͻô� ����� �������ּ���.(���� �Է�) : ");
			size=CLIO.S_input();
			if (size.equals("1")||size.equals("2")||size.equals("3")||size.equals("4")) {
			System.out.print(" �� ���Ÿ� ���Ͻô� ������ �Է����ּ���.(���� �Է�) : ");
			sizesu=CLIO.S_input();
			f=false;
			}else{ f=true;
			System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			}
		 } catch (NumberFormatException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
            f=true;
         }
         catch (IndexOutOfBoundsException e)
         {
            System.out.println(" �� �Է°��� �ùٸ��� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
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
                           System.out.println("�� ��������! "+Cho.fl_tot_cl.get(j).ft_tot+"�� ����");      
                           System.out.println("�� ���ſ� �����ϼ̽��ϴ�.");
                           System.out.print("�� ������ ��� �����Ͻðڽ��ϱ�(Y/N)? : "); 
                           y=CLIO.S_input();
                           flag=false;
                           if(y.equals("N")||y.equals("n")){ select=0; break;}
                           System.out.print("�� ���Ÿ� ���Ͻô� ����� �������ּ���.(���� �Է�):");
                           size=CLIO.S_input();
                           System.out.print("�����Ÿ� ���Ͻô� ������ �Է����ּ���.(���� �Է�):");
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
			 
		 // ���϶�, ������1 , 1��, 1000�� => 10�������ϴ°Ŵϱ� 10000�� 
         //ob1.setSize(Integer.parseInt(size));
         //ob1.setSu(Integer.parseInt(sizesu));
         FlowerKiosk.CartDB_list.add(new CartDB("[��õ�ɴٹ�]"+ u, Integer.parseInt(size), Integer.parseInt(sizesu), Integer.parseInt(size)*10000*Integer.parseInt(sizesu)));
         if(flag==true)
         Money.userCash+=Integer.parseInt(size)*10000*Integer.parseInt(sizesu);
         
          
         System.out.println("���� �ݾ� : "+Money.userCash);
         //System.out.println("���� �� ���� : "+fl_cl.get(j).f_su);
      System.out.print("�� ��õ���� ��� �����Ͻðڽ��ϱ�(Y/N)? : ");   
     y=CLIO.S_input();   
     for(int i=0;i<fl_cl.size();i++)
     System.out.println("�̸�:"+fl_cl.get(i).f_name+"��:"+fl_cl.get(i).f_su);
      
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
		int y, m;      //-- ��, ��
		int w;         //-- ����
		int i;         //-- ���� ����
		
		do
		{
			System.out.print(" �� ���� �Է� : "); //�߭� ���� ������ Ȯ���ϱ� ���� �Է¹޿�
			y=CLIO.input(); 
		}
		while (y<1);

		do
		{
			System.out.print(" �� �� �Է�   : ");
			m=CLIO.input();
			this.m=m;
		}
		while (m<1 || m>12);

		cal.set(y, m-1, 1);
		w = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println();
		System.out.println("\t[ " + y + "�� " + m + "�� ]\n");
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
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