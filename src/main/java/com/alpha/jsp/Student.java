package com.alpha.jsp;

public class Student {

	private int id;
	private String name;
	private int age;
	private long phone;
	private String address;

	public Student(int id, String name, int age, long phone, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address
				+ "]";
	}

}
