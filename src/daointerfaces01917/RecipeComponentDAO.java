package daointerfaces01917;

import java.util.List;

import dto01917.RecipeComponentDTO;

public interface RecipeComponentDAO {
	RecipeComponentDTO getRecipeComponent(int recipeId, int ingredientId) throws DALException;
	List<RecipeComponentDTO> getRecipeComponentList(int recipeId) throws DALException;
	List<RecipeComponentDTO> getRecipeComponentList() throws DALException;
		void createRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException;
	void updateRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException;
	void deleteRecipeComponent(RecipeComponentDTO recipeComponent) throws DALException;
}
