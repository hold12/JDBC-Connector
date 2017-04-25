package daoimpl01917;

import daointerfaces01917.DALException;
import daointerfaces01917.IngredientBatchDAO;
import dto01917.IngredientBatchDTO;

import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLIngredientBatchDAO implements IngredientBatchDAO{
    @Override
    public IngredientBatchDTO getIngredientBatch(int recipeId) throws DALException {
        return null;
    }

    @Override
    public List<IngredientBatchDTO> getIngredientBatchList() throws DALException {
        return null;
    }

    @Override
    public List<IngredientBatchDTO> getIngredientBatchList(int ingredientId) throws DALException {
        return null;
    }

    @Override
    public void createIngredientBatch(IngredientBatchDTO ingredientBatch) throws DALException {

    }

    @Override
    public void updateIngredientBatch(IngredientBatchDTO ingredientBatch) throws DALException {

    }

    @Override
    public void deleteIngredientBatch(IngredientBatchDTO ingredientBatch) throws DALException {

    }
}
