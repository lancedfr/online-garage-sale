package com.onlinegaragesale.presentation.web.controller;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.presentation.web.model.SampleBean;
import com.onlinegaragesale.services.crud.StudentCrudService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * File Name: SampleController.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.controller
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Controller
public class SampleController
{

    private final Facade facade = new Facade();

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "sample/sampleindex.html", method = RequestMethod.GET)
    public String getSampleIndex(Model model)
    {
        return "sample/sampleindex";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "sample/addsample.html", method = RequestMethod.GET)
    public String addSample(Model model)
    {
        SampleBean sampleBean = new SampleBean();
        model.addAttribute(sampleBean);
        return "sample/addsample";
    }

    /**
     *
     * @param sampleBean
     * @return
     */
    @RequestMapping(value = "sample/persistsample.html", method = RequestMethod.POST)
    public String addSample(@Validated SampleBean sampleBean)
    {
        StudentCrudService sampleCrudService = facade.getSampleCrudService();
        Student createSampleStudent = AppFactory.createSampleStudent(/*sampleBean.getFirstName()*/null);
        sampleCrudService.persist(createSampleStudent);
        return "sample/sampleindex";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "sample/deletesample.html", method = RequestMethod.GET)
    public String deleteSample(Model model)
    {
        SampleBean sampleBean = new SampleBean();
        model.addAttribute(sampleBean);
        return "sample/deletesample";
    }

    /**
     *
     * @param sampleBean
     * @return
     */
    @RequestMapping(value = "sample/removesample.html", method = RequestMethod.POST)
    public String deleteSample(@Validated SampleBean sampleBean)
    {
        StudentCrudService sampleCrudService = facade.getSampleCrudService();
        Student findById = sampleCrudService.findById(sampleBean.getId());
        sampleCrudService.remove(findById);
        return "sample/sampleindex";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "sample/editsample.html", method = RequestMethod.GET)
    public String editSample(Model model)
    {
        SampleBean sampleBean = new SampleBean();
        model.addAttribute(sampleBean);
        return "sample/editsample";
    }

    /**
     *
     * @param sampleBean
     * @return
     */
    @RequestMapping(value = "sample/mergesample.html", method = RequestMethod.POST)
    public String editSample(@Validated SampleBean sampleBean)
    {
        StudentCrudService sampleCrudService = facade.getSampleCrudService();
        Student findById = sampleCrudService.findById(sampleBean.getId());
        findById.setStudentNumber(sampleBean.getStudentNumber());
        sampleCrudService.merge(findById);
        return "sample/sampleindex";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "sample/listsamle.html", method = RequestMethod.GET)
    public String listSample(Model model)
    {
        StudentCrudService sampleCrudService = facade.getSampleCrudService();
        List<Student> students = sampleCrudService.findAll();
        model.addAttribute("samples", students);
        return "sample/listsamle";
    }
}
