package com.task3;

import java.util.Scanner;

interface Taxable {
	double SALES_TAX = 0.07;   // 7%
	double INCOME_TAX = 0.11;  // 10.5%
	double calcTax(double amount);
}

class Employee implements Taxable {
	private long empId;
	private String ename;
	private double salary;

	public Employee(long empId, String ename, double salary) {
		this.empId = empId;
		this.ename = ename;
		this.salary = salary;
	}

	@Override
	public double calcTax(double amount) {
		double tax = amount * INCOME_TAX;	
		return tax;
	}
}

class Product implements Taxable {
	private long prodId;
	private double qty;
	private double price;
	private double pamt;

	public Product(long prodId, double qty, double price) {
		this.prodId = prodId;
		this.qty = qty;
		this.price = price;
	}

	@Override
	public double calcTax(double amount) {
		double tax = amount * SALES_TAX;	
		return tax;
	}
}

public class TaxFiling {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Tax Management");
		System.out.println("--------------");
		
		System.out.println("\nEnter Employee ID: ");
	    long empId = s.nextLong();
	    s.nextLine(); 
	    System.out.println("Name: ");
	    String ename = s.nextLine();
		System.out.println("Salary: ");
	    double salary = s.nextDouble();
		Employee emp = new Employee(empId, ename, salary);
	    System.out.println("\nIncome tax payable is " + emp.calcTax(salary));
	    
	    System.out.println("\nEnter Product ID: ");
	    long prodId = s.nextLong();
	    s.nextLine(); 
	    System.out.println("Qty: ");
	    double qty = s.nextDouble();
		System.out.println("Price: ");
	    double price = s.nextDouble();
		Product prod = new Product(prodId, qty, price);
		double pamt = qty * price;
	    System.out.format("\nSales tax payable is %.2f", prod.calcTax(pamt));
	}
}
