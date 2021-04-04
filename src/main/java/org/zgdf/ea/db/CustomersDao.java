package org.zgdf.ea.db;

import org.zgdf.ea.utils.GetDBDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.zgdf.ea.model.Customers;

public class CustomersDao {

    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    //private static final String DBURL = "jdbc:mariadb://192.168.1.120:3306/appdb?user=app&password=pass";
    //private static final String DBURL = "jdbc:mariadb://localhost:3306/appdb?user=app&password=xgk35o";

    GetDBDao dao = new GetDBDao();
    String DBURL;

    public CustomersDao() throws IOException {
        this.DBURL = dao.getDB();
    }

    public List<Customers> list() {
        List<Customers> listCustomers = new ArrayList<>();

        try {
            Class.forName(DRIVER);
            try (Connection con = DriverManager.getConnection(DBURL)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from customers order by name");

                while (rs.next()) {
//                    int id = rs.getInt("id");
//                    String name = rs.getString("name");
//                    int zip = rs.getInt("zip");
//                    String city = rs.getString("city");
//                    String address = rs.getString("address");
//                    
//                    Customers customer = new Customers(id, name, zip, city, address);
                    Customers customer = new Customers();

                    customer.setCustomerID(rs.getInt("id"));
                    customer.setcName(rs.getString("name"));
                    customer.setcUser(rs.getString("username"));
                    customer.setcZip(rs.getInt("zip"));
                    customer.setcCity(rs.getString("city"));
                    customer.setcAddress(rs.getString("address"));

                    listCustomers.add(customer);

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listCustomers;
    }

    public void insert(String cname, int czip, String ccity, String caddress, String cuser, String cpass) {
        try {
            Class.forName(DRIVER);
            try (Connection con = DriverManager.getConnection(DBURL)) {
                Statement st = con.createStatement();
                st.executeUpdate("insert into customers (name,zip,city,address,username,pass) values ('" + cname + "' ," + czip + ",'" + ccity + "','" + caddress + "','" + cuser + "','" + cpass + "')");

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        try {
            Class.forName(DRIVER);
            try (Connection con = DriverManager.getConnection(DBURL)) {
                Statement st = con.createStatement();
                st.executeUpdate("delete from customers where id = " + id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean hasActivity(int id) {
        try {
            Class.forName(DRIVER);
            try (Connection con = DriverManager.getConnection(DBURL)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from activities where customers_id = " + id);

                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public void modifyPassword(String suser, String newpassword) {
        try {
            Class.forName(DRIVER);
            try (Connection con = DriverManager.getConnection(DBURL)) {
                Statement st = con.createStatement();
                st.executeUpdate("update customers set pass = '" + newpassword + "' where username = '" + suser + "'");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Customers getCustomer(String u, String p) {

        Customers customer = new Customers();

        try {
            Class.forName(DRIVER);
            try (Connection con = DriverManager.getConnection(DBURL)) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from customers where username = '" + u + "' and pass = '" + p + "'");

                if (rs.next()) {
                    customer.setCustomerID(rs.getInt("id"));
                    customer.setcName(rs.getString("name"));
                    customer.setcUser(rs.getString("username"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return customer;

    }

}
