package com.onlinegaragesale.services.impl;

import com.onlinegaragesale.app.facade.Facade;
import com.onlinegaragesale.app.factories.AppFactory;
import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.model.Roles;
import com.onlinegaragesale.model.Saleshistory;
import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.services.CreateUser;
import com.onlinegaragesale.services.ObjectId;
import com.onlinegaragesale.services.crud.GarageCrudService;
import com.onlinegaragesale.services.crud.RolesCrudService;
import com.onlinegaragesale.services.crud.SaleshistoryCrudService;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.util.HashMap;
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
    @Autowired
    private GarageCrudService garageCrudService;
    @Autowired
    private SaleshistoryCrudService saleshistoryCrudService;
    @Autowired
    private RolesCrudService rolesCrudService;

    @Override
    public void createNewUser(HashMap<String, Object> values)
    {
        Useraccount createdUser = createUser(values);
        createGarage(createdUser);
        createSalesHistory(createdUser);
        createUserRole(createdUser);
    }

    @Override
    public void createNewUser(Useraccount createdUser)
    {
        useraccountCrudService.persist(createdUser);
        createGarage(createdUser);
        createSalesHistory(createdUser);
        createUserRole(createdUser);
    }

    private Useraccount createUser(HashMap<String, Object> values)
    {
        Useraccount useraccount = AppFactory.createUserAccount(values);
        useraccountCrudService.persist(useraccount);
        return useraccount;
    }

    private void createGarage(Useraccount createdUser)
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("userId", createdUser);
        Garage garage = AppFactory.createGarage(values);

        garageCrudService.persist(garage);
    }

    private void createSalesHistory(Useraccount createdUser)
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("Useraccount", createdUser);
        Saleshistory createSalesHistory = AppFactory.createSalesHistory(values);

        saleshistoryCrudService.persist(createSalesHistory);
    }

    private void createUserRole(Useraccount createdUser)
    {
        HashMap<String, Object> values = new HashMap<String, Object>();
        values.put("roleid", ObjectId.getNewRolesId());
        values.put("email", createdUser.getEmail());
        values.put("rolename", "user");
        values.put("userid", createdUser);
        Roles createRole = AppFactory.createRole(values);

        rolesCrudService.persist(createRole);
    }
}
