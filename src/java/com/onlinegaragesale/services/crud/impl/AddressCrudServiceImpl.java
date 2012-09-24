package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Address;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.AddressCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: AddressCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("addressCrudService")
@Transactional
public class AddressCrudServiceImpl implements AddressCrudService
{

    @Autowired
    private GenericDAO<Address> dao;

    /**
     *
     * @param daoToSet
     */
    public final void setDao(final GenericDAO<Address> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Address.class);
    }

    /**
     *
     */
    public AddressCrudServiceImpl()
    {
    }

    @Override
    public Address findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Address> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Address entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Address entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Address entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Address v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Address> findInRange(int firstResult, int maxResults)
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
    public Address getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Address> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
