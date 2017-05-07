package daoimpl01917;

import static org.junit.Assert.*;
import connector01917.IConnector;
import connector01917.TestConnector;
import dto01917.RecipeComponentDTO;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 * Created by User on 07-05-2017.
 */
public class MYSQLRecipeComponentDAOTest {
    private IConnector connector;
    private MYSQLRecipeComponentDAO recipeComponentDAO;
    private final RecipeComponentDTO testRecipeComponent = new RecipeComponentDTO(1, 2, 1.2,  1.2);



    @org.junit.Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        recipeComponentDAO = new MYSQLRecipeComponentDAO(connector);

    }

    @org.junit.Test
    public void getRecipeComponent() throws Exception {
        RecipeComponentDTO ibExpected = testRecipeComponent;
        RecipeComponentDTO ibActual = recipeComponentDAO.getRecipeComponent(1, 2);
        assertTrue(((TestConnector) connector).isSelected());
        assertTrue(ibExpected.equals(ibActual));

    }

    @org.junit.Test
    public void createRecipeComponent() throws Exception {
        recipeComponentDAO.createRecipeComponent(testRecipeComponent);
        assertTrue(((TestConnector) connector).isInserted());

    }

    @org.junit.Test
    public void updateRecipeComponent() throws Exception {
        RecipeComponentDTO newRecipeComponent = new RecipeComponentDTO(1, 2, 1.4,  1.4);
        recipeComponentDAO.updateRecipeComponent(newRecipeComponent);
        assertTrue(((TestConnector) connector).isUpdated());


    }

    @org.junit.Test
    public void deleteRecipeComponent() throws Exception {
        recipeComponentDAO.deleteRecipeComponent(testRecipeComponent);

    }

}