package dto01917;

public class ProductBatchComponentDTO
{
	private int productbatchId; 	  // produktbatchets id
	private int ingredientbatchId;        // i omraadet 1-99999999
	private double tare;
	private double netWeight;
	private int operatorId;					// operatoer-nummer


	public ProductBatchComponentDTO(int productbatchId, int ingredientbatchId, double tare, double netWeight, int operatorId)
	{
		this.productbatchId = productbatchId;
		this.ingredientbatchId = ingredientbatchId;
		this.tare = tare;
		this.netWeight = netWeight;
		this.operatorId = operatorId;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBatchComponentDTO that = (ProductBatchComponentDTO) o;

        if (productbatchId != that.productbatchId) return false;
        if (ingredientbatchId != that.ingredientbatchId) return false;
        if (tare != that.tare) return false;
        if (netWeight != that.netWeight) return false;
        return operatorId == that.operatorId;
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
