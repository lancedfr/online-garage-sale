package com.onlinegaragesale.app.factories;

import com.onlinegaragesale.model.Student;
import java.util.Map;

/**
 * File Name: AppFactory.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.factories
 * Author: Lance
 * Date: 08 Sep 2012
 * Edited: 08 Sep 2012
 */
public class AppFactory
{

    public static Student createSampleStudent(Map<String, String> values)
    {
        return new Student();
    }
}
