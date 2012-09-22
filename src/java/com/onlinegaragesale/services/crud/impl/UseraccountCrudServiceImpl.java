package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Useraccount;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.UseraccountCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: UseraccountCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("useraccountCrudService") 
@Transactional
public class UseraccountCrudServiceImpl implements UseraccountCrudService
{

    @Autowired
    private GenericDAO<Useraccount> dao;

    public final void setDao(final GenericDAO<Useraccount> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Useraccount.class);
    }

    public UseraccountCrudServiceImpl()
    {
    }

    @Override
    public Useraccount findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Useraccount> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Useraccount entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Useraccount entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Useraccount entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Useraccount v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Useraccount> findInRange(int firstResult, int maxResults)
    {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }

    @Override
    public long count()
    {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Useraccount getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Useraccount> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
