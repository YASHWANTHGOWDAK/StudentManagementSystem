package com.example;

public class Employee {
	String id;
	String name;
	static int count=101;
	
	
	Employee(String name){
		this.id="Jsp"+count;
		this.name=name;
		count++;
	}
	
	public static void main(String[] args) {
		
		Employee e1=new Employee("Yash");
		System.out.println("Emp Id of"+e1.name+" is "+e1.id);
		
		Employee e2=new Employee("Yash");
		System.out.println("Emp Id of"+e2.name+" is "+e2.id);
	}

}
