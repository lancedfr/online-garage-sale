package com.onlinegaragesale.repository;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * File Name: GenericDAO.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.repository
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 *
 * @param <T>
 */
public interface GenericDAO<T extends Serializable> extends DAO<T, BigDecimal>
{

    /**
     *
     * @param clazzToSet
     */
    void setClazz(final Class<T> clazzToSet);
}
