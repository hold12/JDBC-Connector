package connector01917;

import daointerfaces01917.DALException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AndersWOlsen on 29-05-2017.
 */
public class DBConnector implements IConnector {
    @Override
    public Connection connectToDatabase(String url, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ResultSet query(String cmd) throws DALException {
        return null;
    }

    @Override
    public int update(String cmd) throws DALException {
        return 0;
    }

    @Override
    public void close() {

    }
}
