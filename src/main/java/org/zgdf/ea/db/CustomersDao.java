package org.zgdf.ea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.zgdf.ea.model.Customers;

public class CustomersDao {

    public List<Customers> list() {
        List<Customers> listCustomers = new ArrayList<>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.1.120:3306/appDB?user=root&password=root");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from CUSTOMERS order by Cname");

            while (rs.next()) {
                int id = rs.getInt("Cid");
                String name = rs.getString("Cname");
                int zip = rs.getInt("Czip");
                String city = rs.getString("Ccity");
                String address = rs.getString("Caddress");
                
                Customers customer = new Customers(id, name, zip, city, address);

                listCustomers.add(customer);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listCustomers;
    }

}
