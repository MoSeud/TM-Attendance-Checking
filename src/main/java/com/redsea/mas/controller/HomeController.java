package com.redsea.mas.controller;

import com.redsea.mas.domain.Person;
import com.redsea.mas.domain.Role;
import com.redsea.mas.serviceImpl.LoginService;
import com.redsea.mas.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes({"person","id","role"})
public class HomeController {


    @Autowired
    LoginService loginService;
    @Autowired
    UserService userService;

    @GetMapping(value={"/home"})
    public String home(Model model, Authentication auth){
      String email = auth.getName();
        String role=loginService.getRole(auth);
      Person person =(Person)loginService.getCurrentUserID(auth);
      model.addAttribute("person", person);
      Long id=person!=null? person.getId():null;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+id);
        model.addAttribute("id", id);
      model.addAttribute("role",role);

       // return "index";
        if(role.equals("ADMIN"))
        return "admin/index2";
        else if(role.equals("FACULTY")){
            return "faculty/index";
        }
        else
            return "student/index";
    }

    @GetMapping(value={"/access-denied"})
    public String denied(){
        return "access-denied";
    }
}
