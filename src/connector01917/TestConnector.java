package connector01917;

import daointerfaces01917.DALException;
import dto01917.OperatorDTO;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.auto.Mock;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AndersWOlsen on 07-05-2017.
 */
public class TestConnector implements IConnector {
    private boolean selected;
    private boolean inserted;
    private boolean updated;
    private boolean deleted;

    private final Mockery mockery = new Mockery();
    private final ResultSet resultSet = mockery.mock(ResultSet.class);

    public TestConnector() throws SQLException{
        this.selected = false;
        this.inserted = false;
        this.updated = false;
        this.deleted = false;

        mockery.checking(new Expectations() {{
            allowing(resultSet).first(); will(returnValue(true));
        }});
    }

    @Override
    public Connection connectToDatabase(String url, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ResultSet doQuery(String cmd) throws DALException {
        cmd = cmd.toLowerCase();
        if (cmd.contains("select")) {
            this.selected = true;

            if (cmd.contains("operator")) {
                // Insert an operator in the ResultSet
                OperatorDTO operator = new OperatorDTO(1, "John", "Doe", "JD", "010190-1234", "p455w0rd!", false);
                insertOperatorResultSet(operator);
            }
        }

//        return Mockito.mock(ResultSet.class);


        return resultSet;
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

    private void insertOperatorResultSet(OperatorDTO operator) throws DALException {
        try {
            mockery.checking(new Expectations() {{
                allowing(resultSet).getInt("operator_id"); will(returnValue(operator.getOperatorId()));
                allowing(resultSet).getString("operator_firstname"); will(returnValue(operator.getOperatorFirstname()));
                allowing(resultSet).getString("operator_lastname"); will(returnValue(operator.getOperatorLastname()));
                allowing(resultSet).getString("initials"); will(returnValue(operator.getInitials()));
                allowing(resultSet).getString("cpr"); will(returnValue(operator.getCpr()));
                allowing(resultSet).getString("password"); will(returnValue(operator.getPassword()));
                allowing(resultSet).getBoolean("is_active"); will(returnValue(operator.isActive()));
            }});
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    public boolean isSelected() { return selected; }
    public boolean isInserted() { return inserted; }
    public boolean isUpdated() { return updated; }
    public boolean isDeleted() { return deleted; }
}
