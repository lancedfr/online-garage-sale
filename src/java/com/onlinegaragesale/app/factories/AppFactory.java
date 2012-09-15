package com.onlinegaragesale.app.factories;

import com.onlinegaragesale.model.Address;
import com.onlinegaragesale.model.Contact;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.model.Useraccount;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * File Name: AppFactory.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.factories
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class AppFactory
{

    public static Student createSampleStudent(Map<String, String> values)
    {
        return new Student();
    }

    public static Useraccount createUserAccount(HashMap<String, String> values)
    {
        Useraccount useraccount = new Useraccount(Long.valueOf(55));
        useraccount.setAge(BigInteger.ONE);
        useraccount.setDob(new Date());
        useraccount.setFirstname("Fname");
        useraccount.setLastname("lName");
        useraccount.setMiddlename("mName");
        useraccount.setPassword("password");
        useraccount.setAddress(createAddress(values));
        useraccount.setContact(createContact(values));
        return useraccount;
    }
    
    private static Address createAddress(HashMap<String, String> values)
    {
        Address address = new Address(Long.valueOf(55));
        address.setAddressline("addressLine");
        address.setAreacode("7987");
        address.setCity("city");
        address.setCountry("country");
        address.setRoad("road");
        address.setSuburb("suberb");
        return address;
    }
    
    private static Contact createContact(HashMap<String, String> values)
    {
        Contact contact = new Contact(Long.valueOf(55));
        contact.setCell("092834098");
        contact.setEmail("sdfg@asdf.com");
        contact.setHometell("3456456");
        contact.setWorktell("+2340987");
        return contact;
    }
}
