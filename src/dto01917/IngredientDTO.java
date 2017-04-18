package dto01917;

/**
 * Raavare Data Objekt
 * 
 * @author mn/sh/tb
 * @version 1.2
 */

public class IngredientDTO
{
    /** i omraadet 1-99999999 vaelges af brugerne */
    int ingredientId;
    /** min. 2 max. 20 karakterer */
    String ingredientName;
    /** min. 2 max. 20 karakterer */
    String supplier;
	
	public IngredientDTO(int ingredientId, String ingredientName, String supplier)
	{
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.supplier = supplier;
	}
	
    public int getIngredientId() { return ingredientId; }
    public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }
    public String getIngredientName() { return ingredientName; }
    public void setIngredientName(String ingredientName) { this.ingredientName = ingredientName; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public String toString() { 
		return ingredientId + "\t" + ingredientName +"\t" + supplier;
	}
}
