package com.onlinegaragesale.app.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File Name: PasswordEncrypt.java
 * Version: 1.0
 * Description:
 * Package: com.onlinegaragesale.app.security
 * Author: Lance
 * Date: 14 Oct 2012
 * Edited: 14 Oct 2012
 */
public class PasswordEncrypt
{

    public static String encrypt(String freeText)
    {
        StringBuilder stringBuffer = new StringBuilder();
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5", "SUN");
            byte bs[] = freeText.getBytes();
            byte digest[] = messageDigest.digest(bs);
            for (int i = 0; i < digest.length; i++)
            {
                stringBuffer.append(Integer.toHexString(0x0100+(digest[i] & 0x00FF)).substring(1));
            }
        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(PasswordEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (NoSuchProviderException ex)
        {
            Logger.getLogger(PasswordEncrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringBuffer.toString();
    }
}
