package dto01917;

public class RecipeComponentDTO
{
	int recipeId;                  // auto genereres fra 1..n
	int ingredientId;             // i omraadet 1-99999999
	double nominatedNetWeight;            // skal vaere positiv og passende stor
	double tolerance;           // skal vaere positiv og passende stor
	
	public RecipeComponentDTO(int recipeId, int ingredientId, double nominatedNetWeight, double tolerance)
	{
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
		this.nominatedNetWeight = nominatedNetWeight;
		this.tolerance = tolerance;
	}

	public int getRecipeId() { return recipeId; }
	public void setRecipeId(int recipeId) { this.recipeId = recipeId; }
	public int getIngredientId() { return ingredientId; }
	public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }
	public double getNominatedNetWeight() { return nominatedNetWeight; }
	public void setNominatedNetWeight(double nominatedNetWeight) { this.nominatedNetWeight = nominatedNetWeight; }
	public double getTolerance() { return tolerance; }
	public void setTolerance(double tolerance) { this.tolerance = tolerance; }
	public String toString() { 
		return recipeId + "\t" + ingredientId + "\t" + nominatedNetWeight + "\t" + tolerance;
	}
}
