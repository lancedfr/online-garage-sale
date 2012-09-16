package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * File Name: Useraccount.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 16 Sep 2012
 * Edited: 16 Sep 2012
 */
@Entity 
@Table(name = "USERACCOUNT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Useraccount.findAll", query = "SELECT u FROM Useraccount u"),
    @NamedQuery(name = "Useraccount.findByUserid", query = "SELECT u FROM Useraccount u WHERE u.userid = :userid"),
    @NamedQuery(name = "Useraccount.findByAccountpassword", query = "SELECT u FROM Useraccount u WHERE u.accountpassword = :accountpassword"),
    @NamedQuery(name = "Useraccount.findByAddressline", query = "SELECT u FROM Useraccount u WHERE u.addressline = :addressline"),
    @NamedQuery(name = "Useraccount.findByAreacode", query = "SELECT u FROM Useraccount u WHERE u.areacode = :areacode"),
    @NamedQuery(name = "Useraccount.findByCity", query = "SELECT u FROM Useraccount u WHERE u.city = :city"),
    @NamedQuery(name = "Useraccount.findByCountry", query = "SELECT u FROM Useraccount u WHERE u.country = :country"),
    @NamedQuery(name = "Useraccount.findByRoad", query = "SELECT u FROM Useraccount u WHERE u.road = :road"),
    @NamedQuery(name = "Useraccount.findBySuburb", query = "SELECT u FROM Useraccount u WHERE u.suburb = :suburb"),
    @NamedQuery(name = "Useraccount.findByAge", query = "SELECT u FROM Useraccount u WHERE u.age = :age"),
    @NamedQuery(name = "Useraccount.findByCell", query = "SELECT u FROM Useraccount u WHERE u.cell = :cell"),
    @NamedQuery(name = "Useraccount.findByEmail", query = "SELECT u FROM Useraccount u WHERE u.email = :email"),
    @NamedQuery(name = "Useraccount.findByHometell", query = "SELECT u FROM Useraccount u WHERE u.hometell = :hometell"),
    @NamedQuery(name = "Useraccount.findByWorktell", query = "SELECT u FROM Useraccount u WHERE u.worktell = :worktell"),
    @NamedQuery(name = "Useraccount.findByDob", query = "SELECT u FROM Useraccount u WHERE u.dob = :dob"),
    @NamedQuery(name = "Useraccount.findByFirstname", query = "SELECT u FROM Useraccount u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Useraccount.findByLastname", query = "SELECT u FROM Useraccount u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Useraccount.findByMiddlename", query = "SELECT u FROM Useraccount u WHERE u.middlename = :middlename")
})
public class Useraccount implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Long userid;
    @Basic(optional = false)
    @Column(name = "ACCOUNTPASSWORD")
    private String accountpassword;
    @Column(name = "ADDRESSLINE")
    private String addressline;
    @Column(name = "AREACODE")
    private String areacode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ROAD")
    private String road;
    @Column(name = "SUBURB")
    private String suburb;
    @Column(name = "AGE")
    private BigDecimal age;
    @Column(name = "CELL")
    private String cell;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HOMETELL")
    private String hometell;
    @Column(name = "WORKTELL")
    private String worktell;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "MIDDLENAME")
    private String middlename;

    public Useraccount()
    {
        this.userid = Long.valueOf(1);
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public String getAccountpassword()
    {
        return accountpassword;
    }

    public void setAccountpassword(String accountpassword)
    {
        this.accountpassword = accountpassword;
    }

    public String getAddressline()
    {
        return addressline;
    }

    public void setAddressline(String addressline)
    {
        this.addressline = addressline;
    }

    public String getAreacode()
    {
        return areacode;
    }

    public void setAreacode(String areacode)
    {
        this.areacode = areacode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
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

    public BigDecimal getAge()
    {
        return age;
    }

    public void setAge(BigDecimal age)
    {
        this.age = age;
    }

    public String getCell()
    {
        return cell;
    }

    public void setCell(String cell)
    {
        this.cell = cell;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getHometell()
    {
        return hometell;
    }

    public void setHometell(String hometell)
    {
        this.hometell = hometell;
    }

    public String getWorktell()
    {
        return worktell;
    }

    public void setWorktell(String worktell)
    {
        this.worktell = worktell;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getMiddlename()
    {
        return middlename;
    }

    public void setMiddlename(String middlename)
    {
        this.middlename = middlename;
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
        if (!(object instanceof Useraccount))
        {
            return false;
        }
        Useraccount other = (Useraccount) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Useraccount[ userid=" + userid + " ]";
    }

}
