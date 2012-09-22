package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Saleshistory;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.SaleshistoryCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: SaleshistoryCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("saleshistoryCrudService")
@Transactional
public class SaleshistoryCrudServiceImpl implements SaleshistoryCrudService
{

    @Autowired
    private GenericDAO<Saleshistory> dao;

    public final void setDao(final GenericDAO<Saleshistory> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Saleshistory.class);
    }

    public SaleshistoryCrudServiceImpl()
    {
    }

    @Override
    public Saleshistory findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Saleshistory> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Saleshistory entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Saleshistory entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Saleshistory entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Saleshistory v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Saleshistory> findInRange(int firstResult, int maxResults)
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
    public Saleshistory getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Saleshistory> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
