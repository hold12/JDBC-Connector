package daoimpl01917;

import daointerfaces01917.DALException;
import daointerfaces01917.ProductBatchDAO;
import dto01917.ProductBatchDTO;

import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLProductBatchDAO implements ProductBatchDAO {
    @Override
    public ProductBatchDTO getProductBatch(int productId) throws DALException {
        return null;
    }

    @Override
    public List<ProductBatchDTO> getProductBatchList() throws DALException {
        return null;
    }

    @Override
    public void createProductBatch(ProductBatchDTO productbatch) throws DALException {

    }

    @Override
    public void updateProductBatch(ProductBatchDTO productbatch) throws DALException {

    }

    @Override
    public void deleteProductBatch(ProductBatchDTO productBatch) throws DALException {

    }
}
