package com.example.demo.models;

public class Student {

	private String id;
	private String name;
	private float mark;
	private Major major;
	
	public Student() {
		super();
	}

	public Student(String id, String name, float mark, Major major) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + ", major=" + major + "]";
	}
	
	
	
}
