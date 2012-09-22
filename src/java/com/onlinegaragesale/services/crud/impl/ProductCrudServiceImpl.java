package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Product;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.ProductCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: ProductCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("productCrudService")
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService
{

    @Autowired
    private GenericDAO<Product> dao;

    public final void setDao(final GenericDAO<Product> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Product.class);
    }

    public ProductCrudServiceImpl()
    {
    }

    @Override
    public Product findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Product> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Product entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Product entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Product entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Product v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Product> findInRange(int firstResult, int maxResults)
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
    public Product getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Product> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
