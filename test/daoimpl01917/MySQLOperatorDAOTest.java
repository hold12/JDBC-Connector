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

import static org.junit.Assert.*;

/**
 * Created by AndersWOlsen on 05-05-2017.
 */
public class MySQLOperatorDAOTest {
    private IConnector connector;
    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getOperator() throws Exception {
        MySQLOperatorDAO operatorDAO = new MySQLOperatorDAO(connector);
        OperatorDTO opExpected = new OperatorDTO(1, "John", "Doe", "JD", "010190-1234", "p455w0rd!", false);
        OperatorDTO opActual = operatorDAO.getOperator(1);

        assertTrue(((TestConnector) connector).isSelected());

        System.out.println(opExpected.toString());
        System.out.println(opActual.toString());

        assertTrue(opExpected.equals(opActual));
    }

    @Test
    public void createOperator() throws Exception {
        MySQLOperatorDAO operatorDAO = new MySQLOperatorDAO(connector);
        operatorDAO.createOperator(new OperatorDTO(0, "", "", "", "", "", false));

        assertTrue(((TestConnector) connector).isInserted());
    }

}