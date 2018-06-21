package org.zgdf.ea.db;

import org.zgdf.ea.model.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    //rpi
    private static final String DBURL = "jdbc:mariadb://192.168.1.120:3306/appdb?user=root&password=root";
    //notebook
//    private static final String DBURL = "jdbc:mariadb://localhost:3306/appdb?user=root&password=root";

    public Users getUser(String u, String p) {

        Users user = new Users();
//        user.setUserName("semmi");
//        user.setPassword("ezis");

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where active = 1 and name = '" + u + "' and pass = '" + p + "'");

            if (rs.next()) {
                user.setUserID(rs.getInt("id"));
                user.setUserName(rs.getString("name"));
                user.setUserRole(rs.getString("role"));
                user.setFullName(rs.getString("fullname"));
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
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users order by id");

            while (rs.next()) {
                Users user = new Users();
                user.setUserID(rs.getInt("id"));
                user.setUserName(rs.getString("name"));
                user.setUserRole(rs.getString("role"));
                user.setActive(rs.getInt("active"));
                user.setFullName(rs.getString("fullname"));

                listUsers.add(user);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listUsers;
    }
    
    public void insert(String uname, String upass, String urole, String ufullname) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            st.executeUpdate("insert into users (name,pass,role,fullname,active) values ('" + uname + "' ,'" + upass + "','" + urole + "','" + ufullname + "', 1)");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void activateInactivate(int id, int active) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            st.executeUpdate("update users set active = " + active + " where id = " + id);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
