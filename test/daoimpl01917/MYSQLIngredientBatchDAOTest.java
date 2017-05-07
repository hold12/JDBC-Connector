package daoimpl01917;

import connector01917.Connector;
import connector01917.IConnector;
import connector01917.TestConnector;
import dto01917.IngredientBatchDTO;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.*;

/**
 * Created by AndersWOlsen on 07-05-2017.
 */
public class MYSQLIngredientBatchDAOTest {
    private IConnector connector;
    private MYSQLIngredientBatchDAO ingredientBatchDAO;

    private final IngredientBatchDTO testIngredientBatch = new IngredientBatchDTO(1, 2, 3.4);

    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        ingredientBatchDAO = new MYSQLIngredientBatchDAO(connector);
    }

    @Test
    public void getIngredientBatch() throws Exception {
        IngredientBatchDTO ibExpected = testIngredientBatch;
        IngredientBatchDTO ibActual = ingredientBatchDAO.getIngredientBatch(1);
        assertTrue(((TestConnector) connector).isSelected());
        assertTrue(ibExpected.equals(ibActual));
    }

    @Test
    public void createIngredientBatch() throws Exception {
        ingredientBatchDAO.createIngredientBatch(testIngredientBatch);
        assertTrue(((TestConnector) connector).isInserted());
    }

    @Test
    public void updateIngredientBatch() throws Exception {
        IngredientBatchDTO newIngredientBatch = new IngredientBatchDTO(1, 1, 3.4);
        ingredientBatchDAO.updateIngredientBatch(newIngredientBatch);
        assertTrue(((TestConnector) connector).isUpdated());
    }

    @Test(expected = NotImplementedException.class)
    public void deleteIngredientBatch() throws Exception {
        ingredientBatchDAO.deleteIngredientBatch(testIngredientBatch);
    }

}