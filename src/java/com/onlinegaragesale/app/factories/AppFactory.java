package com.onlinegaragesale.app.factories;

import com.onlinegaragesale.model.Address;
import com.onlinegaragesale.model.Contact;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.model.Useraccount;
import java.math.BigDecimal;
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

    public static Useraccount createUserAccount(HashMap<String, Object> values)
    {
        Useraccount useraccount = new Useraccount();
        useraccount.setAge(BigDecimal.valueOf(Long.valueOf(values.get("age").toString())));
        useraccount.setDob((Date) values.get("dob"));
        useraccount.setFirstname(values.get("firstName").toString());
        useraccount.setLastname(values.get("lastName").toString());
        useraccount.setMiddlename(values.get("middleName").toString());
        useraccount.setAccountpassword(values.get("pasword").toString());

        useraccount.setAddressline(values.get("address").toString());
        useraccount.setAreacode(values.get("addressLine").toString());
        useraccount.setCity(values.get("city").toString());
        useraccount.setCountry(values.get("country").toString());
        useraccount.setRoad(values.get("road").toString());
        useraccount.setSuburb(values.get("suberb").toString());

        useraccount.setCell(values.get("cell").toString());
        useraccount.setEmail(values.get("email").toString());
        useraccount.setHometell(values.get("homeTell").toString());
        useraccount.setWorktell(values.get("workTell").toString());
        return useraccount;
    }

    private static Address createAddress(HashMap<String, Object> values)
    {
        Address address = new Address();
        address.setAddressline(values.get("address").toString());
        address.setAreacode(values.get("addressLine").toString());
        address.setCity(values.get("city").toString());
        address.setCountry(values.get("country").toString());
        address.setRoad(values.get("road").toString());
        address.setSuburb(values.get("suberb").toString());
        return address;
    }

    private static Contact createContact(HashMap<String, Object> values)
    {
        Contact contact = new Contact();
        contact.setCell(values.get("cell").toString());
        contact.setEmail(values.get("email").toString());
        contact.setHometell(values.get("homeTell").toString());
        contact.setWorktell(values.get("workTell").toString());
        return contact;
    }

    public static Garage createGarage(HashMap<String, Object> values)
    {
        Garage garage = new Garage();
        garage.setClosedate((Date) values.get("closeDate"));
        garage.setGaragetype(values.get("garageType").toString());
        garage.setOpendate((Date) values.get("openDate"));
        garage.setUserid((Useraccount)values.get("userId"));
        
        return garage;
    }
}
