
package com.redsea.mas.controller;


import com.redsea.mas.serviceImpl.RoleService;
import com.redsea.mas.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value= {"/","/login"}, method = RequestMethod.GET)
    public ModelAndView login(SessionStatus status){
        //status.setComplete();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
   @RequestMapping(value={"/logout"}, method = RequestMethod.GET)
    public String logOut(SessionStatus status){
       // status.setComplete();
        return "redirect:/login";

   }




}

