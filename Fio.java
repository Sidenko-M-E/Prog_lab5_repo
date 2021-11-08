import java.util.*;

public class Fio
{
	//Attributes
	private String surname;
	private String name;
	private String patronymic;

	//Methods
	public boolean setSurname(String bufString)
	{
		if (bufString.isEmpty()) 
			return (true);
		
		String invalidSymbStr = "!@#$%^&*()_+1234567890-=\"№;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols) 
		{
			if(bufString.indexOf(symb) != (-1))
				return (true);
		}

		surname = surname.copyValueOf(bufString.toCharArray());
		return (false);
	}

	public boolean setName(String bufString)
	{
		if (bufString.isEmpty())
			return (true);
		
		String invalidSymbStr = "!@#$%^&*()_+1234567890-=\"№;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols)
		{
			if (bufString.indexOf(symb) != (-1))
				return (true);
		}

		name = name.copyValueOf(bufString.toCharArray());
		return (false);
	}

	public boolean setPatronymic(String bufString)
	{
		if (bufString.isEmpty())
			return (true);
			
		String invalidSymbStr = "!@#$%^&*()_+1234567890-=\"№;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols)
		{
			if (bufString.indexOf(symb) != (-1))
			return (true);
		}

		patronymic = patronymic.copyValueOf(bufString.toCharArray());
		return (false);
	}


	public String getSurname()
	{
		String outputString = String.copyValueOf(surname.toCharArray());
		return (outputString);
	}

	public String getName()
	{
		String outputString = String.copyValueOf(name.toCharArray());
		return (outputString);
	}

	public String getPatronymic()
	{
		String outputString = String.copyValueOf(patronymic.toCharArray());
		return (outputString);
	}



	public boolean init(String bufSurname, String bufName, String bufPatronymic)
	{
		//создаём объект класса Fio для проверки формата входных данных
		Fio check = new Fio();

		//проверка на формат ввода
		if (check.setSurname(bufSurname) || check.setName(bufName) || check.setPatronymic(bufPatronymic))
			return (true);
		else
		{
			this.setSurname(bufSurname);
			this.setName(bufName);
			this.setPatronymic(bufPatronymic);
			return (false);
		}
	}

	public boolean read()
	{
		//создаём объект класса Fio для проверки формата входных данных
		Fio check = new Fio();

		//создаём буферную строку для проверки формата входных данных
		String bufString;

		System.out.printf("Enter surname:\n");
		Scanner scanner = new Scanner(System.in);
		if (!scanner.hasNextLine())
			return (true);
		else
		{
			bufString = scanner.nextLine();
			if (check.setSurname(bufString))
				return (true);
			else 
			{
				System.out.printf("Enter name:\n");
				if (!scanner.hasNextLine())
					return (true);
				else
				{
					bufString = scanner.nextLine();
					if (check.setName(bufString))
						return (true);
					else 
					{
						System.out.printf("Enter patronymic:\n");
						if (!scanner.hasNextLine())
							return (true);
						else
						{
							bufString = scanner.nextLine();
							if (check.setPatronymic(bufString))
								return (true);
							else 
							{
								this.setSurname(check.getSurname());
								this.setName(check.getName());
								this.setPatronymic(check.getPatronymic());
								return (false);
							}
						}
					}
				}
			}
		}
	}

	public void display()
	{
		System.out.printf("FIO: %s %s %s\n", surname, name, patronymic);
	}

	public static void main(String[] args)
	{
		System.out.printf("--------Fio class--------\n");
		String familiya = new String("Sidenko");
		String imya = new String("Matvey");
		String otchestvo = new String("Evgenievich");


		System.out.printf("------Init method-------\n");
		Fio myFio = new Fio();
	
		if(myFio.init(familiya, imya, otchestvo))
			System.out.printf("error\n");
		else
			myFio.display();


		System.out.printf("\n---Read method---\n");
		if (!myFio.read())
			myFio.display();
		else
			System.out.printf("error\n");


		System.out.printf("\n------Set methods-------\n");
		if ((myFio.setSurname("Ivanov"))||(myFio.setName("Ivan"))||(myFio.setPatronymic("Ivanovich")))
			System.out.printf("error\n");
		else
			myFio.display();
	}
}