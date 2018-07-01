package org.zgdf.ea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.zgdf.ea.model.Customers;

public class CustomersDao {

    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    //rpi
//    private static final String DBURL = "jdbc:mariadb://192.168.1.120:3306/appdb?user=app&password=pass";
    //notebook
    private static final String DBURL = "jdbc:mariadb://localhost:3306/appdb?user=app&password=pass";

    public List<Customers> list() {
        List<Customers> listCustomers = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customers order by name");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int zip = rs.getInt("zip");
                String city = rs.getString("city");
                String address = rs.getString("address");

                Customers customer = new Customers(id, name, zip, city, address);

                listCustomers.add(customer);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listCustomers;
    }

    public void insert(String cname, int czip, String ccity, String caddress) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            st.executeUpdate("insert into customers (name,zip,city,address) values ('" + cname + "' ," + czip + ",'" + ccity + "','" + caddress + "')");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            st.executeUpdate("delete from customers where id = " + id);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean hasActivity(int id) {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from activities where customers_id = " + id);

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

}
