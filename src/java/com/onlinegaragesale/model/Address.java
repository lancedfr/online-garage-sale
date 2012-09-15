package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * File Name: Address.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity 
@Table(name = "ADDRESS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByUserid", query = "SELECT a FROM Address a WHERE a.userid = :userid"),
    @NamedQuery(name = "Address.findByAddressline", query = "SELECT a FROM Address a WHERE a.addressline = :addressline"),
    @NamedQuery(name = "Address.findByRoad", query = "SELECT a FROM Address a WHERE a.road = :road"),
    @NamedQuery(name = "Address.findBySuburb", query = "SELECT a FROM Address a WHERE a.suburb = :suburb"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByAreacode", query = "SELECT a FROM Address a WHERE a.areacode = :areacode"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
})
public class Address implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Long userid;
    @Column(name = "ADDRESSLINE")
    private String addressline;
    @Basic(optional = false)
    @Column(name = "ROAD")
    private String road;
    @Column(name = "SUBURB")
    private String suburb;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "AREACODE")
    private String areacode;
    @Basic(optional = false)
    @Column(name = "COUNTRY")
    private String country;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Useraccount useraccount;

    public Address()
    {
    }

    public Address(Long userid)
    {
        this.userid = userid;
    }

    public Address(Long userid, String road, String city, String country)
    {
        this.userid = userid;
        this.road = road;
        this.city = city;
        this.country = country;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public String getAddressline()
    {
        return addressline;
    }

    public void setAddressline(String addressline)
    {
        this.addressline = addressline;
    }

    public String getRoad()
    {
        return road;
    }

    public void setRoad(String road)
    {
        this.road = road;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getAreacode()
    {
        return areacode;
    }

    public void setAreacode(String areacode)
    {
        this.areacode = areacode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
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
        if (!(object instanceof Address))
        {
            return false;
        }
        Address other = (Address) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Address[ userid=" + userid + " ]";
    }

}
