package com.onlinegaragesale.presentation.web.controller;

import com.onlinegaragesale.app.facade.Facade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * File Name: HomeController.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.controller
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Controller
public class HomeController
{

    private final Facade facade = new Facade();
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     *
     * @return
     */
    @RequestMapping(
    {
        "/"
    })
    public String home()
    {
        return "index";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/about.html", method = RequestMethod.GET)
    public String getAbout(Model model)
    {
        return "about";
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String getHome(Model model)
    {
        return "index";
    }
//    @RequestMapping(value = "/add.html", method = RequestMethod.GET)
//    public String getAdd(Model model) 
//    {
//        UniversityBean universityBean = new UniversityBean();       
//        model.addAttribute("universityBean", universityBean);
//        return "add";
//    }   
//    
//    @RequestMapping(value = "/persist.html", method = RequestMethod.POST)
//    public String persistUniversity(@Validated UniversityBean universityBean)
//    {       
//        University university = new University();
//        university.setUniversityName(universityBean.getName());
//        
//        facade.getUniversityCrudServcve().persist(university);
//        
//        return "index";
//    }
//    
//    @RequestMapping(value = "/delete.html", method = RequestMethod.GET)
//    public String getDelete(Model model)
//    {
//        UniversityBean universityBean = new UniversityBean();
//        model.addAttribute("universityBean",universityBean);
//        return "delete";
//    }
//    
//    @RequestMapping(value = "/deleteUniversity.html", method = RequestMethod.POST)
//    public String getDeleteUniversity(@Validated UniversityBean universityBean)
//    { 
//        
//        University university = new University();
//        university.setUniversityName(universityBean.getName());
//        
//        List<University> universities = facade.getUniversityCrudServcve().findAll();
//        
//
//        
//        for(University uni:universities)
//        {
//            if(university.getUniversityName().equalsIgnoreCase( uni.getUniversityName()))
//            {
//                facade.getUniversityCrudServcve().removeById(uni.getId());
//            }
//        }
//        return "index";
//    }
//    
//    
//    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
//    public String getedit(Model model) 
//    {
//       UniversityBean universityBean = new UniversityBean();
//       model.addAttribute("universityBean",universityBean);
//       return "edit";
//        
//    }
//    
//    @RequestMapping(value = "/editUniversity.html", method = RequestMethod.POST)
//    public String geteditUniversity(@Validated UniversityBean universityBean) 
//    {
//        University university = new University();
//        university.setUniversityName(universityBean.getName());
//        
//        List<University> universities = facade.getUniversityCrudServcve().findAll();
//        
//
//        
//        for(University uni:universities)
//        {
//            if(university.getUniversityName().equalsIgnoreCase( uni.getUniversityName()))
//            {
//                uni.setUniversityName(universityBean.getNewName());
//                facade.getUniversityCrudServcve().merge(uni);
//            }
//        }
//        return "index";
//             
//    }
//    
//    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
//    public String getList(Model model) 
//    {
// 
//        List<University> universities = facade.getUniversityCrudServcve().findAll();
//        
//        model.addAttribute("universities",universities);  
//        return "list";
//    }
}