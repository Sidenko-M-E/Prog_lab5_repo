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
		facultyName = bufString;
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
			QuantityOfDisciplines = buf;
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
			qiantityOfTeachers = allQuantity;
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

   public boolean Init(String buf_FacultyName, int stud_quan, int bach_quan, int mast_quan, int teac_quan, int cand_quan, int doct_quan, int disc_quan){}
   public boolean Read(){}
   public void Display(){}
}