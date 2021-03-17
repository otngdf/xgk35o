/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zgdf.ea.controller;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class GetTimestamp {
    
    public static String ts() {
        return new Timestamp(new java.util.Date().getTime()) + " Munkaido nyilvantarto esemeny: ";
}
    
}
