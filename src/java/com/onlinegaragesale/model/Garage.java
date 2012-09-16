package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * File Name: Garage.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity
@Table(name = "GARAGE")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Garage.findAll", query = "SELECT g FROM Garage g"),
    @NamedQuery(name = "Garage.findByGarageid", query = "SELECT g FROM Garage g WHERE g.garageid = :garageid"),
    @NamedQuery(name = "Garage.findByOpendate", query = "SELECT g FROM Garage g WHERE g.opendate = :opendate"),
    @NamedQuery(name = "Garage.findByClosedate", query = "SELECT g FROM Garage g WHERE g.closedate = :closedate"),
    @NamedQuery(name = "Garage.findByGaragetype", query = "SELECT g FROM Garage g WHERE g.garagetype = :garagetype")
})
public class Garage implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GARAGEID")
    private Long garageid;
    @Basic(optional = false)
    @Column(name = "OPENDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opendate;
    @Column(name = "CLOSEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closedate;
    @Column(name = "GARAGETYPE")
    private String garagetype;
    @OneToMany(mappedBy = "garageid")
    private List<Product> productList;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Useraccount userid;

    public Garage()
    {
        this.garageid = Long.valueOf(0);
    }

    public Garage(Long garageid)
    {
        this.garageid = garageid;
    }

    public Long getGarageid()
    {
        return garageid;
    }

    public void setGarageid(Long garageid)
    {
        this.garageid = garageid;
    }

    public Date getOpendate()
    {
        return opendate;
    }

    public void setOpendate(Date opendate)
    {
        this.opendate = opendate;
    }

    public Date getClosedate()
    {
        return closedate;
    }

    public void setClosedate(Date closedate)
    {
        this.closedate = closedate;
    }

    public String getGaragetype()
    {
        return garagetype;
    }

    public void setGaragetype(String garagetype)
    {
        this.garagetype = garagetype;
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

    public Useraccount getUserid()
    {
        return userid;
    }

    public void setUserid(Useraccount userid)
    {
        this.userid = userid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (garageid != null ? garageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garage))
        {
            return false;
        }
        Garage other = (Garage) object;
        if ((this.garageid == null && other.garageid != null) || (this.garageid != null && !this.garageid.equals(other.garageid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Garage[ garageid=" + garageid + " ]";
    }
}
