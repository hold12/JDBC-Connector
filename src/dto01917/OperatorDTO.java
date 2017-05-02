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
	String operatorFirstname;
	String operatorLastname;
	/** Operatoer-initialer min. 2 max. 3 karakterer */
	String initials;
	/** Operatoer cpr-nr 10 karakterer */
	String cpr;                 
	/** Operatoer password min. 7 max. 8 karakterer */
	String password;
    boolean isActive;

    public OperatorDTO(int operatorId, String operatorFirstname, String operatorLastname, String initials, String cpr, String password, boolean isActive) {
		this.operatorId = operatorId;
		this.operatorFirstname = operatorFirstname;
		this.operatorLastname = operatorLastname;
		this.initials = initials;
		this.cpr = cpr;
		this.password = password;
        this.isActive = isActive;
    }
	
    public OperatorDTO(OperatorDTO opr)
    {
    	this.operatorId = opr.getOperatorId();
    	this.operatorFirstname = opr.getOperatorFirstname();
    	this.operatorLastname = opr.getOperatorLastname();
    	this.initials = opr.getInitials();
    	this.cpr = opr.getCpr();
    	this.password = opr.getPassword();
        this.isActive = opr.isActive();
    }
    
    public int getOperatorId() { return operatorId; }
	public void setOperatorId(int operatorId) { this.operatorId = operatorId; }
	public String getOperatorFirstname() { return operatorFirstname; }
	public void setOperatorFirstname(String operatorFirstname) { this.operatorFirstname = operatorFirstname; }
	public String getOperatorLastname() { return this.operatorLastname; }
	public void setOperatorLastname(String operatorLastname) { this.operatorLastname = operatorLastname; }
	public String getInitials() { return initials; }
	public void setInitials(String initials) { this.initials = initials; }
	public String getCpr() { return cpr; }
	public void setCpr(String cpr) { this.cpr = cpr; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String toString() {
        return operatorId + "\t" + operatorFirstname + "\t" + initials + "\t" + cpr + "\t" + password + "\t" + isActive;
    }
}
