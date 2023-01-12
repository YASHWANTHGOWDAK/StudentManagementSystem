package com.jspider;

import java.util.Scanner;


import com.customexception.InavlidChoiceException;

public class Solution {

	// menu Driven Program
	// UPCASTING
	// Switch case
	// System.in
	// infinteLoop ->while(true) {}

public static void main(String[] args) {



		Scanner scan=new Scanner(System.in);

		StudentManagementSystem s=new StudentManagementSystemImp();

		while(true) 
		  {
			System.out.println("1.AddStudent\n2.displayStudent\n3.displayAllStudent\n4.removeStudent");
			System.out.println("5.removeAllStudent\n6.updateStudent\n7.countStudent\n8.sortStudent");
			System.out.println("9.EXIT");
			int choice=scan.nextInt();


			switch(choice) {

			case 1:
				s.addStudent();


				break;
			case 2:
				s.displayStudent();

				break;

			case 3:
				s.displayAllStudent();

				break;

			case 4:
				s.removeStudent();

				break;

			case 5:
				s.removeAllStudent();

				break;

			case 6:

				s.updateStudent();

				break;

			case 7:
				s.countStudent();

				break;
			case 8:
				s.sortStudent();

				break;
			case 9:
				System.out.println("Thank you");
				System.exit(0);
				scan.close();
				break;
				
			default:
				try {
					throw new InavlidChoiceException("Invalid Choice,Kindely enter the correct choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());

				}
				break;

			}
			System.out.println("**********************");
		}

	}
}
