package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

/*
 * Run the project in Run On Server mode.
 * 
 * URL as localhost:8080/SpringMVCForm/student in browser.
 * 
 */

@Controller
public class StudentController {
   @RequestMapping(value = "student123", method = RequestMethod.GET)
   public ModelAndView student() {
	   /*
	    * Here the first service method student(), we have passed a blank Student object in the ModelAndView object with the name 
	    * "command" because the Spring framework expects an object with the name "command" if you are using <form:form> tags in your JSP file. 
	    * So, when student() method is called , it returns student.jsp view.
	    */
	   System.out.println("In the controller...");
      return new ModelAndView("student", "command", new Student());
   }
   
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
      public String addStudent(@ModelAttribute("test")Student student, ModelMap model) 
   {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      System.out.println("In the addstudent() of controller...");
      
      return "result";
   }
}