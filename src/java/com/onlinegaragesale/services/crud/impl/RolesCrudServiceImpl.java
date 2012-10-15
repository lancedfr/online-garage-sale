package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Roles;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.RolesCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: RolesCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 15 Oct 2012
 * Edited: 15 Oct 2012
 */
@Service("rolesCrudService")
@Transactional
public class RolesCrudServiceImpl implements RolesCrudService
{

    @Autowired
    private GenericDAO<Roles> dao;

    /**
     *
     * @param daoToSet
     */
    public final void setDao(final GenericDAO<Roles> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Roles.class);
    }

    /**
     *
     */
    public RolesCrudServiceImpl()
    {
    }

    @Override
    public Roles findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Roles> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Roles entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Roles entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Roles entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Roles v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Roles> findInRange(int firstResult, int maxResults)
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
    public Roles getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Roles> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
