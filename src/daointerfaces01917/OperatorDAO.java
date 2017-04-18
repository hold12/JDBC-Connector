package daointerfaces01917;

import java.util.List;

import dto01917.OperatorDTO;

public interface OperatorDAO {
	OperatorDTO getOperator(int operatorId) throws DALException;
	List<OperatorDTO> getOperatorList() throws DALException;
	void createOperator(OperatorDTO operator) throws DALException;
	void updateOperator(OperatorDTO operator) throws DALException;
}
