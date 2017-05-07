package daoimpl01917;

import connector01917.IConnector;
import connector01917.TestConnector;
import dto01917.ProductBatchComponentDTO;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by freyagh on 07/05/2017.
 */
public class MYSQLProductBatchComponentDAOTest {
    private final ProductBatchComponentDTO testProductBatchComponent = new ProductBatchComponentDTO(1, 1, 0.5, 10, 1);
    private IConnector connector;
    private MYSQLProductBatchComponentDAO productBatchComponentDAO;

    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        productBatchComponentDAO = new MYSQLProductBatchComponentDAO(connector);
    }

    @Test
    public void getProductBatchComponent() throws Exception {
        ProductBatchComponentDTO pbcExpected = testProductBatchComponent;
        ProductBatchComponentDTO pbcActual = productBatchComponentDAO.getProductBatchComponent(1, 1);
        assertTrue(((TestConnector) connector).isSelected());
        assertTrue(pbcExpected.equals(pbcActual));
    }

    @Test
    public void createProductBatchComponent() throws Exception {
        productBatchComponentDAO.createProductBatchComponent(testProductBatchComponent);
        assertTrue(((TestConnector) connector).isInserted());
    }

    @Test(expected = NotImplementedException.class)
    public void updateProductBatchComponent() throws Exception {
        ProductBatchComponentDTO newIngredientBatch = new ProductBatchComponentDTO(1, 1, 0.5, 10, 2);
        productBatchComponentDAO.updateProductBatchComponent(newIngredientBatch);
    }

    @Test(expected = NotImplementedException.class)
    public void deleteProductBatchComponent() throws Exception {
        productBatchComponentDAO.deleteProductBatchComponent(testProductBatchComponent);
    }
}
