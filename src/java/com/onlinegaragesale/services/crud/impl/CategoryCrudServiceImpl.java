package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Category;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.CategoryCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: CategoryCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("categoryCrudService")
@Transactional
public class CategoryCrudServiceImpl implements CategoryCrudService
{

    @Autowired
    private GenericDAO<Category> dao;

    public final void setDao(final GenericDAO<Category> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Category.class);
    }

    public CategoryCrudServiceImpl()
    {
    }

    @Override
    public Category findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Category> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Category entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Category entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Category entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Category v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Category> findInRange(int firstResult, int maxResults)
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
    public Category getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Category> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
