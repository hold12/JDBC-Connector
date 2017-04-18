package dto01917;

public class ProductBatchComponentDTO
{
	int productbatchId; 	  // produktbatchets id
	int recipeId;        // i omraadet 1-99999999
	double tare;
	double netWeight;
	int operatorId;					// operatoer-nummer

	
	public ProductBatchComponentDTO(int productbatchId, int recipeId, double tare, double netWeight, int operatorId)
	{
		this.productbatchId = productbatchId;
		this.recipeId = recipeId;
		this.tare = tare;
		this.netWeight = netWeight;
		this.operatorId = operatorId;
	}
	
	public int getProductbatchId() { return productbatchId; }
	public void setProductbatchId(int productbatchId) { this.productbatchId = productbatchId; }
	public int getRecipeId() { return recipeId; }
	public void setRecipeId(int recipeId) { this.recipeId = recipeId; }
	public double getTare() { return tare; }
	public void setTare(double tare) { this.tare = tare; }
	public double getNetWeight() { return netWeight; }
	public void setNetWeight(double netWeight) { this.netWeight = netWeight; }
	public int getOperatorId() { return operatorId; }
	public void setOperatorId(int operatorId) { this.operatorId = operatorId; }
	public String toString() { 
		return productbatchId + "\t" + recipeId +"\t" + tare +"\t" + netWeight + "\t" + operatorId;
	}
}
