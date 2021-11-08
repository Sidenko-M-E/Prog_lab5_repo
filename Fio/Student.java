import java.util.*;

public class Student
{
	//Attributes
	private int course;  
	private	String eduProg;
	private String group;
	private String facultyName;
	public Human studentHuman = new Human();  

	//Methods
	public boolean setCourse(int buf)
	{
		if (buf < 0 || buf > 6)
			return (true);
		else
		{
			course = buf;
			return (false);
		}
	}

	public boolean setEduProg(String bufString)
	{
		if (bufString.isEmpty()) 
			return (true);
		
		String invalidSymbStr = "!@#$%^&*()_+1234567890-=\"�;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols) 
		{
			if(bufString.indexOf(symb) != (-1))
				return (true);
		}

		eduProg = eduProg.copyValueOf(bufString.toCharArray());
		return (false);
	}

	public boolean setGroup(String bufString)
	{
		if (bufString.isEmpty()) 
			return (true);
		
		String invalidSymbStr = "!@#$%^&*()_+=\"�;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols) 
		{
			if(bufString.indexOf(symb) != (-1))
				return (true);
		}

		group = group.copyValueOf(bufString.toCharArray());
		return (false);
	}

	public boolean setFacultyName(String bufString)
	{
		if (bufString.isEmpty()) 
			return (true);
		
		String invalidSymbStr = "!@#$%^&*()_+1234567890-=\"�;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols) 
		{
			if(bufString.indexOf(symb) != (-1))
				return (true);
		}

		facultyName = facultyName.copyValueOf(bufString.toCharArray());
		return (false);
	}

	public int getCourse()
	{return(course);}

	public String getEduProg()
	{
		String outputString = String.copyValueOf(eduProg.toCharArray());
		return (outputString);
	}

	public String getGroup()
	{
		String outputString = String.copyValueOf(group.toCharArray());
		return (outputString);
	}

	public String getFacultyName()
	{
		String outputString = String.copyValueOf(facultyName.toCharArray());
		return (outputString);
	}


	public boolean init(int bufCourse, String bufEduProg, String bufGroup, String bufFacultyName, Human bufHuman)
	{
		//������ ������ ������ Student ��� �������� ������� ������� ������
		Student check = new Student();

		if (check.setCourse(bufCourse) || check.setEduProg(bufEduProg) || check.setGroup(bufGroup) ||
			check.setFacultyName(bufFacultyName))
			return (true);
		else
		{
			this.setCourse(bufCourse);
			this.setEduProg(bufEduProg);
			this.setGroup(bufGroup);
			this.setFacultyName(bufFacultyName);
			this.studentHuman.init(bufHuman.getId(), bufHuman.getAge(), 
			bufHuman.getHeight(), bufHuman.getWeight(),bufHuman.getGender(), bufHuman.humanFio);
			return (false);
		}
	}

	public boolean read()
	{
		//������ ������ ������ student ��� �������� ������� ������� ������
		Student check = new Student();

		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter education programm:\n");
		if (!scanner.hasNextLine())
			return (true);
		else
		{
			if (check.setEduProg(scanner.nextLine()))
			{
				System.out.printf("1111");
					return (true);
			}		
			else 
			{
				System.out.printf("Enter group:\n");
				if (!scanner.hasNextLine())
					return (true);
				else
				{
					if (check.setGroup(scanner.nextLine()))
						return (true);
					else 
					{
						System.out.printf("Enter faculty name:\n");
						if (!scanner.hasNextLine())
							return (true);
						else
						{
							if (check.setFacultyName(scanner.nextLine()))
								return (true);
							else 
							{
								//�������� �� ������ ������� ������
								System.out.printf("Enter course:\n");
								if (!scanner.hasNextInt())
									return (true);
								else 
								{
									//������� ������ � ���� �������
									if (check.setCourse(scanner.nextInt()))
										return (true);
									else
									{
										if (check.studentHuman.read())
											return(true);
										else
										{
											this.init(check.getCourse(), check.getEduProg(), check.getGroup(), 
											check.getFacultyName(), check.studentHuman);
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

	void display()
	{
		System.out.printf("course: %d\n", course);
		System.out.printf("direction of preparation: %s\n", eduProg);
		System.out.printf("group: %s\n", group);
		System.out.printf("faculty name: %s\n", facultyName);
		studentHuman.display();
	}


	public static void main(String[] args)
	{
		Fio myFio = new Fio();//mentioned
		myFio.init("Sidenko", "Matvey", "Evgenievich");//mentioned
		Human myHuman = new Human();//mentioned
		myHuman.init(1984, 45, 193, 90.87, 'M', myFio);//mentioned

		System.out.printf("\n--------Student class--------\n");
		System.out.printf("-------init method-------\n");
		Student myStudent = new Student();
		if (myStudent.init(2, "Bachelor", "PI-03", "FoIT", myHuman))
			System.out.printf("error\n");
		else 
			myStudent.display();

		System.out.printf("\n------read method------\n");
		if (myStudent.read())
			System.out.printf("error\n");
		else
			myStudent.display();

		System.out.printf("\n------Set methods-------\n");
		if (myStudent.setCourse(4) || myStudent.setEduProg("Master") || 
			myStudent.setGroup("CS-91") ||
			myStudent.setFacultyName("FoIT"))
			System.out.printf("error\n");
		else
			myStudent.display();
	}
}