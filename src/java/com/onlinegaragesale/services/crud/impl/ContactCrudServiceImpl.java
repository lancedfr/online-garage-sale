package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Contact;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.ContactCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: ContactCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("contactCrudService")
@Transactional
public class ContactCrudServiceImpl implements ContactCrudService
{

    @Autowired
    private GenericDAO<Contact> dao;

    public final void setDao(final GenericDAO<Contact> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Contact.class);
    }

    public ContactCrudServiceImpl()
    {
    }

    @Override
    public Contact findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Contact> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Contact entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Contact entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Contact entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Contact v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Contact> findInRange(int firstResult, int maxResults)
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
    public Contact getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Contact> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
