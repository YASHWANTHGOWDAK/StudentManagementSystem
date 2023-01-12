package com.sortinglogic;

import java.util.Comparator;

import com.jspider.Student;

public class SortStudentByName implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getName().compareTo(s2.getName());
	}

}
