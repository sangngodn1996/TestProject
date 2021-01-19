package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Major;
import com.example.demo.models.MajorDao;
import com.example.demo.models.Student;
import com.example.demo.models.StudentDao;

@Controller
public class StudentController {

	MajorDao mdao = new MajorDao();
	StudentDao sdao = new StudentDao();
	@RequestMapping("/")
	public String addOrUpdate(ModelMap model) {
		Student st = new Student();
		model.addAttribute("STUDENT", st);
		model.addAttribute("ACTION", "saveOrUpdate");
		return"student-form";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("STUDENT")Student st) {
		
			Major m = mdao.findByMajor(st.getMajor().getId());
			st.setMajor(m);
			sdao.add(st);
			System.out.println("=> " + st.toString());
			System.out.println("list: "+ sdao.ls.size());
		return"student-form";
		
	}
	
	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("LIST_STUDENT", sdao.getAll());
		return "view-student";
	}
	
	@ModelAttribute("list_major")
	public List<Major> getMajor(){
		return mdao.getAll();
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name="id") String st ) {
	
			StudentDao dao = new StudentDao();
			Student s = dao.findByID(st);
			model.addAttribute("STUDENT", s);
			model.addAttribute("ACTION", "/saveOrUpdate");
			System.out.println("=="+s);
		
		return"student-form";
	}
	
	
}
