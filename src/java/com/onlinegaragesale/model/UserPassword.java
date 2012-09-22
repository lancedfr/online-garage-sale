package com.onlinegaragesale.model;

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
public class UserPassword
{

    private String userPassword;

    public String getUserPassword()
    {
        return userPassword;
    }

    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }
}
