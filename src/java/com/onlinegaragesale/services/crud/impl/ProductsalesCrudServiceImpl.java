package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Productsales;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.ProductsalesCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: ProductsalesCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("productsalesCrudService")
@Transactional
public class ProductsalesCrudServiceImpl implements ProductsalesCrudService
{

    @Autowired
    private GenericDAO<Productsales> dao;

    /**
     *
     * @param daoToSet
     */
    public final void setDao(final GenericDAO<Productsales> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Productsales.class);
    }

    /**
     *
     */
    public ProductsalesCrudServiceImpl()
    {
    }

    @Override
    public Productsales findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Productsales> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Productsales entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Productsales entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Productsales entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Productsales v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Productsales> findInRange(int firstResult, int maxResults)
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
    public Productsales getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Productsales> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
