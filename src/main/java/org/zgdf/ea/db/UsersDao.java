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
     * A paraméterként megadott felhasználónév és jelszó alapján visszadja a
     * user-t, ha aktív.
     *
     * @author xgk35o
     * @param u Felhasználónév
     * @param p Jelszó
     * @return user
     *
     */
    public Users getUser(String u, String p) {

        Users user = new Users();

        try (Connection con = new GetDSDao().getCON()) {
            //Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery("select * from users where active = 1 and name = '" + u + "' and pass = '" + p + "'");

            PreparedStatement st = con.prepareStatement("select * from users where active = 1 and name = ? and pass = ?");

            st.setString(1, u);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();

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
     * Felhasználó lista.
     * <p>
     * Minden usert visszaad id alapjan rendezve.
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

    /**
     * Felhasználó létrehozás.
     * <p>
     * Felhasználó létrehozása a megadott paraméterek alapján.
     *
     * @author xgk35o
     * @param uname Felhasználónév
     * @param upass Jelszó
     * @param urole Jogosultság
     * @param ufullname Teljes név
     */
    public void insert(String uname, String upass, String urole, String ufullname) {

        try (Connection con = new GetDSDao().getCON()) {
            //Statement st = con.createStatement();
            //st.executeUpdate("insert into users (name,pass,role,fullname,active) values ('" + uname + "','" + upass + "','" + urole + "','" + ufullname + "', 1)");
        
            PreparedStatement st = con.prepareStatement("insert into users (name,pass,role,fullname,active) values ( ?, ?, ?, ?, 1)");

            st.setString(1, uname);
            st.setString(2, upass);
            st.setString(3, urole);
            st.setString(4, ufullname);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Felhasználó aktiválás/inaktiválás.
     * <p>
     * 0: inaktív, 1: aktív
     *
     * @author xgk35o
     * @param id Felhasználó azonosító id
     * @param active 1 0
     */
    public void activateInactivate(int id, int active) {

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            st.executeUpdate("update users set active = " + active + " where id = " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Felhasználó jelszó módosítás.
     * <p>
     * Új jelszó beállítása felhasználónév alapján.
     *
     * @author xgk35o
     * @param suser Felhasználónév
     * @param newpassword Új jelszó
     */
    public void modifyPassword(String suser, String newpassword) {

        try (Connection con = new GetDSDao().getCON()) {
            //Statement st = con.createStatement();
            //st.executeUpdate("update users set pass = '" + newpassword + "' where name = '" + suser + "'");

            PreparedStatement st = con.prepareStatement("update users set pass = ? where name = ?");

            st.setString(1, newpassword);
            st.setString(2, suser);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
