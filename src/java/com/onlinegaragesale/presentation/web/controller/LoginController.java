package com.onlinegaragesale.presentation.web.controller;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.presentation.web.model.UseraccountBean;
import com.onlinegaragesale.services.CreateUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
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

    private final Facade facade = new Facade();

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

    @RequestMapping(value = "/signup.html", method = RequestMethod.GET)
    public String getSighUp(Model model)
    {
        UseraccountBean useraccountBean = new UseraccountBean();
        model.addAttribute(useraccountBean);
        return "signup";
    }

    @RequestMapping(value = "/signupprocess.html", method = RequestMethod.POST)
    public String signUpProcess(@Validated UseraccountBean useraccountBean)
    {
        Useraccount createUserAccount = AppFactory.createUserAccount(useraccountBean);
        CreateUser createUserService = facade.getCreateUserService();
        createUserService.createNewUser(createUserAccount);
        return "index";
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