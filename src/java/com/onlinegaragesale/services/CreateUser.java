package com.onlinegaragesale.services;

import com.onlinegaragesale.model.Useraccount;
import java.util.HashMap;

/**
 * File Name: CreateUser.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 07 Oct 2012
 * Edited: 07 Oct 2012
 */
public interface CreateUser
{

    public void createNewUser(HashMap<String, Object> values);

    public void createNewUser(Useraccount createUserAccount);
}
