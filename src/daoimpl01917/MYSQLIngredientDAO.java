package daoimpl01917;

import daointerfaces01917.DALException;
import daointerfaces01917.IngredientDAO;
import dto01917.IngredientDTO;

import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLIngredientDAO implements IngredientDAO {
    @Override
    public IngredientDTO getIngredient(int ingredientId) throws DALException {
        return null;
    }

    @Override
    public List<IngredientDTO> getIngredientList() throws DALException {
        return null;
    }

    @Override
    public void createIngredient(IngredientDTO ingredient) throws DALException {

    }

    @Override
    public void updateIngredient(IngredientDTO ingredient) throws DALException {

    }

    @Override
    public void deleteIngredient(IngredientDTO ingredient) throws DALException {

    }
}
