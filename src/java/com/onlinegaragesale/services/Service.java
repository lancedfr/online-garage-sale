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
 *
 * @param <T>
 * @param <ID>
 */
public interface Service<T, ID>
{

    /**
     * Finds the object represented by the id
     *
     * @param id to search by
     * @return the object represented by the id
     */
    public T findById(final ID id);

    /**
     * Finds all of type T
     *
     * @return List<T>
     */
    public List<T> findAll();

    /**
     * Persist entity of type T
     *
     * @param entity
     */
    public void persist(final T entity);

    /**
     * Merge entity of type T
     *
     * @param entity
     */
    public void merge(final T entity);

    /**
     * Remove entity of type T
     *
     * @param entity
     */
    public void remove(final T entity);

    /**
     * Remove entity by id
     *
     * @param entityId
     */
    public void removeById(final ID entityId);

    /**
     * Find entity of type T within provided range
     *
     * @param firstResult
     * @param maxResults
     * @return
     */
    public List<T> findInRange(int firstResult, int maxResults);

    /**
     *
     * @return long count
     */
    public long count();

    /**
     * Find entity of type T by property ie column
     *
     * @param name
     * @param value
     * @return
     */
    public T getByPropertyName(String name, String value);

    /**
     * Find entities of type T by property ie column
     *
     * @param name
     * @param value
     * @return
     */
    public List<T> getEntitiesByProperName(String name, String value);
}
