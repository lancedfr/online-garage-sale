package com.onlinegaragesale.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * File Name: Student.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Entity
public class Student implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentNumber;
    @Embedded
    private Name name;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;

    public Student()
    {
    }

    public Student(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStudentNumber()
    {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    public Name getName()
    {
        return name;
    }

    public void setName(Name name)
    {
        this.name = name;
    }

    public Date getDob()
    {
        return dob;
    }

    public void setDob(Date dob)
    {
        this.dob = dob;
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
        return "Student{" + "id=" + id + ", studentNumber=" + studentNumber + ", name=" + name + ", dob=" + dob + '}';
    }
}
