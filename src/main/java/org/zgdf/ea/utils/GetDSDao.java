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
        this.ds = (DataSource) ctx.lookup("java:/MunkaidoDB");

    }

    public Connection getCON() throws SQLException {
        return ds.getConnection();
    }

}
