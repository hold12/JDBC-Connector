package daoimpl01917;

import connector01917.Connector;
import daoimpl01917.MySQLOperatorDAO;
import daointerfaces01917.DALException;
import dto01917.OperatorDTO;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MySQLOperatorDAOTest {
    MySQLOperatorDAO operatorDAO = new MySQLOperatorDAO();
    OperatorDTO operatorDTO = new OperatorDTO(4, "Don", "Juan", "DJ", "000000-0000", "iloveyou", true);

    private void connect() {
        try {
            new Connector();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert() {
        connect();
        try {
            operatorDAO.createOperator(operatorDTO);
        } catch (DALException e) {
            assertTrue(false);
        }

        OperatorDTO operatorDTO1 = null;
        try {
            operatorDTO1 = operatorDAO.getOperator(4);
        } catch (DALException e) {
            assertTrue(false);
        }

        assertEquals(operatorDTO.toString(), operatorDTO1.toString());

    }

    @Test
    public void updateOperator() {
        connect();
        operatorDTO.setInitials("DoJu");
        try {
            operatorDAO.updateOperator(operatorDTO);
        } catch (DALException e) {
            assertTrue(false);
        }

        OperatorDTO operatorDTO1 = null;
        try {
            operatorDTO1 = operatorDAO.getOperator(4);
        } catch (DALException e) {
            assertTrue(false);
        }

        assertEquals(operatorDTO.toString(), operatorDTO1.toString());
    }

    @Test
    public void testDelete() {
        connect();
        try {
            operatorDAO.deleteOperator(operatorDTO);
        } catch (DALException e) {
            assertTrue(false);
        }

        OperatorDTO operatorDTO1 = null;

        try {
            operatorDTO1 = operatorDAO.getOperator(4);
        } catch (DALException e) {
            assertTrue(false);
        }

        List<OperatorDTO> list = null;
        try {
            list = operatorDAO.getOperatorList();
        } catch (DALException e) {
            assertTrue(false);
        }

        assertFalse(operatorDTO1.isActive());

        try {
            new Connector().doUpdate("DELETE FROM operator WHERE operator_id = 4;");
        } catch (DALException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}