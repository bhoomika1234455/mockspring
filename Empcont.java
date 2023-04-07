package com.jsp.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.jsp.mock.dao.Emploedao;
import com.jsp.mock.dto.Empyoedto;


@Controller
public class Empcont {
	
	
		@Autowired
		Empyoedto emp;
	    @Autowired
	    Emploedao empdao;
		@RequestMapping("/signupem")
		public ModelAndView signup() {
			ModelAndView modelAndView = new ModelAndView("insertde.jsp");
			modelAndView.addObject("empobject", emp);
			return modelAndView;
		}
		@RequestMapping("/save")
		public ModelAndView savedata(Empyoedto recdto){
			System.out.println("saving the data");
			empdao.insert(recdto);
			ModelAndView view=new ModelAndView("savedata.jsp");
			return view;
		}
		@RequestMapping("/delete1")  
		public ModelAndView deleteid(){
			ModelAndView view=new ModelAndView("delete.jsp");
			view.addObject("deletebyid", emp);
			return view;
			}
		@ResponseBody
		@RequestMapping("/deleteid")
		public  String deleteid(Empyoedto empdto){
			Empyoedto empdto1=empdao.findbyid(empdto.getId());
			empdao.deletedata(empdto1);
			return "record deleted"+ " "+empdto1.getId();
			
		}
		
		@RequestMapping("/fetchall")
		public ModelAndView displayall()
		{
			List<Empyoedto> deta =empdao.fetchdata();
			ModelAndView view=new ModelAndView("disall.jsp");
			view.addObject("key1", deta);
			return view;
		}
}
