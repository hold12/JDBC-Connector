package daoimpl01917;

import daointerfaces01917.DALException;
import daointerfaces01917.ProductBatchComponentDAO;
import dto01917.ProductBatchComponentDTO;

import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLProductBatchComponentDAO implements ProductBatchComponentDAO {
    @Override
    public ProductBatchComponentDTO getProductBatchComponent(int productbatchId, int recipebatchId) throws DALException {
        return null;
    }

    @Override
    public List<ProductBatchComponentDTO> getProductBatchComponentList(int productbatchId) throws DALException {
        return null;
    }

    @Override
    public List<ProductBatchComponentDTO> getProductBatchComponentList() throws DALException {
        return null;
    }

    @Override
    public void createProductBatchComponent(ProductBatchComponentDTO produktBatchComponent) throws DALException {

    }

    @Override
    public void updateProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {

    }

    @Override
    public void deleteProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {

    }
}
