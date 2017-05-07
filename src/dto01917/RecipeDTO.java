package dto01917;

/**
 * Recept Data Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class RecipeDTO
{
	/** Recept nr i omraadet 1-99999999 */
	int recipeId;
	/** Receptnavn min. 2 max. 20 karakterer */
	String recipeName;
	/** liste af kompenenter i recepten */
	
    
	public RecipeDTO(int recipeId, String recipeName)
	{
        this.recipeId = recipeId;
        this.recipeName = recipeName;
    }

    public int getRecipeId() { return recipeId; }
	public void setRecipeId(int recipeId) { this.recipeId = recipeId; }
	public String getRecipeName() { return recipeName; }
	public void setRecipeName(String recipeName) { this.recipeName = recipeName; }
	public String toString() { 
		return recipeId + "\t" + recipeName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RecipeDTO that = (RecipeDTO) o;

		return recipeId == that.recipeId;
		return recipeName != null ? recipeName.equals(that.recipeName) : that.recipeName == null;
	}
}
