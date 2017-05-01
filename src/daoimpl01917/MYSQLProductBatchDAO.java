package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProductBatchDAO;
import dto01917.ProductBatchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLProductBatchDAO implements ProductBatchDAO {
    @Override
    public ProductBatchDTO getProductBatch(int productbatchId) throws DALException {
        ResultSet rs = Connector.doQuery(Queries.getFormatted(
                "productbatch.select.where.id",
                Integer.toString(productbatchId)
        ));

        try {
            if (!rs.first()) throw new DALException("The productbatch " + productbatchId + " does not exist.");
            return new ProductBatchDTO(
                    rs.getInt("productbatch_id"),
                    rs.getInt("status"),
                    rs.getInt("recipe_id")
            );
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    @Override
    public List<ProductBatchDTO> getProductBatchList() throws DALException {
        ResultSet rs = Connector.doQuery(Queries.getFormatted(
                "productbatch.select.all"
        ));

        List<ProductBatchDTO> list = new LinkedList<>();

        try {
            while (rs.next()) {
                list.add(new ProductBatchDTO(
                        rs.getInt("productbatch_id"),
                        rs.getInt("status"),
                        rs.getInt("recipe_id")
                ));
            }
        } catch (SQLException e) {
            throw new DALException(e);
        }

        return list;
    }

    @Override
    public void createProductBatch(ProductBatchDTO productBatch) throws DALException {
        Connector.doUpdate(Queries.getFormatted(
                "productbatch.insert",
                Integer.toString(productBatch.getStatus()),
                Integer.toString(productBatch.getRecipeId())
        ));
    }

    @Override
    public void updateProductBatch(ProductBatchDTO productBatch) throws DALException {
        Connector.doUpdate(Queries.getFormatted(
                "productbatch.update",
                Integer.toString(productBatch.getProductbatchId()),
                Integer.toString(productBatch.getStatus()),
                Integer.toString(productBatch.getRecipeId())
        ));
    }

    @Override
    public void deleteProductBatch(ProductBatchDTO productBatch) throws DALException {

    }
}
