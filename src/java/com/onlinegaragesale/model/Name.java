package com.onlinegaragesale.model;

import javax.persistence.Embeddable;

/**
 * File Name: Name.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
@Embeddable
public class Name
{

    private String fName;
    private String nName;
    private String lName;

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getnName()
    {
        return nName;
    }

    public void setnName(String nName)
    {
        this.nName = nName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }
}
