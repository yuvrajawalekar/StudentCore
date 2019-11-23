//Create day9_lab eclipse project.
//Copy Student,StudentHandlingException & Validation rules packaged classes under <src> in eclipse.
//Write a Tester for the following 
//1. Add populateStudents method in CollectionUtils class , to return populated AL<Student> ---test data.
//
//2. Create a TestStudents class , as per template (already discussed)
//
//Options
//1. New Student admission
//2. Accept course name from user
//Display names of all students for a specific course.
//3. Update student marks
//I/P --prn & new marks
//O/P success message or err message via custom exception
//4. Display prn & names  of all students born after specific date & enrolled in a specific course.
//I/P date & course name
//O/P prn & names.
//5. Cancel Admission
//I/P --prn 
//O/P success message or err message via custom exception
//
//6. Sort students as per prns , using natural ordering & display the same.
//
//7. Sort students as per dob & marks  , using custom ordering & display the same.
//
//8. Display name of a topper for a specific course(assume 1 topper only)
//I/P course name.
//O/P name of a topper.
//Hint(Use max() of Collections)
//

package tester;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.app.core.Student;

import custom_comparator.StuDobMarksComaparator;
import custom_comparator.StuMarksComparator;

import static utils.ValidationUtils.*;
import static utils.CollectionUtils.populateStudents;

public class Tester {

	public static void main(String[] args) {

		// Menu
		try (Scanner sc = new Scanner(System.in);) {
			boolean exit = false;
			ArrayList<Student> s_al = new ArrayList<Student>();
			s_al.addAll(populateStudents());
			while (!exit) {
				try {
					System.out.println("Menu");
					System.out.println("1. Register A new Student");
					System.out.println("2. Display All Student");
					System.out.println("3. Display names of all students for a specific course");
					System.out.println("4. Update student marks via PRN");
					System.out.println(
							"5. Display PRN & names  of all students born after specific date & enrolled in a specific course.");
					System.out.println("6. Cancel Admission");
					System.out.println("7. Sort students as per PRNs , using natural ordering & display the same.");
					System.out.println(
							"8. Sort students as per dob & marks  , using custom ordering & display the same.");
					System.out.println("9. Display name of a topper for a specific course(assume 1 topper only)");
					System.out.println("0. Exit");
					System.out.print("Enter Choice:");

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter PRN, name, email, course, marks, dob");
						Student temp = new Student(checkPRN(sc.next(), s_al),
								checkName(sc.next()), checkEmail(sc.next()),
								checkCourse(sc.next()), sc.nextInt(),
								checkDate(sc.next()));
						s_al.add(temp);
						System.out.println("New Student Registered");
						break;
					case 2:
						System.out.println("Displaying All Student");
						for (Student s : s_al)
							System.out.println(s);
						break;
					case 3:
						System.out.println("Enter course name");
						// Display names of all students for a specific course.
						String course = sc.next();
						for (Student s : s_al)
							if (s.getCourse().equalsIgnoreCase(course))
								System.out.println(s);
						break;
					case 4: {
						System.out.println("Enter PRN to Update student marks");
						String PRN = sc.next();
						System.out.println("Enter New Marks");
						int newmarks = sc.nextInt();
						System.out.println(updateMarks(PRN, newmarks, s_al));
					}
						break;
					case 5: {
						// Display PRN & names of all students born after specific date & enrolled in a
						// specific course"
						// I/P date & course name
						System.out.println("Enter Date:");
						Date d = checkDate(sc.next());
						System.out.println("Enter Course:");
						String c = sc.next();
						// O/P PRN & names
						for (Student s : s_al)
							if (s.getDOB().compareTo(d) > 0 && s.getCourse().equals(c))
								System.out.println(s);
					}
						break;
					case 6: {
						System.out.println("Enter PRN to Cancel Admission");
						String PRN = sc.next();
						System.out.println(removeStudent(PRN, s_al));
					}
						break;
					case 7:// Sort students as per PRNs , using natural ordering & display the same
						System.out.println("Sorted Students as per PRNs");
						Collections.sort(s_al);// Calling Natural Ordering
						for (Student s : s_al)
							System.out.println(s);
						break;
					case 8:// Sort students as per DOB & marks , using custom ordering & display the same
						System.out.println("Sorted Students as per Dob & Marks");
						// Collections.sort(l1,instance of the class that imple Comparator<T>
						Collections.sort(s_al, new StuDobMarksComaparator());// Calling Custom Ordering
						Collections.sort(s_al, new StuMarksComparator());// Calling Custom Ordering
						for (Student s : s_al)
							System.out.println(s);
						break;
					case 9:
						//Display name of a topper for a specific course(assume 1 topper only
						// Hint(Can directly use max() of Collections)
						System.out.println(Collections.max(s_al,new StuMarksComparator()));
						break;
					case 0:
						exit = true;
						System.out.println("Bye!");
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
