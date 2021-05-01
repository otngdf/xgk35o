package org.zgdf.ea.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.zgdf.ea.model.Activities;
import org.zgdf.ea.utils.GetDSDao;

public class ActivitiesDao {

    public void insert(int uid, int cid, String date, String comment) {

        try (Connection con = new GetDSDao().getCON()) {
            //Statement st = con.createStatement();
            //st.executeUpdate("insert into activities (users_id,customers_id,start,comment) values (" + uid + "," + cid + ",'" + date + "','" + comment + "')");

            PreparedStatement st = con.prepareStatement("insert into activities (users_id,customers_id,start,comment) values ( ? , ?, ?, ?)");

            st.setInt(1, uid);
            st.setInt(2, cid);
            st.setString(3, date);
            st.setString(4, comment);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStop(int uid, String date) {

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            st.executeUpdate("update activities set stop = '" + date + "' where stop is null and users_id = " + uid);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Activities> list() {
        List<Activities> listActivities = new ArrayList<>();

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id, u.name, c.name, a.start, a.stop, a.comment from activities a, users u, customers c\n"
                    + "where a.users_id = u.id\n"
                    + "and a.customers_id = c.id\n"
                    + "and a.stop is null\n"
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

    public List<Activities> list(int uid) {
        List<Activities> listActivities = new ArrayList<>();

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id, u.name, c.name, a.start, a.stop, a.comment from activities a, users u, customers c\n"
                    + "where u.id = " + uid + "\n"
                    + "and a.users_id = u.id\n"
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

    public List<Activities> listDone() {
        List<Activities> listActivities = new ArrayList<>();

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id, u.name, c.name, a.start, a.stop, a.comment from activities a, users u, customers c\n"
                    + "where a.users_id = u.id\n"
                    + "and a.customers_id = c.id\n"
                    + "and a.stop is not null\n"
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

        try (Connection con = new GetDSDao().getCON()) {
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

        try (Connection con = new GetDSDao().getCON()) {
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

    public List<Activities> list(int cid, String cuser) {
        List<Activities> listActivities = new ArrayList<>();

        try (Connection con = new GetDSDao().getCON()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id, u.name, c.name, a.start, a.stop, a.comment from activities a, users u, customers c\n"
                    + "where c.id = " + cid + "\n"
                    + "and a.users_id = u.id\n"
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

}
