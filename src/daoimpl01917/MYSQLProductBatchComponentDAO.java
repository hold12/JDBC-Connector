package daoimpl01917;

import connector01917.Connector;
import connector01917.IConnector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProductBatchComponentDAO;
import dto01917.ProductBatchComponentDTO;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLProductBatchComponentDAO implements ProductBatchComponentDAO {
    private IConnector connector;

    public MYSQLProductBatchComponentDAO(IConnector connector) {
        this.connector = connector;
    }

    @Override
    public ProductBatchComponentDTO getProductBatchComponent(int productbatchId, int ingredientbatchId) throws DALException {
        ResultSet rs = connector.doQuery(Queries.getFormatted(
                "productbatchcomponent.select.where.id",
                Integer.toString(productbatchId),
                Integer.toString(ingredientbatchId)
        ));

        try {
            if (!rs.first()) throw new DALException("The productbatchcomponent " + productbatchId + " " + ingredientbatchId + " does not exist.");
            return new ProductBatchComponentDTO(
                    rs.getInt("productbatch_id"),
                    rs.getInt("ingredientbatch_id"),
                    rs.getDouble("tare"),
                    rs.getDouble("net_weight"),
                    rs.getInt("operator_id")
            );
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    @Override
    public List<ProductBatchComponentDTO> getProductBatchComponentList(int productbatchId) throws DALException {
        ResultSet rs = connector.doQuery(Queries.getFormatted(
                "productbatchcomponent.select.where.productbatchid",
                Integer.toString(productbatchId)
        ));

        List<ProductBatchComponentDTO> list = new LinkedList<>();

        try {
            while (rs.next()) {
                list.add(new ProductBatchComponentDTO(
                        rs.getInt("productbatch_id"),
                        rs.getInt("ingredientbatch_id"),
                        rs.getDouble("tare"),
                        rs.getDouble("net_weight"),
                        rs.getInt("operator_id")
                ));
            }
        } catch (SQLException e) {
            throw new DALException(e);
        }

        return list;
    }

    @Override
    public List<ProductBatchComponentDTO> getProductBatchComponentList() throws DALException {
        ResultSet rs = connector.doQuery(Queries.getFormatted(
                "productbatchcomponent.select.all"
        ));

        List<ProductBatchComponentDTO> list = new LinkedList<>();

        try {
            while (rs.next()) {
                list.add(new ProductBatchComponentDTO(
                        rs.getInt("productbatch_id"),
                        rs.getInt("ingredientbatch_id"),
                        rs.getDouble("tare"),
                        rs.getDouble("net_weight"),
                        rs.getInt("operator_id")
                ));
            }
        } catch (SQLException e) {
            throw new DALException(e);
        }

        return list;
    }

    @Override
    public void createProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {
        connector.doUpdate(Queries.getFormatted(
                "productbatchcomponent.insert",
                Integer.toString(productBatchComponent.getProductbatchId()),
                Integer.toString(productBatchComponent.getIngredientbatchId()),
                Double.toString(productBatchComponent.getTare()),
                Double.toString(productBatchComponent.getNetWeight()),
                Integer.toString(productBatchComponent.getOperatorId())
        ));
    }

    @Override
    public void updateProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {

    }

    @Override
    public void deleteProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException {

    }
}
