import java.util.*;
import java.lang.Math.*;

public class Faculty{
	//Attributes
	private String facultyName;
	private int quantityOfStudents;
	private int quantityOfBachelors;
	private int quantityOfMasters;
	private int quantityOfTeachers; 
	private int quantityOfCandidates;
	private int quantityOfDoctors;
	private int quantityOfDisciplines;


	//Set methods
	public boolean setFacultyName(String bufString)
	{
		if (bufString.isEmpty()) {
			return (true);
		}

		String invalidSymbStr = "!@#$%^&*()_+1234567890-=\"�;:?*,./'][{}<>~` ";
		char[] invalidSymbols = invalidSymbStr.toCharArray();
		for (char symb : invalidSymbols) 
		{
			if(bufString.indexOf(symb) != (-1))
				return (true);
		}

		facultyName = bufString;
		return (false);
	}

	public boolean setQuantityOfStudents(int buf)
	{
		if (buf < 0 || buf > 1000)
			return (true);
		else
		{
			quantityOfStudents = buf;
			return (false);
		}
	}

	public boolean setQuantityOfBachelors(int buf)
	{
		if (buf < 0 || buf > 1000)
		return (true);
		else
		{
			quantityOfBachelors = buf;
			return (false);
		}
	}

	public boolean setQuantityOfMasters(int buf)
	{
		if (buf < 0 || buf > 1000)
		return (true);
		else
		{
			quantityOfMasters = buf;
			return (false);
		}
	}

	public boolean setQuantityOfTeachers(int buf)
	{
		if (buf < 0 || buf > 100)
		return (true);
		else
		{
			quantityOfTeachers = buf;
			return (false);
		}
	}

	public boolean setQuantityOfCandidates(int buf)
	{
		if (buf < 0 || buf > 100)
		return (true);
		else
		{
			quantityOfCandidates = buf;
			return (false);
		}
	}

	public boolean setQuantityOfDoctors(int buf)
	{
		if (buf < 0 || buf > 100)
		return (true);
		else
		{
			quantityOfDoctors = buf;
			return (false);
		}
	}

	public boolean setQuantityOfDisciplines(int buf)
	{
		if (buf < 0 || buf > 100)
		return (true);
		else
		{
			quantityOfDisciplines = buf;
			return (false);
		}
	}

	public boolean setStudentsInfo(int allQuantity, int bachelorsQuantity, int mastersQuantity)
	{
		if (allQuantity < 0 || allQuantity > 1000 || bachelorsQuantity < 0 || bachelorsQuantity > 1000 || mastersQuantity < 0 || mastersQuantity > 1000)
			return (true);
		else
		{
			quantityOfStudents = allQuantity;
			quantityOfBachelors = bachelorsQuantity;
			quantityOfMasters = mastersQuantity;
			return (false);
		}
	}	

	public boolean setTeachersInfo(int allQuantity, int candidatesQuantity, int doctorsQuantity)
	{
		if (allQuantity < 0 || allQuantity > 100 || candidatesQuantity < 0 || candidatesQuantity > 100 || doctorsQuantity < 0 || doctorsQuantity > 100)
			return (true);
		else
		{
			quantityOfTeachers = allQuantity;
			quantityOfCandidates = candidatesQuantity;
			quantityOfDoctors = doctorsQuantity;
			return (false);
		}
	}
   

	//Get methods
	public String getFacultyName()
	{
		return facultyName;
	}

	public int getQuantityOfStudents()
	{
		return quantityOfStudents;
	}

	public int getQuantityOfBachelors()
	{
		return quantityOfBachelors;
	}

	public int getQuantityOfMasters()
	{
		return quantityOfMasters;
	}

	public int getQuantityOfTeachers()
	{
		return quantityOfTeachers;
	}

	public int getQuantityOfCandidates()
	{
		return quantityOfCandidates;
	}

	public int getQuantityOfDoctors()
	{
		return quantityOfDoctors;
	}

