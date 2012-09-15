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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * File Name: Saleshistory.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity 
@Table(name = "SALESHISTORY")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Saleshistory.findAll", query = "SELECT s FROM Saleshistory s"),
    @NamedQuery(name = "Saleshistory.findByUserid", query = "SELECT s FROM Saleshistory s WHERE s.userid = :userid"),
    @NamedQuery(name = "Saleshistory.findBySalesid", query = "SELECT s FROM Saleshistory s WHERE s.salesid = :salesid"),
    @NamedQuery(name = "Saleshistory.findByTotalsalescount", query = "SELECT s FROM Saleshistory s WHERE s.totalsalescount = :totalsalescount"),
    @NamedQuery(name = "Saleshistory.findByTotalsales", query = "SELECT s FROM Saleshistory s WHERE s.totalsales = :totalsales")
})
public class Saleshistory implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Long userid;
    @Basic(optional = false)
    @Column(name = "SALESID")
    private BigInteger salesid;
    @Column(name = "TOTALSALESCOUNT")
    private Short totalsalescount;
    @Column(name = "TOTALSALES")
    private BigDecimal totalsales;
    @OneToMany(mappedBy = "userid")
    private List<Productsales> productsalesList;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Useraccount useraccount;

    public Saleshistory()
    {
    }

    public Saleshistory(Long userid)
    {
        this.userid = userid;
    }

    public Saleshistory(Long userid, BigInteger salesid)
    {
        this.userid = userid;
        this.salesid = salesid;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public BigInteger getSalesid()
    {
        return salesid;
    }

    public void setSalesid(BigInteger salesid)
    {
        this.salesid = salesid;
    }

    public Short getTotalsalescount()
    {
        return totalsalescount;
    }

    public void setTotalsalescount(Short totalsalescount)
    {
        this.totalsalescount = totalsalescount;
    }

    public BigDecimal getTotalsales()
    {
        return totalsales;
    }

    public void setTotalsales(BigDecimal totalsales)
    {
        this.totalsales = totalsales;
    }

    @XmlTransient
    @JsonIgnore
    public List<Productsales> getProductsalesList()
    {
        return productsalesList;
    }

    public void setProductsalesList(List<Productsales> productsalesList)
    {
        this.productsalesList = productsalesList;
    }

    public Useraccount getUseraccount()
    {
        return useraccount;
    }

    public void setUseraccount(Useraccount useraccount)
    {
        this.useraccount = useraccount;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saleshistory))
        {
            return false;
        }
        Saleshistory other = (Saleshistory) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Saleshistory[ userid=" + userid + " ]";
    }

}
