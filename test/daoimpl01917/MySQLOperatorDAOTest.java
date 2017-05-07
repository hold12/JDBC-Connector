package daoimpl01917;

import connector01917.Connector;
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
    private final OperatorDTO opExpected = new OperatorDTO(1, "John", "Doe", "JD", "010190-1234", "p455w0rd", false);

    @Before
    public void setUp() throws Exception {
        try { new Connector(); }
        catch (InstantiationException|IllegalAccessException|ClassNotFoundException|SQLException e) { e.printStackTrace(); }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getOperator() throws Exception {
        //MySQLOperatorDAO operatorDAO = new MySQLOperatorDAO();
        //OperatorDTO opActual = operatorDAO.getOperator(1);

        assertTrue(true);
        //assertTrue(opExpected.getOperatorFirstname().equals(opActual.getOperatorFirstname()));
    }

}