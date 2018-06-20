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
    private static final String DBURL = "jdbc:mariadb://192.168.1.120:3306/appdb?user=root&password=root";

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

}
