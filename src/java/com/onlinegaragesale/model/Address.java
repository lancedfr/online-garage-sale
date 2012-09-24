package com.onlinegaragesale.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * File Name: Address.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.model
 * Author: Lance
 * Date: 15 Sep 2012
 * Edited: 15 Sep 2012
 */
@Embeddable
public class Address implements Serializable
{

    private String addressline;
    private String road;
    private String suburb;
    private String city;
    private String areacode;
    private String country;

    /**
     *
     * @return addressline
     */
    public String getAddressline()
    {
        return addressline;
    }

    /**
     *
     * @param addressline
     */
    public void setAddressline(String addressline)
    {
        this.addressline = addressline;
    }

    /**
     *
     * @return road
     */
    public String getRoad()
    {
        return road;
    }

    /**
     *
     * @param road
     */
    public void setRoad(String road)
    {
        this.road = road;
    }

    /**
     *
     * @return suburb
     */
    public String getSuburb()
    {
        return suburb;
    }

    /**
     *
     * @param suburb
     */
    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    /**
     *
     * @return city
     */
    public String getCity()
    {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     *
     * @return areacode
     */
    public String getAreacode()
    {
        return areacode;
    }

    /**
     *
     * @param areacode
     */
    public void setAreacode(String areacode)
    {
        this.areacode = areacode;
    }

    /**
     *
     * @return country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country)
    {
        this.country = country;
    }
}
