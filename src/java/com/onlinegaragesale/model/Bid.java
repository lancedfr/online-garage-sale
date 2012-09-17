package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * File Name: Bid.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 17 Sep 2012
 * Edited: 17 Sep 2012
 */
@Entity 
@Table(name = "BID")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Bid.findAll", query = "SELECT b FROM Bid b"),
    @NamedQuery(name = "Bid.findByBidid", query = "SELECT b FROM Bid b WHERE b.bidid = :bidid"),
    @NamedQuery(name = "Bid.findByBidamount", query = "SELECT b FROM Bid b WHERE b.bidamount = :bidamount"),
    @NamedQuery(name = "Bid.findByUserid", query = "SELECT b FROM Bid b WHERE b.userid = :userid")
})
public class Bid implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BIDID")
    private Long bidid;
    @Column(name = "BIDAMOUNT")
    private BigDecimal bidamount;
    @Column(name = "USERID")
    private Long userid;
    @JoinColumn(name = "PRODID", referencedColumnName = "PRODID")
    @ManyToOne
    private Product prodid;

    public Bid()
    {
    }

    public Bid(Long bidid)
    {
        this.bidid = bidid;
    }

    public Long getBidid()
    {
        return bidid;
    }

    public void setBidid(Long bidid)
    {
        this.bidid = bidid;
    }

    public BigDecimal getBidamount()
    {
        return bidamount;
    }

    public void setBidamount(BigDecimal bidamount)
    {
        this.bidamount = bidamount;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
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
        hash += (bidid != null ? bidid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bid))
        {
            return false;
        }
        Bid other = (Bid) object;
        if ((this.bidid == null && other.bidid != null) || (this.bidid != null && !this.bidid.equals(other.bidid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Bid[ bidid=" + bidid + " ]";
    }

}
