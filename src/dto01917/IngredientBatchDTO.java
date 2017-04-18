package dto01917;

public class IngredientBatchDTO
{
	int recipeId;                     // i omraadet 1-99999999
	int ingredientId;             // i omraadet 1-99999999
	double amount;             // kan vaere negativ

	public IngredientBatchDTO(int recipeId, int ingredientId, double amount)
	{
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
		this.amount = amount;
	}
	
	public int getRecipeId() { return recipeId; }
	public void setRecipeId(int recipeId) { this.recipeId = recipeId; }
	public int getIngredientId() { return ingredientId; }
	public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }
	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }
	public String toString() { 
		return recipeId + "\t" + ingredientId +"\t" + amount;
	}
}
