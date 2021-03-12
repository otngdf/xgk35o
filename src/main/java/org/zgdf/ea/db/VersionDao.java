package org.zgdf.ea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VersionDao {

    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    //private static final String DBURL = "jdbc:mariadb://192.168.1.120:3306/appdb?user=app&password=pass";
    private static final String DBURL = "jdbc:mariadb://localhost:3306/appdb?user=app&password=xgk35o";
    
    Connection con = null;

    public String showVersion() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from version");

            String version;

            if (rs.next()) {

                version = rs.getString("version");
                return version;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return "Nincs Verzió";
    }

}
