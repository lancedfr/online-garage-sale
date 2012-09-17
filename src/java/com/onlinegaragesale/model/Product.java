package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
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
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity 
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProdid", query = "SELECT p FROM Product p WHERE p.prodid = :prodid"),
    @NamedQuery(name = "Product.findByProddesc", query = "SELECT p FROM Product p WHERE p.proddesc = :proddesc"),
    @NamedQuery(name = "Product.findByProdcondition", query = "SELECT p FROM Product p WHERE p.prodcondition = :prodcondition"),
    @NamedQuery(name = "Product.findByProdprice", query = "SELECT p FROM Product p WHERE p.prodprice = :prodprice")
})
public class Product implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRODID")
    private Long prodid;
    @Column(name = "PRODDESC")
    private String proddesc;
    @Column(name = "PRODCONDITION")
    private String prodcondition;
    @Column(name = "PRODPRICE")
    private BigDecimal prodprice;
    @Lob
    @Column(name = "PRODIMAGE")
    private Serializable prodimage;
    @OneToMany(mappedBy = "prodid")
    private List<Bid> bidList;
    @OneToMany(mappedBy = "prodid")
    private List<Category> categoryList;
    @JoinColumn(name = "GARAGEID", referencedColumnName = "GARAGEID")
    @ManyToOne
    private Garage garageid;

    public Product()
    {
        this.prodid = new Long(0);
    }

    public Product(Long prodid)
    {
        this.prodid = prodid;
    }

    public Long getProdid()
    {
        return prodid;
    }

    public void setProdid(Long prodid)
    {
        this.prodid = prodid;
    }

    public String getProddesc()
    {
        return proddesc;
    }

    public void setProddesc(String proddesc)
    {
        this.proddesc = proddesc;
    }

    public String getProdcondition()
    {
        return prodcondition;
    }

    public void setProdcondition(String prodcondition)
    {
        this.prodcondition = prodcondition;
    }

    public BigDecimal getProdprice()
    {
        return prodprice;
    }

    public void setProdprice(BigDecimal prodprice)
    {
        this.prodprice = prodprice;
    }

    public Serializable getProdimage()
    {
        return prodimage;
    }

    public void setProdimage(Serializable prodimage)
    {
        this.prodimage = prodimage;
    }
    
    @XmlTransient
    @JsonIgnore
    public List<Bid> getBidList()
    {
        return bidList;
    }

    public void setBidList(List<Bid> bidList)
    {
        this.bidList = bidList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Category> getCategoryList()
    {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList)
    {
        this.categoryList = categoryList;
    }

    public Garage getGarageid()
    {
        return garageid;
    }

    public void setGarageid(Garage garageid)
    {
        this.garageid = garageid;
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
