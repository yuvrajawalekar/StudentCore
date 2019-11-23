package custom_comparator;

import java.util.Comparator;

import com.app.core.Student;

public class StuMarksComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return ((Integer)o1.getMarks()).compareTo(o2.getMarks());
	}

}
