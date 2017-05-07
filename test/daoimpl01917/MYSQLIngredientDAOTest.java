package daoimpl01917;

import connector01917.IConnector;
import connector01917.TestConnector;
import dto01917.IngredientDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by freyagh on 07/05/2017.
 */
public class MYSQLIngredientDAOTest {
    private final IngredientDTO testIngredient = new IngredientDTO(1, "tomato", "Heinz");
    private IConnector connector;
    private MYSQLIngredientDAO ingredientDAO;

    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        ingredientDAO = new MYSQLIngredientDAO(connector);
    }

    @Test
    public void getIngredient() throws Exception {
        IngredientDTO inExpected = testIngredient;
        IngredientDTO inActual = ingredientDAO.getIngredient(1);
        assertTrue(((TestConnector) connector).isSelected());
        assertTrue(inExpected.equals(inActual));
    }

    @Test
    public void createIngredient() throws Exception {
        ingredientDAO.createIngredient(testIngredient);
        assertTrue(((TestConnector) connector).isInserted());
    }

    @Test
    public void updateIngredient() throws Exception {
        IngredientDTO newIngredient = new IngredientDTO(1, "ketchup", "Heinz");
        ingredientDAO.updateIngredient(newIngredient);
        assertTrue(((TestConnector) connector).isUpdated());
    }

    @Test
    public void deleteIngredient() throws Exception {
        ingredientDAO.deleteIngredient(testIngredient);
        assertTrue(((TestConnector) connector).isDeleted());
    }
}