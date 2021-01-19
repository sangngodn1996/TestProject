package com.example.demo.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MajorDao {

	public static List<Major> ls = new ArrayList<>();
	public List<Major> getAll(){
		ls.clear();
		ls.add(new Major(1,"WEB"));
		ls.add(new Major(2,"PHP"));
		ls.add(new Major(3,"MOBIE"));
		return ls;
	}
	
	public Major findByMajor(int id) {
		for (Major mj:ls) {
			if(mj.getId()==id) {
				return mj;
			}
		}
		return null;
	}
}
