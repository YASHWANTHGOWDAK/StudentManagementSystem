package com.sortinglogic;

import java.util.Comparator;

import com.jspider.Student;

public class SortStudentById implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getid().compareTo(s2.getid());
	}
	

}
