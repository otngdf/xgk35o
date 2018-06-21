package org.zgdf.ea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.zgdf.ea.model.Activities;

public class ActivitiesDao {

    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    //rpi
    private static final String DBURL = "jdbc:mariadb://192.168.1.120:3306/appdb?user=root&password=root";
    //notebook
//    private static final String DBURL = "jdbc:mariadb://localhost:3306/appdb?user=root&password=root";

    public void insert(int uid, int cid, String date, String comment) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            st.executeUpdate("insert into activities (users_id,customers_id,start,comment) values (" + uid + "," + cid + ",'" + date + "','" + comment + "')");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStop(int uid, String date) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            st.executeUpdate("update activities set stop = '" + date + "' where stop is null and users_id = " + uid);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Activities> list() {
        List<Activities> listActivities = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id, u.name, c.name, a.start, a.stop, a.comment from activities a, users u, customers c\n"
                    + "where a.users_id = u.id\n"
                    + "and a.customers_id = c.id\n"
                    + "order by a.id desc");

            while (rs.next()) {

                Activities activity = new Activities();

                activity.setActivityID(rs.getInt("a.id"));
                activity.setuName(rs.getString("u.name"));
                activity.setcName(rs.getString("c.name"));
                activity.setStart(rs.getString("a.start"));
                activity.setStop(rs.getString("a.stop"));
                activity.setComment(rs.getString("a.comment"));

                listActivities.add(activity);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listActivities;
    }

    public boolean hasNoEnd(int uid) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from activities where users_id = " + uid + " and stop is null");

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public List<Activities> listWhatHasNoEnd(int uid) {
        List<Activities> listActivities = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select c.name, a.start, a.comment from activities a, customers c\n"
                    + "where a.users_id = " + uid + " and a.customers_id = c.id and a.stop is null");

            while (rs.next()) {

                Activities activity = new Activities();

                activity.setcName(rs.getString("c.name"));
                activity.setStart(rs.getString("a.start"));
                activity.setComment(rs.getString("a.comment"));

                listActivities.add(activity);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listActivities;
    }

}
