package daoimpl01917;

import connector01917.IConnector;
import daointerfaces01917.DALException;
import daointerfaces01917.RecipeDAO;
import dto01917.RecipeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Freya on 02-05-2017.
 */
public class MYSQLRecipeDAO implements RecipeDAO {
    private IConnector connector;

    public MYSQLRecipeDAO(IConnector connector) {
        this.connector = connector;
    }

    @Override
    public RecipeDTO getRecipe(int recipeId) throws DALException {
        ResultSet rs = connector.doQuery(Queries.getFormatted(
                "recipe.select.where.id",
                Integer.toString(recipeId)
        ));

        try {
            if (!rs.first())
                throw new DALException("The recipe " + recipeId + " does not exist.");
            return new RecipeDTO(
                    rs.getInt("recipe_id"),
                    rs.getString("recipe_name")
            );
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    @Override
    public List<RecipeDTO> getRecipeList() throws DALException {
        ResultSet rs = connector.doQuery(Queries.getFormatted(
                "recipe.select.all"
        ));

        List<RecipeDTO> list = new LinkedList<>();

        try {
            while (rs.next()) {
                list.add(new RecipeDTO(
                        rs.getInt("recipe_id"),
                        rs.getString("recipe_name")
                ));
            }
        } catch (SQLException e) {
            throw new DALException(e);
        }

        return list;
    }

    @Override
    public void createRecipe(RecipeDTO recipe) throws DALException {
        connector.doUpdate(Queries.getFormatted(
                "recipe.insert",
                recipe.getRecipeName()
        ));
    }

    @Override
    public void updateRecipe(RecipeDTO recipe) throws DALException {
        connector.doUpdate(Queries.getFormatted(
                "recipe.update",
                Integer.toString(recipe.getRecipeId()),
                recipe.getRecipeName()
        ));
    }

    @Override
    public void deleteRecipe(RecipeDTO recipe) throws DALException {
        connector.doUpdate(Queries.getFormatted(
                "recipe.delete",
                Integer.toString(recipe.getRecipeId())
        ));
    }
}
