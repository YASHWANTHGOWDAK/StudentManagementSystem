package com.jspider;

/**
 *  @author YASHWANTH K
 *  @since 2022
 *  
 *  we are Giving implementation to 8 abstract methods to SystemManagementSystem
 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InavlidChoiceException;
import com.customexception.StudentNotFoundException;
import com.sortinglogic.SortStudentByAge;
import com.sortinglogic.SortStudentById;
import com.sortinglogic.SortStudentByMarks;
import com.sortinglogic.SortStudentByName;

public class StudentManagementSystemImp implements StudentManagementSystem{





	Map<String, Student> map=new LinkedHashMap<String,Student>();

	Scanner scan=new Scanner(System.in);





	@Override
	public void addStudent() {
		
		/**
		 * Adding Students records
		 */

		// Accept name,age& marks
		// Student object

		System.out.println("Enter Name:");
		String name=scan.next();
		System.out.println("Enter the age:");
		int age=scan.nextInt();
		System.out.println("Enter the Marks:");
		int marks=scan.nextInt();

		Student s= new Student(age,name,marks) ;
		map.put(s.getid(), s);
		System.out.println(" Student record Inserted Sucessfully ");
		System.out.println(" Your Student id is : "+s.getid());


	}

	@Override
	public void displayStudent() {


		System.out.println(" Enter Student Id : ");
		String id=scan.next();
		id=id.toUpperCase();

		if(map.containsKey(id)) {
			Student obj=map.get(id);
			System.out.println("*********************");
			System.out.print(" Id :"+obj.getid());
			System.out.print(" Name :"+obj.getName());
			System.out.print(" Age :"+obj.getAge());
			System.out.println(" Marks :"+obj.getMarks());
		}

		else {
			try {
				throw new StudentNotFoundException("Student Record Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}

		}
	}

	@Override
	public void displayAllStudent() {
		// Map-> Set of keys
		//for -> get()
		/**
		 * converting map to KeySet and traverse using for-each loop
		 * 
		 */

		Set<String> keys=map.keySet();// "JS101" "JSP102"
		System.out.println(" Student Record are as follow ");
		System.out.println("-------------------------------");
		if(map.size()!=0) {

			for(String key:keys) {
				System.out.println(key);// printing reference variable

			}
		}
		else {
			try {
				throw new StudentNotFoundException(" Student records Avaliable to Display ");

			}
			catch(Exception e) {

				System.out.println(e.getMessage());

			}

		}


	}

	@Override
	public void removeStudent() {

		// Accept the Id -> String
		//upperCase
		// containsKey()
		//remove()
		//else -> SNFE ->handle

		System.out.println("Enter Student Id : ");
		String id=scan.next();
		id=id.toUpperCase();
		if(map.containsKey(id)) {
			map.remove(id);
			System.out.println("Student Record Deleted Successfully");

		}
		else {
			try {
				throw new StudentNotFoundException("Student Record not found");

			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}

		}

	}

	@Override
	public void removeAllStudent() {


		System.out.println(map.size()+" Student Records are present");
		map.clear();
		System.out.println("All Students  Records Deleted Sucessfully ");





	}

	@Override
	public void updateStudent() {
		// Accept Id & upperCase , containsKey,get the Student object
		//switch case 1: update name,age,marks
		// invoke exception

		System.out.println("Enter the Student Id :");
		String id= scan.next().toUpperCase();

		if(map.containsKey(id)) 
		{
			Student student=map.get(id);
			System.out.println("1.Update Name\n2.Update Age\n3.Update Marks");
			System.out.println("Enter the Choice");
			int choice=scan.nextInt();

			switch(choice) {

			case 1:
				System.out.println("Enter the name");
				student.setName(scan.next());// String name=scan.next();//student.setName(name);

				break;

			case 2:
				System.out.println("Enter the Age");
				student.setAge(scan.nextInt());
				break;

			case 3:
				System.out.println("Enter the Marks");
				student.setMarks(scan.nextInt());
				break;

			default:
				try {
					throw new InavlidChoiceException("Invalid choice");

				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}

			}



		}
		else {

		}


	}

	@Override
	public void countStudent() {

		System.out.println("Total number of Student Record :"+map.size());


	}

	@Override
	public void sortStudent() {
		/**
		 * converting map to KeySet()
		 * UPcasting list to ArrayList and Storing Students object
		 *
		 * Traverse using for-each loop and get the values of Student object and store it in ArrayList
		 *  
		 * 
		 */

		//Convert Map into Set -> KeySet()
		//List & ArrayList -> Student
		// for-each, get the values (Student objects) and store it in AL

		Set<String> keys = map.keySet();

		List<Student> list=new ArrayList<Student>();

		for(String key:keys) {
			list.add(map.get(key)); //adding Student object from map to list

			/**
			 * Adding Student object from map to ArrayList
			 */
		}

		System.out.println("1.SortStudentById\n2.SortStudentByName\n3.SortStudentByAge");
		System.out.println("4.SortStudentByMarks");
		System.out.println("Enter the choice");
		int choice=scan.nextInt();

		switch(choice) {

		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
			break;
		case 2:
			Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 3:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;
		
		default :
			try {
				throw new InavlidChoiceException("Invalid choice");

			}
			catch(Exception e) {
				System.out.println(e.getMessage());

			}
		}
	}

	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}

}
