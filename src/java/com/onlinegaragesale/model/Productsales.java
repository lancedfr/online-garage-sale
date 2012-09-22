package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * File Name: Productsales.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
@Entity 
@Table(name = "PRODUCTSALES")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Productsales.findAll", query = "SELECT p FROM Productsales p"),
    @NamedQuery(name = "Productsales.findByProdid", query = "SELECT p FROM Productsales p WHERE p.prodid = :prodid"),
    @NamedQuery(name = "Productsales.findByProdcondition", query = "SELECT p FROM Productsales p WHERE p.prodcondition = :prodcondition"),
    @NamedQuery(name = "Productsales.findByProddesc", query = "SELECT p FROM Productsales p WHERE p.proddesc = :proddesc"),
    @NamedQuery(name = "Productsales.findByProdprice", query = "SELECT p FROM Productsales p WHERE p.prodprice = :prodprice")
})
public class Productsales implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRODID")
    private BigDecimal prodid;
    @Column(name = "PRODCONDITION")
    private String prodcondition;
    @Column(name = "PRODDESC")
    private String proddesc;
    @Lob
    @Column(name = "PRODIMAGE")
    private Serializable prodimage;
    @Column(name = "PRODPRICE")
    private BigDecimal prodprice;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Saleshistory userid;

    public Productsales()
    {
    }

    public Productsales(BigDecimal prodid)
    {
        this.prodid = prodid;
    }

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

    public Saleshistory getUserid()
    {
        return userid;
    }

    public void setUserid(Saleshistory userid)
    {
        this.userid = userid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (prodid != null ? prodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productsales))
        {
            return false;
        }
        Productsales other = (Productsales) object;
        if ((this.prodid == null && other.prodid != null) || (this.prodid != null && !this.prodid.equals(other.prodid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Productsales[ prodid=" + prodid + " ]";
    }

}
