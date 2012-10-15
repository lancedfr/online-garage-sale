package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * File Name: Category.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Oct 2012
 * Edited: 15 Oct 2012
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CATEGORYID")
    private BigDecimal categoryid;
    @Column(name = "CATEGORYTYPE")
    private String categorytype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryid")
    private List<Product> productList;

    public Category()
    {
    }

    public Category(BigDecimal categoryid)
    {
        this.categoryid = categoryid;
    }

    public BigDecimal getCategoryid()
    {
        return categoryid;
    }

    public void setCategoryid(BigDecimal categoryid)
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

    @XmlTransient
    @JsonIgnore
    public List<Product> getProductList()
    {
        return productList;
    }

    public void setProductList(List<Product> productList)
    {
        this.productList = productList;
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
