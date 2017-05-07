package daoimpl01917;

import connector01917.Connector;
import connector01917.IConnector;
import connector01917.TestConnector;
import daointerfaces01917.DALException;
import dto01917.OperatorDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by AndersWOlsen on 05-05-2017.
 */
public class MySQLOperatorDAOTest {
    private IConnector connector;
    private MySQLOperatorDAO operatorDAO;
    private final OperatorDTO testOperator = new OperatorDTO(1, "John", "Doe", "JD", "010190-1234", "p455w0rd!", false);
    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        operatorDAO = new MySQLOperatorDAO(connector);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getOperator() throws Exception {
        OperatorDTO opExpected = testOperator;
        OperatorDTO opActual = operatorDAO.getOperator(1);

        assertTrue(((TestConnector) connector).isSelected());

        assertTrue(opExpected.equals(opActual));
    }

    @Test
    public void createOperator() throws Exception {
        operatorDAO.createOperator(testOperator);

        assertTrue(((TestConnector) connector).isInserted());
    }

    @Test
    public void updateOperator() throws Exception {
        OperatorDTO opNew = new OperatorDTO(1, "Jane", "Doe", "JD", "010190-1234", "p455w0rd!", false);

        opNew.setOperatorFirstname("Jane");
        operatorDAO.updateOperator(opNew);

        assertTrue(((TestConnector) connector).isUpdated());
    }

    @Test
    public void deleteOperator() throws Exception {
        operatorDAO.deleteOperator(testOperator);
        assertTrue(((TestConnector) connector).isDeleted());
    }

}