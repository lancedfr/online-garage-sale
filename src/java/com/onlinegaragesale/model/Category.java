package com.onlinegaragesale.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * File Name: Category.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity 
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryid", query = "SELECT c FROM Category c WHERE c.categoryid = :categoryid"),
    @NamedQuery(name = "Category.findByCategorytype", query = "SELECT c FROM Category c WHERE c.categorytype = :categorytype")
})
public class Category implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CATEGORYID")
    private Long categoryid;
    @Column(name = "CATEGORYTYPE")
    private String categorytype;
    @JoinColumn(name = "PRODID", referencedColumnName = "PRODID")
    @ManyToOne
    private Product prodid;

    public Category()
    {
    }

    public Category(Long categoryid)
    {
        this.categoryid = categoryid;
    }

    public Long getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(Long categoryid)
    {
        this.categoryid = categoryid;
    }

    public String getCategorytype()
    {
        return categorytype;
    }

    public void setCategorytype(String categorytype)
    {
        this.categorytype = categorytype;
    }

    public Product getProdid()
    {
        return prodid;
    }

    public void setProdid(Product prodid)
    {
        this.prodid = prodid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (categoryid != null ? categoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category))
        {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryid == null && other.categoryid != null) || (this.categoryid != null && !this.categoryid.equals(other.categoryid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Category[ categoryid=" + categoryid + " ]";
    }

}
