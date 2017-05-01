package daoimpl01917;

import daointerfaces01917.DALException;
import daointerfaces01917.RecipeComponentDAO;
import dto01917.RecipeComponentDTO;

import java.util.List;

/**
 * Created by User on 25-04-2017.
 */
public class MYSQLRecipeComponentDAO implements RecipeComponentDAO {
    @Override
    public RecipeComponentDTO getRecipeComponent(int recipeId, int ingredientId) throws DALException {
        return null;
    }

    @Override
    public List<RecipeComponentDTO> getRecipeComponentList(int recipeId) throws DALException {
        return null;
    }

    @Override
    public List<RecipeComponentDTO> getRecipeComponentList() throws DALException {
        return null;
    }

    @Override
    public void createRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException {

    }

    @Override
    public void updateRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException {

    }

    @Override
    public void deleteRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException {

    }
}
