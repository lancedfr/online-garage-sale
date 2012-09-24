package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * File Name: Product.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProdid", query = "SELECT p FROM Product p WHERE p.prodid = :prodid"),
    @NamedQuery(name = "Product.findByProdcondition", query = "SELECT p FROM Product p WHERE p.prodcondition = :prodcondition"),
    @NamedQuery(name = "Product.findByProddesc", query = "SELECT p FROM Product p WHERE p.proddesc = :proddesc"),
    @NamedQuery(name = "Product.findByProdprice", query = "SELECT p FROM Product p WHERE p.prodprice = :prodprice"),
    @NamedQuery(name = "Product.findByProdstatus", query = "SELECT p FROM Product p WHERE p.prodstatus = :prodstatus")
})
public class Product implements Serializable
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
    @Column(name = "PRODSTATUS")
    private Character prodstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodid")
    private List<Bid> bidList;
    @JoinColumn(name = "GARAGEID", referencedColumnName = "GARAGEID")
    @ManyToOne(optional = false)
    private Garage garageid;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne(optional = false)
    private Category categoryid;

    /**
     *
     */
    public Product()
    {
    }

    /**
     *
     * @param prodid
     */
    public Product(BigDecimal prodid)
    {
        this.prodid = prodid;
    }

    /**
     *
     * @return
     */
    public BigDecimal getProdid()
    {
        return prodid;
    }

    /**
     *
     * @param prodid
     */
    public void setProdid(BigDecimal prodid)
    {
        this.prodid = prodid;
    }

    /**
     *
     * @return
     */
    public String getProdcondition()
    {
        return prodcondition;
    }

    /**
     *
     * @param prodcondition
     */
    public void setProdcondition(String prodcondition)
    {
        this.prodcondition = prodcondition;
    }

    /**
     *
     * @return
     */
    public String getProddesc()
    {
        return proddesc;
    }

    /**
     *
     * @param proddesc
     */
    public void setProddesc(String proddesc)
    {
        this.proddesc = proddesc;
    }

    /**
     *
     * @return
     */
    public Serializable getProdimage()
    {
        return prodimage;
    }

    /**
     *
     * @param prodimage
     */
    public void setProdimage(Serializable prodimage)
    {
        this.prodimage = prodimage;
    }

    /**
     *
     * @return
     */
    public BigDecimal getProdprice()
    {
        return prodprice;
    }

    /**
     *
     * @param prodprice
     */
    public void setProdprice(BigDecimal prodprice)
    {
        this.prodprice = prodprice;
    }

    /**
     *
     * @return
     */
    public Character getProdstatus()
    {
        return prodstatus;
    }

    /**
     *
     * @param prodstatus
     */
    public void setProdstatus(Character prodstatus)
    {
        this.prodstatus = prodstatus;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    @JsonIgnore
    public List<Bid> getBidList()
    {
        return bidList;
    }

    /**
     *
     * @param bidList
     */
    public void setBidList(List<Bid> bidList)
    {
        this.bidList = bidList;
    }

    /**
     *
     * @return
     */
    public Garage getGarageid()
    {
        return garageid;
    }

    /**
     *
     * @param garageid
     */
    public void setGarageid(Garage garageid)
    {
        this.garageid = garageid;
    }

    /**
     *
     * @return
     */
    public Category getCategoryid()
    {
        return categoryid;
    }

    /**
     *
     * @param categoryid
     */
    public void setCategoryid(Category categoryid)
    {
        this.categoryid = categoryid;
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
        if (!(object instanceof Product))
        {
            return false;
        }
        Product other = (Product) object;
        if ((this.prodid == null && other.prodid != null) || (this.prodid != null && !this.prodid.equals(other.prodid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Product[ prodid=" + prodid + " ]";
    }
}
