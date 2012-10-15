package com.onlinegaragesale.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * File Name: Roles.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Oct 2012
 * Edited: 15 Oct 2012
 */
@Entity 
@Table(name = "ROLES")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByRoleid", query = "SELECT r FROM Roles r WHERE r.roleid = :roleid"),
    @NamedQuery(name = "Roles.findByEmail", query = "SELECT r FROM Roles r WHERE r.email = :email"),
    @NamedQuery(name = "Roles.findByRolename", query = "SELECT r FROM Roles r WHERE r.rolename = :rolename")
})
public class Roles implements Serializable 
{
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ROLEID")
    private BigDecimal roleid;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ROLENAME")
    private String rolename;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Useraccount userid;

    public Roles()
    {
    }

    public Roles(BigDecimal roleid)
    {
        this.roleid = roleid;
    }

    public Roles(BigDecimal roleid, String email)
    {
        this.roleid = roleid;
        this.email = email;
    }

    public BigDecimal getRoleid()
    {
        return roleid;
    }

    public void setRoleid(BigDecimal roleid)
    {
        this.roleid = roleid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getRolename()
    {
        return rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
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
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles))
        {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Roles[ roleid=" + roleid + " ]";
    }

}
