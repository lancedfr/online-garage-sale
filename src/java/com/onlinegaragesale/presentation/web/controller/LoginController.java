package com.onlinegaragesale.presentation.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * File Name: LoginController.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.controller
 * Author: Lance
 * Date: 14 Oct 2012
 * Edited: 14 Oct 2012
 */
@Controller
public class LoginController
{

    public LoginController()
    {
        //Initialize controller properties here or 
        //in the Web Application Context
        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String getLogin(Model model)
    {
        return "login";
    }

    @RequestMapping(value = "/logoutsuccess.html", method = RequestMethod.GET)
    public String getLogon(Model model)
    {
        return "logoutsuccess";
    }
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     @Override
     protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception 
     {
     ModelAndView mv = new ModelAndView(getSuccessView());
     //Do something...
     return mv;
     }
     */
}