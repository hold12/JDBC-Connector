package connector01917;

import daointerfaces01917.DALException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AndersWOlsen on 07-05-2017.
 */
public interface IConnector {
    Connection connectToDatabase() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
    ResultSet query(String cmd) throws DALException;
    int update(String cmd) throws DALException;
    void close() throws DALException;
}
