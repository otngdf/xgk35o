package org.zgdf.ea.db;

import org.zgdf.ea.model.Users;
import java.sql.*;

public class UsersDao {

    public Users getUser(String u, String p) {

        Users user = new Users();
//        user.setUserName("semmi");
//        user.setPassword("ezis");

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.1.120:3306/appDB?user=root&password=root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from USERS where User = '" + u + "' and Password = '" + p + "'");

            if (rs.next()) {
                user.setUserName(rs.getString("User"));
                user.setPassword(rs.getString("Password"));
//                System.out.println("a user: " + rs.getString("user"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return user;

    }

}
