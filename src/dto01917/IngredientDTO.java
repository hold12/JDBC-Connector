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
    private int ingredientId;
    /** min. 2 max. 20 karakterer */
    private String ingredientName;
    /** min. 2 max. 20 karakterer */
    private String supplier;
	
	public IngredientDTO(int ingredientId, String ingredientName, String supplier)
	{
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.supplier = supplier;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientDTO that = (IngredientDTO) o;

        if (ingredientId != that.ingredientId) return false;
        if (ingredientName != that.ingredientName) return false;
        return supplier != null ? supplier.equals(that.supplier) : that.supplier == null;
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
