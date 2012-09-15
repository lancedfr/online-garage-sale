package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Garage;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.GarageCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: GarageCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("garageCrudService")
@Transactional
public class GarageCrudServiceImpl implements GarageCrudService
{

    @Autowired
    private GenericDAO<Garage> dao;

    public final void setDao(final GenericDAO<Garage> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Garage.class);
    }

    public GarageCrudServiceImpl()
    {
    }

    @Override
    public Garage findById(Long id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Garage> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Garage entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Garage entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Garage entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId)
    {
        setDao(dao);
        Garage v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Garage> findInRange(int firstResult, int maxResults)
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
    public Garage getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Garage> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
