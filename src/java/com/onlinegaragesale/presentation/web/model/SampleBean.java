package com.onlinegaragesale.presentation.web.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * File Name: SampleBean.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.model
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class SampleBean
{

    private BigDecimal id;
    private String studentNumber;
    private String firstName;
    private String lastName;
    private Date dob;

    /**
     *
     * @return
     */
    public BigDecimal getId()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(BigDecimal id)
    {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getStudentNumber()
    {
        return studentNumber;
    }

    /**
     *
     * @param studentNumber
     */
    public void setStudentNumber(String studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    /**
     *
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public Date getDob()
    {
        return dob;
    }

    /**
     *
     * @param dob
     */
    public void setDob(Date dob)
    {
        this.dob = dob;
    }
}
