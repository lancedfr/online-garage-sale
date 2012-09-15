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
 * File Name: Contact.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity 
@Table(name = "CONTACT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByUserid", query = "SELECT c FROM Contact c WHERE c.userid = :userid"),
    @NamedQuery(name = "Contact.findByHometell", query = "SELECT c FROM Contact c WHERE c.hometell = :hometell"),
    @NamedQuery(name = "Contact.findByWorktell", query = "SELECT c FROM Contact c WHERE c.worktell = :worktell"),
    @NamedQuery(name = "Contact.findByCell", query = "SELECT c FROM Contact c WHERE c.cell = :cell"),
    @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email")
})
public class Contact implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERID")
    private Long userid;
    @Column(name = "HOMETELL")
    private String hometell;
    @Column(name = "WORKTELL")
    private String worktell;
    @Column(name = "CELL")
    private String cell;
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Useraccount useraccount;

    public Contact()
    {
    }

    public Contact(Long userid)
    {
        this.userid = userid;
    }

    public Long getUserid()
    {
        return userid;
    }

    public void setUserid(Long userid)
    {
        this.userid = userid;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
        if (!(object instanceof Contact))
        {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Contact[ userid=" + userid + " ]";
    }

}
