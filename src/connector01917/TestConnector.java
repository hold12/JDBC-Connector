package connector01917;

import daointerfaces01917.DALException;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AndersWOlsen on 07-05-2017.
 */
public class TestConnector implements IConnector {
    private boolean selected = false;
    private boolean inserted = false;
    private boolean updated = false;
    private boolean deleted = false;

    public TestConnector() {}

    @Override
    public Connection connectToDatabase(String url, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ResultSet doQuery(String cmd) throws DALException {
        cmd = cmd.toLowerCase();
        if (cmd.contains("select")) {
            this.selected = true;
        }

        return Mockito.mock(ResultSet.class);
    }

    @Override
    public int doUpdate(String cmd) throws DALException {
        cmd = cmd.toLowerCase();
        if (cmd.contains("update"))
            this.updated = true;
        else if (cmd.contains("delete"))
            this.deleted = true;
        else if (cmd.contains("insert"))
            this.inserted = true;
        return 0;
    }

    public boolean isSelected() { return selected; }
    public boolean isInserted() { return inserted; }
    public boolean isUpdated() { return updated; }
    public boolean isDeleted() { return deleted; }
}
