package org.zgdf.ea.db;

import org.zgdf.ea.model.Users;
import java.sql.*;

public class UsersDao {

    public Users getUser(String u, String p) {

        Users user = new Users();
//        user.setUserName("semmi");
//        user.setPassword("ezis");

            try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = DriverManager.getConnection("jdbc:derby:appDB;create=true","","");
            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from app.users where user = '" + u + "' and password = '" + p + "'");
            ResultSet rs = st.executeQuery("select * from app.users");
            if(rs.next()){
//                user.setUserName(rs.getString("user"));
//                user.setPassword(rs.getString("password"));
                System.out.println("a user: " + rs.getString("user"));
            }
            con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }


        return user;

    }

}
