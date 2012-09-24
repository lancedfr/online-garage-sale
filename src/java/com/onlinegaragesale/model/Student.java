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
 * File Name: Student.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Entity
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob"),
    @NamedQuery(name = "Student.findByFirstname", query = "SELECT s FROM Student s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Student.findByLastname", query = "SELECT s FROM Student s WHERE s.lastname = :lastname"),
    @NamedQuery(name = "Student.findByStudentnumber", query = "SELECT s FROM Student s WHERE s.studentnumber = :studentnumber")
})
public class Student implements Serializable
{

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "STUDENTNUMBER")
    private String studentnumber;

    /**
     *
     */
    public Student()
    {
        this.id = BigDecimal.ONE;
    }

    /**
     *
     * @param id
     */
    public Student(BigDecimal id)
    {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public BigDecimal getId()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(BigDecimal id)
    {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Date getDob()
    {
        return dob;
    }

    /**
     *
     * @param dob
     */
    public void setDob(Date dob)
    {
        this.dob = dob;
    }

    /**
     *
     * @return
     */
    public String getFirstname()
    {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     */
    public String getLastname()
    {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getStudentNumber()
    {
        return studentnumber;
    }

    /**
     *
     * @param studentnumber
     */
    public void setStudentNumber(String studentnumber)
    {
        this.studentnumber = studentnumber;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student))
        {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.onlinegaragesale.model.Student[ id=" + id + " ]";
    }
}
