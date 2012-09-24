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

    /**
     *
     * @return
     */
    public String getHometell()
    {
        return hometell;
    }

    /**
     *
     * @param hometell
     */
    public void setHometell(String hometell)
    {
        this.hometell = hometell;
    }

    /**
     *
     * @return
     */
    public String getWorktell()
    {
        return worktell;
    }

    /**
     *
     * @param worktell
     */
    public void setWorktell(String worktell)
    {
        this.worktell = worktell;
    }

    /**
     *
     * @return
     */
    public String getCell()
    {
        return cell;
    }

    /**
     *
     * @param cell
     */
    public void setCell(String cell)
    {
        this.cell = cell;
    }

    /**
     *
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
}
