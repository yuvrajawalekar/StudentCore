package custom_comparator;

import java.util.Comparator;

import com.app.core.Student;

public class StuDobMarksComaparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// <0 , =0 , > 0
		System.out.println("in compare : DOB & Marks");
		int ret=o1.getDOB().compareTo(o2.getDOB());
		if(ret != 0)
			return ret;
		return ((Integer)o1.getMarks()).compareTo(o2.getMarks());
	}

}
