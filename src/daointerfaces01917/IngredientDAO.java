package daointerfaces01917;

import java.util.List;

import dto01917.IngredientDTO;

public interface IngredientDAO {
	IngredientDTO getIngredient(int ingredientId) throws DALException;
	List<IngredientDTO> getIngredientList() throws DALException;
	void createIngredient(IngredientDTO ingredient) throws DALException;
	void updateIngredient(IngredientDTO ingredient) throws DALException;
}
