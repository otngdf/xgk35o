package org.zgdf.ea.db;

import org.zgdf.ea.model.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.zgdf.ea.utils.GetDSDao;
import org.zgdf.ea.utils.GetLogMessage;

public class UsersDao {

    /**
     * User lekerdezes.
     * <p>
     * Visszaadja a usert.
     *
     * @author xgk35o
     * @param u
     * @param p
     * @return user
     *
     */
    public Users getUser(String u, String p) {

        Users user = new Users();

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where active = 1 and name = '" + u + "' and pass = '" + p + "'");

            if (rs.next()) {
                user.setUserID(rs.getInt("id"));
                user.setUserName(rs.getString("name"));
                user.setUserRole(rs.getString("role"));
                user.setFullName(rs.getString("fullname"));
//                System.out.println("a user: " + rs.getString("user"));
            }
        } catch (Exception e) {
            System.out.println(GetLogMessage.message() + "Adatbazis muvelet sikertelen: " + e);
        }
        return user;
    }

    /**
     * Minden usert visszaad id alapjan rendezve.
     * <p>
     * Visszaadja.
     *
     * @author xgk35o
     * @return minden user
     */
    public List<Users> list() {
        List<Users> listUsers = new ArrayList<>();

        try (Connection con = new GetDSDao().getCON()) {
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

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            st.executeUpdate("insert into users (name,pass,role,fullname,active) values ('" + uname + "','" + upass + "','" + urole + "','" + ufullname + "', 1)");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void activateInactivate(int id, int active) {

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            st.executeUpdate("update users set active = " + active + " where id = " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modifyPassword(String suser, String newpassword) {

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            st.executeUpdate("update users set pass = '" + newpassword + "' where name = '" + suser + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
