package com.saikiran.springmvc.website.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saikiran.springmvc.website.model.RegistrationDetails;
import com.saikiran.springmvc.website.repository.RepositoryDAO;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String userDetails(ModelMap model){
		RegistrationDetails rd = new RegistrationDetails();
		model.addAttribute("register", rd);
		return "register";
	}
	
	 @RequestMapping(value ="test", method=RequestMethod.POST)
	    public String printOther(@Valid @ModelAttribute RegistrationDetails user, BindingResult result, HttpServletRequest model, Model mod)
	    {
	        RegistrationDetails info = new RegistrationDetails();
	        ArrayList<RegistrationDetails> RegistrationDetailsIterator = new ArrayList<RegistrationDetails>();
	        
	        String Name = model.getParameter("Name");
	        String Course = model.getParameter("Course");
	        int Fee = Integer.parseInt(model.getParameter("Fee"));
	        int Year = Integer.parseInt(model.getParameter("Year"));
	        
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        Date date = new Date();
	        String curDate = (String)dateFormat.format(date);
	        
	        info.setName(Name);
	        info.setCourse(Course);
	        info.setFee(Fee);
	        info.setYear(Year);
	        info.setCurDate(curDate);
	        RegistrationDetailsIterator.add(info);
	        RepositoryDAO dbc = new RepositoryDAO();
	        dbc.getConnection();
	        
	        System.out.println(Name);
	        dbc.InsertUserInfoValues(RegistrationDetailsIterator);
	        
	         String Name1 = dbc.RetrieveUserInformationValues().get(dbc.RetrieveUserInformationValues().size()-1).getName();
	         String Course1 = dbc.RetrieveUserInformationValues().get(dbc.RetrieveUserInformationValues().size()-1).getCourse();
	         int fee1 = dbc.RetrieveUserInformationValues().get(dbc.RetrieveUserInformationValues().size()-1).getFee();
	         int year1 = dbc.RetrieveUserInformationValues().get(dbc.RetrieveUserInformationValues().size()-1).getYear();
	         String curDate1 = dbc.RetrieveUserInformationValues().get(dbc.RetrieveUserInformationValues().size()-1).getCurDate();
	         dbc.closeConnection(); 
	         
	        model.setAttribute("NameRet", Name1);
	        model.setAttribute("CourseRet", Course1);
	        model.setAttribute("FreRet", fee1);
	        model.setAttribute("YearRet", year1);
	        model.setAttribute("CurDateRet", curDate1);
	       return "welcome";
	       }
}
