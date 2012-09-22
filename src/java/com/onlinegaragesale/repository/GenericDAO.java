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
 */
public interface GenericDAO<T extends Serializable> extends DAO<T, BigDecimal>
{

    void setClazz(final Class<T> clazzToSet);
}