	public int getQuantityOfDisciplines()
	{
		return quantityOfDisciplines;
	}	

	//Processing methods
	public double getProcentOfMasters()
	{
		return (((double) quantityOfMasters) / ((double) quantityOfStudents) * 100);
	}

	public double getProcentOfDoctors()
	{
		return (((double) quantityOfDoctors) / ((double) quantityOfTeachers) * 100);
	}

	public double getStudToTeachRatio()
	{
		return ((double) quantityOfStudents) / ((double) quantityOfTeachers);
	}

   public boolean Init(String bufFacultyName, int studentsQuantity, int bachelorsQuantity, int mastersQuantity, int teachersQuantity, int candidatesQuantity, int doctorsQuanity, int discpilinesQuantity)
   {
		//������ ������ ������ faculty ��� �������� ������� ������� ������
		Faculty check = new Faculty();
	
		//�������� �� ������ ����� 
		if (check.setFacultyName(bufFacultyName) || check.setQuantityOfStudents(studentsQuantity) ||
			check.setQuantityOfBachelors(bachelorsQuantity) || check.setQuantityOfMasters(mastersQuantity) ||
			check.setQuantityOfTeachers(teachersQuantity) || check.setQuantityOfCandidates(candidatesQuantity) ||
			check.setQuantityOfDoctors(doctorsQuanity) || check.setQuantityOfDisciplines(discpilinesQuantity))
			return (true);
		else
		{
			setFacultyName(bufFacultyName);
			setQuantityOfStudents(studentsQuantity);
			setQuantityOfBachelors(bachelorsQuantity);
			setQuantityOfMasters(mastersQuantity);
			setQuantityOfTeachers(teachersQuantity);
			setQuantityOfCandidates(candidatesQuantity);
			setQuantityOfDoctors(doctorsQuanity);
			setQuantityOfDisciplines(discpilinesQuantity);
			return (false);
		}
   }

   public boolean read()
   {
		System.out.printf("I want to break free...");
		return (false);
   }

   public void display()
   {
	System.out.printf("faculty name: %s\n", facultyName);
	System.out.printf("quantity of students: %d\n", quantityOfStudents);
	System.out.printf("quantity of bachelors: %d\n", quantityOfBachelors);
	System.out.printf("quantity of masters: %d\n\n", quantityOfMasters);

	System.out.printf("quantity of teachers: %d\n", quantityOfTeachers);
	System.out.printf("quantity of candidates: %d\n", quantityOfCandidates);
	System.out.printf("quantity of doctors: %d\n\n", quantityOfDoctors);

	System.out.printf("quantity of disciplines: %d\n", quantityOfDisciplines);
   }

   public static void main(String[] args)
   {
		//�������� ������ ������� �� ������� ������
		System.out.printf("-------Init method-------\n");
		Faculty my_faculty = new Faculty();
		//if (my_faculty.Init("FoIT", 180, 145, 35, 40, 20, 5, 70))
		//	System.out.printf("error\n");
		//else
		//	my_faculty.display();

		//���� ����� ������� � ������� �������
		System.out.printf("\n------Shortcut-Set methods-------\n");
		my_faculty.setStudentsInfo(300, 270, 30);
		my_faculty.setTeachersInfo(40, 33, 7);
		if (my_faculty.setFacultyName("Fo****IT"))
			System.out.printf("Error\n");
		
		my_faculty.display();
		my_faculty.setFacultyName("FoHS");
		my_faculty.display();

		//����� ������ ����������� ������� ������ � �������
		//System.out.printf("\n----processing by functions----\n");
		//System.out.printf("Procent of masters on faculty: %.2f\n", my_faculty.getProcentOfMasters());
		//System.out.printf("Procent of doctors on faculty: %.2f\n", my_faculty.getProcentOfDoctors());
		//System.out.printf("Students to teachers quantity: %.2f\n", my_faculty.getStudToTeachRatio());
   }
}