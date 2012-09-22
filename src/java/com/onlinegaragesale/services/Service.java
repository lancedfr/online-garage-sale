package com.onlinegaragesale.services;

import java.util.List;

/**
 * File Name: Service.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.services
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public interface Service<T, ID>
{

    public T findById(final ID id);

    public List<T> findAll();

    public void persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeById(final ID entityId);

    public List<T> findInRange(int firstResult, int maxResults);

    public long count();

    public T getByPropertyName(String name, String value);

    public List<T> getEntitiesByProperName(String name, String value);
}
