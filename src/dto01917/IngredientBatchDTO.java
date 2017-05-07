package dto01917;

public class IngredientBatchDTO
{
	private int ingredientBatchId;                     // i omraadet 1-99999999
	private int ingredientId;             // i omraadet 1-99999999
	private double amount;             // kan vaere negativ

	public IngredientBatchDTO(int ingredientBatchId, int ingredientId, double amount)
	{
		this.ingredientBatchId = ingredientBatchId;
		this.ingredientId = ingredientId;
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		IngredientBatchDTO that = (IngredientBatchDTO) o;

		if (ingredientBatchId != that.ingredientBatchId) return false;
		if (ingredientId != that.ingredientId) return false;
		return Double.compare(that.amount, amount) == 0;
	}

	public int getIngredientBatchId() { return ingredientBatchId; }
	public void setIngredientBatchId(int ingredientBatchId) { this.ingredientBatchId = ingredientBatchId; }
	public int getIngredientId() { return ingredientId; }
	public void setIngredientId(int ingredientId) { this.ingredientId = ingredientId; }
	public double getAmount() { return amount; }
	public void setAmount(double amount) { this.amount = amount; }
	public String toString() { 
		return ingredientBatchId + "\t" + ingredientId +"\t" + amount;
	}
}
