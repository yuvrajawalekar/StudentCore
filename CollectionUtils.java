package utils;

import java.text.ParseException;
import java.util.ArrayList;
import com.app.core.Student;

import cust_excs.StudentHandlingException;

import static utils.ValidationUtils.*;

public class CollectionUtils 
{
	public static ArrayList<Student> populateStudents() throws IllegalArgumentException, StudentHandlingException, ParseException 
	{
		ArrayList<Student> stu=new ArrayList<>();
		stu.add(new Student("111", checkName("Abhay"), checkEmail("Abhay@gmail.com"), checkCourse("DAC"),99, checkDate("20/11/2012")));
		stu.add(new Student("222", checkName("Raghav"), checkEmail("Raghav@gmail.com"), checkCourse("DAI"),99, checkDate("20/9/1996")));
		stu.add(new Student("333", checkName("Rohan"), checkEmail("Rohan@gmail.com"), checkCourse("DBDA"),99, checkDate("20/11/1999")));
		
			return stu;
	}
}
