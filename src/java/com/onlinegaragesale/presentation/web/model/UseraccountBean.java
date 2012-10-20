package com.onlinegaragesale.presentation.web.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * File Name: UseraccountBean.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.model
 * Author: Lance
 * Date: 16 Oct 2012
 * Edited: 16 Oct 2012
 */
public class UseraccountBean
{

    private BigDecimal userid;
    private String firstname;
    private String middlename;
    private String lastname;
    private Date dob;
    private Short age;
    private String email;
    private String hometell;
    private String worktell;
    private String cell;
    private String addressline;
    private String road;
    private String city;
    private String suburb;
    private String country;
    private String areacode;
    private String accountpassword;

    public BigDecimal getUserid()
    {
        return userid;
    }

    public void setUserid(BigDecimal userid)
    {
        this.userid = userid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getMiddlename()
    {
        return middlename;
    }

    public void setMiddlename(String middlename)
    {
        this.middlename = middlename;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    public Short getAge()
    {
        return age;
    }

    public void setAge(Short age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getHometell()
    {
        return hometell;
    }

    public void setHometell(String hometell)
    {
        this.hometell = hometell;
    }

    public String getWorktell()
    {
        return worktell;
    }

    public void setWorktell(String worktell)
    {
        this.worktell = worktell;
    }

    public String getCell()
    {
        return cell;
    }

    public void setCell(String cell)
    {
        this.cell = cell;
    }

    public String getAddressline()
    {
        return addressline;
    }

    public void setAddressline(String addressline)
    {
        this.addressline = addressline;
    }

    public String getRoad()
    {
        return road;
    }

    public void setRoad(String road)
    {
        this.road = road;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getAreacode()
    {
        return areacode;
    }

    public void setAreacode(String areacode)
    {
        this.areacode = areacode;
    }

    public String getAccountpassword()
    {
        return accountpassword;
    }

    public void setAccountpassword(String accountpassword)
    {
        this.accountpassword = accountpassword;
    }
}
