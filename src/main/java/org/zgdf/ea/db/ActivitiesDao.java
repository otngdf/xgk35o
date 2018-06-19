package org.zgdf.ea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ActivitiesDao {

    public void insert(int uid, int cid, String date, String comment) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.1.120:3306/appDB?user=root&password=root");
            
            Statement st = con.createStatement();
            st.executeUpdate("insert into ACTIVITIES (Uid,Cid,Start,Comment) values (" + uid + "," + cid + ",'" + date + "','" + comment + "')");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
