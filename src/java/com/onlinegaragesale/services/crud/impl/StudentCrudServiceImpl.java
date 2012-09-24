package com.onlinegaragesale.services.crud.impl;

import com.onlinegaragesale.model.Student;
import com.onlinegaragesale.repository.GenericDAO;
import com.onlinegaragesale.services.crud.StudentCrudService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * File Name: StudentCrudServiceImpl.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services.crud.impl
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
@Service("studentCrudService")
@Transactional
public class StudentCrudServiceImpl implements StudentCrudService
{

    @Autowired
    private GenericDAO<Student> dao;

    /**
     *
     * @param daoToSet
     */
    public final void setDao(final GenericDAO<Student> daoToSet)
    {
        this.dao = daoToSet;
        this.dao.setClazz(Student.class);
    }

    /**
     *
     */
    public StudentCrudServiceImpl()
    {
    }

    @Override
    public Student findById(BigDecimal id)
    {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Student> findAll()
    {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Student entity)
    {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Student entity)
    {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Student entity)
    {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(BigDecimal entityId)
    {
        setDao(dao);
        Student v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Student> findInRange(int firstResult, int maxResults)
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
    public Student getByPropertyName(String name, String value)
    {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Student> getEntitiesByProperName(String name, String value)
    {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
