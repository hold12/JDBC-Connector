package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.OperatorDAO;
import dto01917.OperatorDTO;

public class MySQLOperatorDAO implements OperatorDAO {
	public OperatorDTO getOperator(int operatorId) throws DALException {
//		ResultSet rs = Connector.doQuery("SELECT * FROM operator WHERE operator_id = " + operatorId);
		ResultSet rs = Connector.doQuery(Queries.getFormatted("operator.select.all", Integer.toString(operatorId)));
	    try {
	    	if (!rs.first()) throw new DALException("The operator " + operatorId + " does not exist.");
	    	return new OperatorDTO(rs.getInt("operator_id"), rs.getString("operator_name"), rs.getString("initials"), rs.getString("cpr"), rs.getString("password"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
	}
	
	public void createOperator(OperatorDTO operator) throws DALException {
			Connector.doUpdate(
				"INSERT INTO operator(operator_id, operator_name, initials, cpr, password) VALUES " +
				"(" + operator.getOperatorId() + ", '" + operator.getOperatorName() + "', '" + operator.getInitials() + "', '" +
				operator.getCpr() + "', '" + operator.getPassword() + "')"
			);
	}
	
	public void updateOperator(OperatorDTO operator) throws DALException {
		Connector.doUpdate(
				"UPDATE operator SET  operator_name = '" + operator.getOperatorName() + "', initials =  '" + operator.getInitials() +
				"', cpr = '" + operator.getCpr() + "', password = '" + operator.getPassword() + "' WHERE operator_id = " +
				operator.getOperatorId()
		);
	}
	
	public List<OperatorDTO> getOperatorList() throws DALException {
		List<OperatorDTO> list = new ArrayList<OperatorDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM operator");
		try
		{
			while (rs.next()) 
			{
				list.add(new OperatorDTO(rs.getInt("operator_id"), rs.getString("operator_name"), rs.getString("initials"), rs.getString("cpr"), rs.getString("password")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}
		
		
}
	
