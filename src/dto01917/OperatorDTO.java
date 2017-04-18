package dto01917;

/**
 * Operatoer Data Access Objekt
 * 
 * @author mn/tb
 * @version 1.2
 */

public class OperatorDTO
{
	/** Operatoer-identifikationsnummer (opr_id) i omraadet 1-99999999. Vaelges af brugerne */
	int operatorId;
	/** Operatoernavn (opr_navn) min. 2 max. 20 karakterer */
	String operatorName;
	/** Operatoer-initialer min. 2 max. 3 karakterer */
	String initials;
	/** Operatoer cpr-nr 10 karakterer */
	String cpr;                 
	/** Operatoer password min. 7 max. 8 karakterer */
	String password;            

	public OperatorDTO(int operatorId, String operatorName, String initials, String cpr, String password)
	{
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.initials = initials;
		this.cpr = cpr;
		this.password = password;
	}
	
    public OperatorDTO(OperatorDTO opr)
    {
    	this.operatorId = opr.getOperatorId();
    	this.operatorName = opr.getOperatorName();
    	this.initials = opr.getInitials();
    	this.cpr = opr.getCpr();
    	this.password = opr.getPassword();
    }
    
    public int getOperatorId() { return operatorId; }
	public void setOperatorId(int operatorId) { this.operatorId = operatorId; }
	public String getOperatorName() { return operatorName; }
	public void setOperatorName(String operatorName) { this.operatorName = operatorName; }
	public String getInitials() { return initials; }
	public void setInitials(String initials) { this.initials = initials; }
	public String getCpr() { return cpr; }
	public void setCpr(String cpr) { this.cpr = cpr; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String toString() { return operatorId + "\t" + operatorName + "\t" + initials + "\t" + cpr + "\t" + password; }
}
