package com.onlinegaragesale.services.impl;

import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.CreateUser;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * File Name: CreateUserImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.impl
 * Author: Lance
 * Date: 07 Oct 2012
 * Edited: 07 Oct 2012
 */
@Service("createUser")
public class CreateUserImpl implements CreateUser
{
    @Autowired
    private UseraccountCrudService useraccountCrudService;

    @Override
    public void createNewUser(Useraccount useraccount)
    {
        
    }
}
