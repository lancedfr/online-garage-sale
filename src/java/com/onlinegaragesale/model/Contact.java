package com.onlinegaragesale.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * File Name: Contact.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */

@Embeddable
public class Contact implements Serializable
{

    private String hometell;
    private String worktell;
    private String cell;
    private String email;

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
}
