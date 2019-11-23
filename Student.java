
package com.app.core;

import java.util.Date;

public class Student implements Comparable<Student> {
	private String prn, name, email;
	private CourseType course;
	private int marks;
	private Date dob;

	public Student(String prn) {
		super();
		this.prn = prn;
	}
	public Student(String prn, String name, String email, CourseType course, int marks,Date dob) {
		super();
		this.prn = prn;
		this.name = name;
		this.email = email;
		this.course = course;
		this.marks = marks;
		this.dob=dob;
	}

	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", email=" + email + ", course=" + course + ", marks=" + marks
				+ ", dob=" + dob + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Student s=(Student)obj;
	//System.out.println("Checking equality");
	if(obj instanceof Student) {
		return (this.prn.equals(s.prn));
	}	
	else {
		return false;
	}	
	
    }
	
	public boolean setMarks(int newmarks) {
		this.marks=newmarks;
		return true;
	}
	public Date getDOB() {
		return this.dob;
	}
	public int getMarks() {
		return this.marks;
	}
	public String getCourse() {
		return this.course.toString();
	}
	// implementing N.O using compareTo
	@Override
	public int compareTo(Student Other) {
		// <0 , =0 , > 0
		System.out.println("N.O. compareTo");
		return this.prn.compareTo(Other.prn);
	}
	
	
	
}
	
