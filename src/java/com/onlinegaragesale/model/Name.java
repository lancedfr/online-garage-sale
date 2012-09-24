package com.onlinegaragesale.model;

import java.io.Serializable;
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
public class Name implements Serializable
{

    private String fName;
    private String nName;
    private String lName;

    /**
     *
     * @return
     */
    public String getfName()
    {
        return fName;
    }

    /**
     *
     * @param fName
     */
    public void setfName(String fName)
    {
        this.fName = fName;
    }

    /**
     *
     * @return
     */
    public String getnName()
    {
        return nName;
    }

    /**
     *
     * @param nName
     */
    public void setnName(String nName)
    {
        this.nName = nName;
    }

    /**
     *
     * @return
     */
    public String getlName()
    {
        return lName;
    }

    /**
     *
     * @param lName
     */
    public void setlName(String lName)
    {
        this.lName = lName;
    }
}
