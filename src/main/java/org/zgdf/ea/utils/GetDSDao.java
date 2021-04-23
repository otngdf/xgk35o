package org.zgdf.ea.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GetDSDao {

    Context ctx;
    DataSource ds;

    public GetDSDao() throws NamingException {
        this.ctx = new InitialContext();
        //this.ds = (DataSource) ctx.lookup("java:/appDS");
        this.ds = (DataSource) ctx.lookup("java:/MunkaidoDS");
    }

    /**
     * Alkalmazasszerver adatbazis kapcsolat.
     * <p>
     * Visszaadja.
     *
     * @author xgk35o
     * @return adatbazis kapcsolat
     * @throws java.sql.SQLException
     */
    
    public Connection getCON() throws SQLException {
        return ds.getConnection();
    }
}
