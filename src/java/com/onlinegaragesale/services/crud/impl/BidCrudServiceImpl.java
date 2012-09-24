package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Bid;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.BidCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: BidCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("bidCrudService")
@Transactional
public class BidCrudServiceImpl implements BidCrudService
{

    @Autowired
    private GenericDAO<Bid> dao;

    /**
     *
     * @param daoToSet
     */
    public final void setDao(final GenericDAO<Bid> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Bid.class);
    }

    /**
     *
     */
    public BidCrudServiceImpl()
    {
    }

    @Override
    public Bid findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Bid> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Bid entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Bid entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Bid entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Bid v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Bid> findInRange(int firstResult, int maxResults)
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
    public Bid getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Bid> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
