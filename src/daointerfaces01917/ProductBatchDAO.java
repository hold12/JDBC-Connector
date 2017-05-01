package daointerfaces01917;

import dto01917.ProductBatchDTO;

import java.util.List;

public interface ProductBatchDAO {
    ProductBatchDTO getProductBatch(int productBatchId) throws DALException;

    List<ProductBatchDTO> getProductBatchList() throws DALException;

    void createProductBatch(ProductBatchDTO productBatch) throws DALException;

    void updateProductBatch(ProductBatchDTO productBatch) throws DALException;

    void deleteProductBatch(ProductBatchDTO productBatch) throws DALException;
}