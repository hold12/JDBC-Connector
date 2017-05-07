package daoimpl01917;

import connector01917.IConnector;
import connector01917.TestConnector;
import dto01917.ProductBatchDTO;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by freyagh on 07/05/2017.
 */
public class MYSQLProductBatchDAOTest {
    private final ProductBatchDTO testProductBatch = new ProductBatchDTO(1, 0, 1);
    private IConnector connector;
    private MYSQLProductBatchDAO productBatchDAO;

    @Before
    public void setUp() throws Exception {
        connector = new TestConnector();
        productBatchDAO = new MYSQLProductBatchDAO(connector);
    }

    @Test
    public void getProductBatch() throws Exception {
        ProductBatchDTO pbExpected = testProductBatch;
        ProductBatchDTO pbActual = productBatchDAO.getProductBatch(1);
        assertTrue(((TestConnector) connector).isSelected());
        assertTrue(pbExpected.equals(pbActual));
    }

    @Test
    public void createProductBatch() throws Exception {
        productBatchDAO.createProductBatch(testProductBatch);
        assertTrue(((TestConnector) connector).isInserted());
    }

    @Test
    public void updateProductBatch() throws Exception {
        ProductBatchDTO newProductBatch = new ProductBatchDTO(1, 1, 1);
        productBatchDAO.updateProductBatch(newProductBatch);
        assertTrue(((TestConnector) connector).isUpdated());
    }

    @Test(expected = NotImplementedException.class)
    public void deleteProductBatch() throws Exception {
        productBatchDAO.deleteProductBatch(testProductBatch);
    }

}