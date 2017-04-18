package daointerfaces01917;

import java.util.List;

import dto01917.ProductBatchComponentDTO;

public interface ProductBatchComponentDAO {
	ProductBatchComponentDTO getProductBatchComponent(int productbatchId, int recipebatchId) throws DALException;
	List<ProductBatchComponentDTO> getProductBatchComponentList(int productbatchId) throws DALException;
	List<ProductBatchComponentDTO> getProductBatchComponentList() throws DALException;
	void createProductBatchComponent(ProductBatchComponentDTO produktBatchComponent) throws DALException;
	void updateProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException;
}

