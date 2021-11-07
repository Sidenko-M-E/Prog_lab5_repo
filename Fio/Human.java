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
		//сравнение входной строки и допустимых символов
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
		//создаём объект класса Human для проверки формата входных данных
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
		//создаём объект класса Human для проверки формата входных данных
		Human check = new Human();

		//проверка на формат входных данных
		System.out.printf("Enter id:\n");
		Scanner scanner = new Scanner(System.in);
		if (!scanner.hasNextInt())
			return (true);
		else 
		{
			//попытка записи в поле объекта
			if (check.setId(scanner.nextInt()))
				return (true);
			else
			{
				//проверка на формат входных данных
				System.out.printf("Enter age:\n");
				if (!scanner.hasNextInt())
					return (true);
				else 
				{
					//попытка записи в поле объекта
					if (check.setAge(scanner.nextInt()))
						return (true);
					else
					{
						//проверка на формат входных данных
						System.out.printf("Enter height:\n");
						if (!scanner.hasNextInt())
							return (true);
						else 
						{
							//попытка записи в поле объекта
							if (check.setHeight(scanner.nextInt()))
								return (true);
							else
							{
								//проверка на формат входных данных
								System.out.printf("Enter weight:\n");
								if (!scanner.hasNextDouble())
									return (true);
								else 
								{
									//попытка записи в поле объекта
									if (check.setWeight(scanner.nextDouble()))
										return (true);
									else
									{		 
										//проверка на формат входных данных
										System.out.printf("Enter gender:\n");
										if (!scanner.hasNextChar())
											return (true);
										else 
										{
											if(check.setGender(scanner.nextChar()))
												return (true);
											else
											{
												if (this.humanFio.read())
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
		System.out.printf("--------Fio class--------\n");
		String familiya = new String("Sidenko");
		String imya = new String("Matvey");
		String otchestvo = new String("Evgenievich");
	
	
		System.out.printf("------Init method-------\n");
		Fio myFio = new Fio();
		Human myHuman = new Human();

		myFio.init(familiya, imya, otchestvo);
		if(myHuman.init(1984, 45, 193, 90.87, 'M', myFio))
			System.out.printf("error\n");
		else
			myHuman.display();
	}
}