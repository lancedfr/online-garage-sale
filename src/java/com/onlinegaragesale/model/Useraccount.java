package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * File Name: Useraccount.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity 
@Table(name = "USERACCOUNT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Useraccount.findAll", query = "SELECT u FROM Useraccount u"),
    @NamedQuery(name = "Useraccount.findByUserid", query = "SELECT u FROM Useraccount u WHERE u.userid = :userid"),
    @NamedQuery(name = "Useraccount.findByFirstname", query = "SELECT u FROM Useraccount u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Useraccount.findByMiddlename", query = "SELECT u FROM Useraccount u WHERE u.middlename = :middlename"),
    @NamedQuery(name = "Useraccount.findByLastname", query = "SELECT u FROM Useraccount u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Useraccount.findByDob", query = "SELECT u FROM Useraccount u WHERE u.dob = :dob"),
    @NamedQuery(name = "Useraccount.findByAge", query = "SELECT u FROM Useraccount u WHERE u.age = :age"),
    @NamedQuery(name = "Useraccount.findByPassword", query = "SELECT u FROM Useraccount u WHERE u.password = :password")
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
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "MIDDLENAME")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "AGE")
    private BigInteger age;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "useraccount")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "useraccount")
    private Saleshistory saleshistory;
    @OneToMany(mappedBy = "userid")
    private List<Garage> garageList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "useraccount")
    private Contact contact;

    public Useraccount()
    {
    }

    public Useraccount(Long userid)
    {
        this.userid = userid;
    }

    public Useraccount(Long userid, String firstname, String lastname, Date dob, String password)
    {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.password = password;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getMiddlename()
    {
        return middlename;
    }

    public void setMiddlename(String middlename)
    {
        this.middlename = middlename;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    public BigInteger getAge()
    {
        return age;
    }

    public void setAge(BigInteger age)
    {
        this.age = age;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Saleshistory getSaleshistory()
    {
        return saleshistory;
    }

    public void setSaleshistory(Saleshistory saleshistory)
    {
        this.saleshistory = saleshistory;
    }

    @XmlTransient
    @JsonIgnore
    public List<Garage> getGarageList()
    {
        return garageList;
    }

    public void setGarageList(List<Garage> garageList)
    {
        this.garageList = garageList;
    }

    public Contact getContact()
    {
        return contact;
    }

    public void setContact(Contact contact)
    {
        this.contact = contact;
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
