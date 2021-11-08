import java.util.*;
import java.lang.Math.*;

public class Human
{
	//Attributes
	private int id;
	private int age;
	private int height;
	private double weight;
	private char gender;
	public Fio humanFio = new Fio();

	//Methods
	public boolean setId(int buf)
	{
		if (buf < 0 || buf > 9999)
			return (true);
		else
		{
			id = buf;
			return (false);
		}
	}

	public boolean setAge(int buf)
	{
		if (buf < 0 || buf > 200)
			return (true);
		else
		{
			age = buf;
			return (false);
		}
	}

	public boolean setHeight(int buf)
	{
		if (buf < 40 || buf > 300)
			return (true);
		else
		{
			height = buf;
			return (false);
		}
	}

	public boolean setWeight(double buf)
	{
		//round *.* format to *.1 format 
		buf = (double)(Math.round(buf * 10)) / 10;
		if (buf < 0 || buf > 650)
			return (true);
		else
		{
			weight = buf;
			return (false);
		}
	}

	public boolean setGender(char buf)
	{
		//��������� ������� ������ � ���������� ��������
		if (buf == 'M' || buf == 'F')
		{
			gender = buf;
			return(false);
		}
		else
			return (true);
	}

	public int getId()
	{return (id);}

	public int getAge()
	{return (age);}

	public int getHeight()
	{return (height);}

	public double getWeight()
	{return (weight);}

	public char getGender()
	{return (gender);}
	

	public boolean init(int bufId, int bufAge, int bufHeight, double bufWeight, char bufGender, Fio bufFio)
	{
		//������ ������ ������ Human ��� �������� ������� ������� ������
		Human check = new Human();

		if (check.setId(bufId) || check.setAge(bufAge) || check.setHeight(bufHeight) || 
			check.setWeight(bufWeight) || check.setGender(bufGender))
			return (true);
		else
		{
			this.setId(check.getId());
			this.setAge(check.getAge());
			this.setHeight(check.getHeight());
			this.setWeight(check.getWeight());
			this.setGender(check.getGender());
			this.humanFio.init(bufFio.getSurname(), bufFio.getName(), bufFio.getPatronymic());
			return (false);
		}
	}

	public boolean read()
	{
		//������ ������ ������ Human ��� �������� ������� ������� ������
		Human check = new Human();

		//�������� �� ������ ������� ������
		System.out.printf("Enter id:\n");
		Scanner scanner = new Scanner(System.in);
		if (!scanner.hasNextInt())
			return (true);
		else 
		{
			//������� ������ � ���� �������
			if (check.setId(scanner.nextInt()))
				return (true);
			else
			{
				//�������� �� ������ ������� ������
				System.out.printf("Enter age:\n");
				if (!scanner.hasNextInt())
					return (true);
				else 
				{
					//������� ������ � ���� �������
					if (check.setAge(scanner.nextInt()))
						return (true);
					else
					{
						//�������� �� ������ ������� ������
						System.out.printf("Enter height:\n");
						if (!scanner.hasNextInt())
							return (true);
						else 
						{
							//������� ������ � ���� �������
							if (check.setHeight(scanner.nextInt()))
								return (true);
							else
							{
								//�������� �� ������ ������� ������
								System.out.printf("Enter weight:\n");
								if (!scanner.hasNextDouble())
									return (true);
								else 
								{
									//������� ������ � ���� �������
									if (check.setWeight(scanner.nextDouble()))
										return (true);
									else
									{		 
										System.out.printf("Enter gender:\n");
										//�������� �� ������ ������� ������
										if(check.setGender(scanner.next(".").charAt(0)))
											return (true);
										else
										{
											if (check.humanFio.read())
												return (true);
											else
											{
												this.init(
												check.getId(), 
												check.getAge(), 
												check.getHeight(), 
												check.getWeight(), 
												check.getGender(), 
												check.humanFio);
												return(false);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public void display()
	{
		System.out.printf("id: %d\n", id);
		System.out.printf("age: %d\n", age);
		System.out.printf("height: %d\n", height);
		System.out.printf("weight: %.1f\n", weight);
		System.out.printf("gender: %s\n", gender);
		humanFio.display();
	}

	public static void main(String[] args)
	{
		System.out.printf("--------Human class--------\n");
		Fio myFio = new Fio();//mentioned
		String familiya = new String("Sidenko");//mentioned
		String imya = new String("Matvey");//mentioned
		String otchestvo = new String("Evgenievich");//mentioned
		myFio.init(familiya, imya, otchestvo);//mentioned
	
		System.out.printf("------init method-------\n");
		Human myHuman = new Human();
		if(myHuman.init(1984, 45, 193, 90.87, 'M', myFio))
			System.out.printf("error\n");
		else
			myHuman.display();

		System.out.printf("\n------read method------\n");
		if (myHuman.read())
			System.out.printf("error\n");
		else
			myHuman.display();

		System.out.printf("\n------set methods-------\n");
		if (myHuman.setId(1999) || myHuman.setAge(27) || myHuman.setHeight(180) ||
			myHuman.setWeight(80.890) || myHuman.setGender('M'))
			System.out.printf("error\n");
		else
			myHuman.display();
	}
}