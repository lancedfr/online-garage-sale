package com.onlinegaragesale.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * File Name: UserPassword.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 22 Sep 2012
 * Edited: 22 Sep 2012
 */
@Embeddable
public class UserPassword implements Serializable
{

    private String userPassword;

    /**
     *
     * @return
     */
    public String getUserPassword()
    {
        return userPassword;
    }

    /**
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
}
