package org.zgdf.ea.db;

import org.zgdf.ea.model.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    public Users getUser(String u, String p) {

        Users user = new Users();
//        user.setUserName("semmi");
//        user.setPassword("ezis");

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.1.120:3306/appDB?user=root&password=root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from USERS where Uname = '" + u + "' and Upass = '" + p + "'");

            if (rs.next()) {
                user.setUserID(rs.getInt("Uid"));
                user.setUserName(rs.getString("Uname"));
                user.setUserRole(rs.getString("Urole"));
                user.setFullName(rs.getString("Fullname"));
//                System.out.println("a user: " + rs.getString("user"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return user;

    }

    public List<Users> list() {
        List<Users> listUsers = new ArrayList<>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.1.120:3306/appDB?user=root&password=root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from USERS order by Uid");

            while (rs.next()) {
                Users user = new Users();
                user.setUserID(rs.getInt("Uid"));
                user.setUserName(rs.getString("Uname"));
                user.setUserRole(rs.getString("Urole"));
                user.setFullName(rs.getString("Fullname"));

                listUsers.add(user);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listUsers;
    }

}
