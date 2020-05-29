package com.controller;


import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.Dao.StudentDao;
import com.hibernate.Entity.*;

@RestController
public class HomeController {

	@RequestMapping(value = "/hello" ,method = RequestMethod.GET)

	public @ResponseBody List<Users> show(@RequestParam String id) {

		System.out.println(id);

		StudentDao obj = new StudentDao();
		List<Users> list = obj.getQuery();
		System.out.println(list);
//		List<Student> l = new ArrayList<Student>();
//		l.add(new Student(1 , "sreeraj"));
//		Iterator<List<Users>> itr = list.iterator();
//		for (Users user : list) {
//			System.out.println(user.getBooking());
//		}
//		return list;
		return list;
		}

}