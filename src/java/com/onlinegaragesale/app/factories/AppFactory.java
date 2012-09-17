package com.onlinegaragesale.app.factories;

import com.onlinegaragesale.model.Address;
import com.onlinegaragesale.model.Category;
import com.onlinegaragesale.model.Contact;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.model.Useraccount;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.metamodel.source.hbm.Helper;

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

    public static Garage createGarage(HashMap<String, Object> values)
    {
        Garage garage = new Garage();
        garage.setClosedate((Date) values.get("closeDate"));
        garage.setGaragetype(values.get("garageType").toString());
        garage.setOpendate((Date) values.get("openDate"));
        garage.setUserid((Useraccount)values.get("userId"));
        
        return garage;
    }

    public static Product createProduct(HashMap<String, Object> values)
    {
        Product product = new Product();
        product.setCategoryList(createCatagory(values));
        product.setGarageid((Garage) values.get("garageId"));
        product.setProdcondition(values.get("prodCondition").toString());
        product.setProddesc(values.get("prodDesc").toString());
        product.setProdprice(BigDecimal.valueOf(Double.valueOf(values.get("prodPrice").toString())));
        return product;
    }
    
    private static List<Category> createCatagory(HashMap<String, Object> values)
    {
        Category category = new Category();
        category.setCategorytype(values.get("categoryType").toString());
        List<Category> categorys = new ArrayList<Category>();
        categorys.add(category);
        return categorys;
    }

}
