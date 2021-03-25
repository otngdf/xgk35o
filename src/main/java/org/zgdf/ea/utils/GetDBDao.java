/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zgdf.ea.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author User
 */
public class GetDBDao {
    public String getDB() throws FileNotFoundException, IOException {
        try {
            FileInputStream fis = new FileInputStream("/opt/conf/db.properties");
            //FileInputStream fis = new FileInputStream("/volume1/Tomcat/db.properties");
            //FileInputStream fis = new FileInputStream("c:\\Users\\User\\Documents\\NetBeansProjects\\xgk35o\\db.properties");            
            Properties prop = new Properties();            
            prop.load(fis);
            //String DRIVER = (String) prop.get ("DriverName"); 
            String DBURL = (String) prop.get("URL");
            return DBURL;
        } catch (IOException iOException) {
            {System.out.println(iOException);
        }
        }
        return null;
    }
}