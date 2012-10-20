package com.onlinegaragesale.presentation.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * File Name: ProductBean.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.presentation.web.model
 * Author: Lance
 * Date: 19 Oct 2012
 * Edited: 19 Oct 2012
 */
public class ProductBean
{

    private BigDecimal prodid;
    private String prodcondition;
    private String proddesc;
    private Serializable prodimage;
    private BigDecimal prodprice;
    private Character prodstatus;
    private String garageid;
    private String categoryid;

    public BigDecimal getProdid()
    {
        return prodid;
    }

    public void setProdid(BigDecimal prodid)
    {
        this.prodid = prodid;
    }

    public String getProdcondition()
    {
        return prodcondition;
    }

    public void setProdcondition(String prodcondition)
    {
        this.prodcondition = prodcondition;
    }

    public String getProddesc()
    {
        return proddesc;
    }

    public void setProddesc(String proddesc)
    {
        this.proddesc = proddesc;
    }

    public Serializable getProdimage()
    {
        return prodimage;
    }

    public void setProdimage(Serializable prodimage)
    {
        this.prodimage = prodimage;
    }

    public BigDecimal getProdprice()
    {
        return prodprice;
    }

    public void setProdprice(BigDecimal prodprice)
    {
        this.prodprice = prodprice;
    }

    public Character getProdstatus()
    {
        return prodstatus;
    }

    public void setProdstatus(Character prodstatus)
    {
        this.prodstatus = prodstatus;
    }

    public String getGarageid()
    {
        return garageid;
    }

    public void setGarageid(String garageid)
    {
        this.garageid = garageid;
    }

    public String getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(String categoryid)
    {
        this.categoryid = categoryid;
    }
}
