package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * Date: 07 Oct 2012
 * Edited: 07 Oct 2012
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
    @NamedQuery(name = "Useraccount.findByEmail", query = "SELECT u FROM Useraccount u WHERE u.email = :email"),
    @NamedQuery(name = "Useraccount.findByHometell", query = "SELECT u FROM Useraccount u WHERE u.hometell = :hometell"),
    @NamedQuery(name = "Useraccount.findByWorktell", query = "SELECT u FROM Useraccount u WHERE u.worktell = :worktell"),
    @NamedQuery(name = "Useraccount.findByCell", query = "SELECT u FROM Useraccount u WHERE u.cell = :cell"),
    @NamedQuery(name = "Useraccount.findByAddressline", query = "SELECT u FROM Useraccount u WHERE u.addressline = :addressline"),
    @NamedQuery(name = "Useraccount.findByRoad", query = "SELECT u FROM Useraccount u WHERE u.road = :road"),
    @NamedQuery(name = "Useraccount.findByCity", query = "SELECT u FROM Useraccount u WHERE u.city = :city"),
    @NamedQuery(name = "Useraccount.findBySuburb", query = "SELECT u FROM Useraccount u WHERE u.suburb = :suburb"),
    @NamedQuery(name = "Useraccount.findByCountry", query = "SELECT u FROM Useraccount u WHERE u.country = :country"),
    @NamedQuery(name = "Useraccount.findByAreacode", query = "SELECT u FROM Useraccount u WHERE u.areacode = :areacode"),
    @NamedQuery(name = "Useraccount.findByAccountpassword", query = "SELECT u FROM Useraccount u WHERE u.accountpassword = :accountpassword")
})
public class Useraccount implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private BigDecimal userid;
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
    private Short age;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "HOMETELL")
    private String hometell;
    @Column(name = "WORKTELL")
    private String worktell;
    @Column(name = "CELL")
    private String cell;
    @Column(name = "ADDRESSLINE")
    private String addressline;
    @Column(name = "ROAD")
    private String road;
    @Column(name = "CITY")
    private String city;
    @Column(name = "SUBURB")
    private String suburb;
    @Basic(optional = false)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @Column(name = "AREACODE")
    private String areacode;
    @Basic(optional = false)
    @Column(name = "ACCOUNTPASSWORD")
    private String accountpassword;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "useraccount")
    private Saleshistory saleshistory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private List<Garage> garageList;

    public Useraccount()
    {
    }

    public Useraccount(BigDecimal userid)
    {
        this.userid = userid;
    }

    public Useraccount(BigDecimal userid, String firstname, String lastname, Date dob, String email, String country, String areacode, String accountpassword)
    {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.email = email;
        this.country = country;
        this.areacode = areacode;
        this.accountpassword = accountpassword;
    }

    public BigDecimal getUserid()
    {
        return userid;
    }

    public void setUserid(BigDecimal userid)
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

    public Short getAge()
    {
        return age;
    }

    public void setAge(Short age)
    {
        this.age = age;
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

    public String getCell()
    {
        return cell;
    }

    public void setCell(String cell)
    {
        this.cell = cell;
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

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getAreacode()
    {
        return areacode;
    }

    public void setAreacode(String areacode)
    {
        this.areacode = areacode;
    }

    public String getAccountpassword()
    {
        return accountpassword;
    }

    public void setAccountpassword(String accountpassword)
    {
        this.accountpassword = accountpassword;
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
