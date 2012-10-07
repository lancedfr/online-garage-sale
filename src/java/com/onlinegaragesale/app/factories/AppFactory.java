package com.onlinegaragesale.app.factories;

import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.model.Category;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.model.Saleshistory;
import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.ObjectId;
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

    /**
     * Creates a new student
     *
     * @param values
     * @return new Student()
     */
    public static Student createSampleStudent(Map<String, String> values)
    {
        return new Student();
    }

    /**
     * Creates a new useraccount
     * <table border="1">
     * <tr><th>Useraccount Value</th><th>HashMap Value </th></tr>
     * <tr><td>Age</td> <td>age</td></tr>
     * <tr><td>Dob</td> <td>dob</td></tr>
     * <tr><td>Firstname</td> <td>firstName</td></tr>
     * <tr><td>Lastname</td> <td>lastName</td></tr>
     * <tr><td>Middlename</td> <td>middleName</td></tr>
     * <tr><td>Accountpassword</td> <td>pasword</td></tr>
     * <tr><td>Addressline</td> <td>address</td></tr>
     * <tr><td>Areacode</td> <td>areacode</td></tr>
     * <tr><td>City</td> <td>city</td></tr>
     * <tr><td>Country</td> <td>country</td></tr>
     * <tr><td>Road</td> <td>road</td></tr>
     * <tr><td>Suburb</td> <td>suberb</td></tr>
     * <tr><td>Cell</td> <td>cell</td></tr>
     * <tr><td>Email</td> <td>email</td></tr>
     * <tr><td>Hometell</td> <td>homeTell</td></tr>
     * <tr><td>Worktell</td> <td>workTell</td></tr>
     * </table>
     *
     * @param values
     * @return useraccount
     */
    public static Useraccount createUserAccount(HashMap<String, Object> values)
    {
        Useraccount useraccount = new Useraccount(ObjectId.getNewUserAccountId());
        useraccount.setAge(Short.valueOf(values.get("age").toString()));
        useraccount.setDob((Date) values.get("dob"));
        useraccount.setFirstname(values.get("firstName").toString());
        useraccount.setLastname(values.get("lastName").toString());
        useraccount.setMiddlename(values.get("middleName").toString());
        useraccount.setAccountpassword(values.get("pasword").toString());

        useraccount.setAddressline(values.get("address").toString());
        useraccount.setAreacode(values.get("areacode").toString());
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

    /**
     * Creates a new garage
     * <table border="1">
     * <tr><th>Useraccount Value</th><th>HashMap Value </th></tr>
     * <tr><td>Closedate</td> <td>closeDate</td></tr>
     * <tr><td>Garagetype</td> <td>garageType</td></tr>
     * <tr><td>Opendate</td> <td>openDate</td></tr>
     * <tr><td>Userid</td> <td>userId</td></tr>
     * </table>
     *
     * @param values
     * @return garage
     */
    public static Garage createGarage(HashMap<String, Object> values)
    {
        Garage garage = new Garage(ObjectId.getNewGarageId());
        garage.setClosedate((Date) values.get("closeDate"));
        garage.setGaragetype(values.get("garageType").toString());
        garage.setOpendate((Date) values.get("openDate"));
        garage.setUserid((Useraccount) values.get("userId"));

        return garage;
    }

    /**
     * Creates a new product
     * <table border="1">
     * <tr><th>Useraccount Value</th><th>HashMap Value </th></tr>
     * <tr><td>Categoryid</td> <td>categoryId</td></tr>
     * <tr><td>Garageid</td> <td>garageId</td></tr>
     * <tr><td>Prodcondition</td> <td>prodCondition</td></tr>
     * <tr><td>Proddesc</td> <td>prodDesc</td></tr>
     * <tr><td>Prodprice</td> <td>prodPrice</td></tr>
     * <tr><td>Prodstatus</td> <td>prodStatus</td></tr>
     * </table>
     *
     * @param values
     * @return product
     */
    public static Product createProduct(HashMap<String, Object> values)
    {
        Product product = new Product(ObjectId.getNewProductId());
        product.setCategoryid((Category) values.get("categoryId"));
        product.setGarageid((Garage) values.get("garageId"));
        product.setProdcondition(values.get("prodCondition").toString());
        product.setProddesc(values.get("prodDesc").toString());
        product.setProdprice(BigDecimal.valueOf(Double.valueOf(values.get("prodPrice").toString())));
        product.setProdstatus(values.get("prodStatus").toString().charAt(0));
        return product;
    }

    /**
     * Creates a new category
     * <table border="1">
     * <tr><th>Useraccount Value</th><th>HashMap Value </th></tr>
     * <tr><td>Categorytype</td> <td>categoryType</td></tr>
     * </table>
     *
     * @param values
     * @return category
     */
    public static Category createCategory(HashMap<String, Object> values)
    {
        Category category = new Category(ObjectId.getNewCategoryId());
        category.setCategorytype(values.get("categoryType").toString());
        return category;
    }

    /**
     * Creates a new bid
     * <table border="1">
     * <tr><th>Useraccount Value</th><th>HashMap Value </th></tr>
     * <tr><td>Bidamount</td> <td>bidAmount</td></tr>
     * <tr><td>Prodid</td> <td>prodId</td></tr>
     * <tr><td>Userid</td> <td>userId</td></tr>
     * </table>
     *
     * @param values
     * @return bid
     */
    public static Bid createBid(HashMap<String, Object> values)
    {
        Bid bid = new Bid(ObjectId.getNewBidId());
        bid.setBidamount(BigDecimal.valueOf(Double.valueOf(values.get("bidAmount").toString())));
        bid.setProdid((Product) values.get("prodId"));
        bid.setUserid(BigDecimal.valueOf(Double.valueOf(values.get("userId").toString())));
        return bid;
    }

    public static Saleshistory createSalesHistory(HashMap<String, Object> values)
    {
        Saleshistory saleshistory = new Saleshistory();
        saleshistory.setProductsalesList(null);
        saleshistory.setTotalsales(BigDecimal.ZERO);
        saleshistory.setTotalsalescount(BigInteger.ZERO);
        saleshistory.setUseraccount(null);
        saleshistory.setUserid(BigDecimal.ZERO);
        return saleshistory;
    }
}
