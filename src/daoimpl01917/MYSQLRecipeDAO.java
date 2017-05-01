package daoimpl01917;

import daointerfaces01917.DALException;
import daointerfaces01917.RecipeDAO;
import dto01917.RecipeDTO;

import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLRecipeDAO implements RecipeDAO {
    @Override
    public RecipeDTO getRecipe(int recipeId) throws DALException {
        return null;
    }

    @Override
    public List<RecipeDTO> getRecipeList() throws DALException {
        return null;
    }

    @Override
    public void createRecipe(RecipeDTO recipe) throws DALException {

    }

    @Override
    public void updateRecipe(RecipeDTO recipe) throws DALException {

    }

    @Override
    public void deleteRecipe(RecipeDTO recipe) throws DALException {

    }
}
