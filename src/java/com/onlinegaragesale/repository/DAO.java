package com.onlinegaragesale.repository;

import java.util.List;

/**
 * File Name: DAO.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.repository
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public interface DAO<T, ID>
{

    public T findById(final ID id);

    public List< T> findAll();

    public void persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeById(final Long entityId);

    public List<T> findInRange(int firstResult, int maxResults);

    public long count();

    public T getByPropertyName(String name, String value);

    public List<T> getEntitiesByProperName(String name, String value);
}
