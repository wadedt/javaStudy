package oop;

public class Emp {
	private String name;
	private int age;
	private char gender;
	private double salary;
	public Emp(String name, int age, char gender, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void printInfo(){
		System.out.println("-------------------");
		System.out.println("������"+name);
		System.out.println("���䣺"+age);
		System.out.println("�Ա�"+gender);
		System.out.println("нˮ��"+salary);
	}
}
