package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	public static List<Student> ls = new ArrayList<>();
	
	public int add(Student st) {
		if (findByID(st.getId()) != null) {
			update(st);
		}
		ls.add(st);
		return 1;
	}
	
	public int update(Student st) {
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i).getId().equals(st.getId())) {
				ls.set(i, st);
				System.out.println("--------------" + ls.get(i).getId());
				System.out.println("++++++++" + st);
				System.out.println("---------" + st.getId());
				return i;
			}
		}
		return 0;
	}
	
	public Student findByID(String id) {
		for (Student st : ls) {
			if (st.getId().equals(id)) {
				return st;
			}
		}
		return null;
	}
	
	public List<Student> getAll(){
		return ls;
	}
}
