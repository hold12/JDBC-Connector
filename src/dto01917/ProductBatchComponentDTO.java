package dto01917;

public class ProductBatchComponentDTO
{
	int productbatchId; 	  // produktbatchets id
	int ingredientbatchId;        // i omraadet 1-99999999
	double tare;
	double netWeight;
	int operatorId;					// operatoer-nummer

	
	public ProductBatchComponentDTO(int productbatchId, int ingredientbatchId, double tare, double netWeight, int operatorId)
	{
		this.productbatchId = productbatchId;
		this.ingredientbatchId = ingredientbatchId;
		this.tare = tare;
		this.netWeight = netWeight;
		this.operatorId = operatorId;
	}
	
	public int getProductbatchId() { return productbatchId; }
	public void setProductbatchId(int productbatchId) { this.productbatchId = productbatchId; }
	public int getIngredientbatchId() { return ingredientbatchId; }
	public void setIngredientbatchId(int ingredientbatchId) { this.ingredientbatchId = ingredientbatchId; }
	public double getTare() { return tare; }
	public void setTare(double tare) { this.tare = tare; }
	public double getNetWeight() { return netWeight; }
	public void setNetWeight(double netWeight) { this.netWeight = netWeight; }
	public int getOperatorId() { return operatorId; }
	public void setOperatorId(int operatorId) { this.operatorId = operatorId; }
	public String toString() { 
		return productbatchId + "\t" + ingredientbatchId +"\t" + tare +"\t" + netWeight + "\t" + operatorId;
	}
}
