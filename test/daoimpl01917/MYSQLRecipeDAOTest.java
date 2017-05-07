package daoimpl01917;

import connector01917.IConnector;
import connector01917.TestConnector;
import daointerfaces01917.RecipeDAO;
import dto01917.RecipeDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by troels on 2017-05-07.
 */
public class MYSQLRecipeDAOTest {
    private final RecipeDTO testRecipe = new RecipeDTO(1, "pizza");
    private IConnector connector;
    private MYSQLRecipeDAO recipeDAO;

    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        recipeDAO = new MYSQLRecipeDAO(connector);
    }

    @Test
    public void getRecipe() throws Exception {
        RecipeDTO reExpected = testRecipe;
        RecipeDTO reActual = recipeDAO.getRecipe(1);
        assertTrue(((TestConnector) connector).isSelected());
        assertTrue(reExpected.equals(reActual));
    }

    @Test
    public void createRecipe() throws Exception {
        recipeDAO.createRecipe(testRecipe);
        assertTrue(((TestConnector) connector).isInserted());
    }

    @Test
    public void updateRecipe() throws Exception {
        RecipeDTO newRecipe = new RecipeDTO(2, "Melt cheese");
        recipeDAO.updateRecipe(newRecipe);
        assertTrue(((TestConnector) connector).isUpdated());
    }

    @Test
    public void deleteRecipe() throws Exception {
        recipeDAO.deleteRecipe(testRecipe);
        assertTrue(((TestConnector) connector).isDeleted());
    }
}
