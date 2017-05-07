package test01917;

import connector01917.IConnector;
import connector01917.TestConnector;
import daoimpl01917.MySQLOperatorDAO;
import daointerfaces01917.DALException;
import dto01917.OperatorDTO;

import java.sql.SQLException;

import connector01917.Connector;

public class Main {
	public static void main(String[] args) {
		IConnector connector = new TestConnector();

		System.out.println("Operator no. 3:");
		MySQLOperatorDAO operator = new MySQLOperatorDAO(connector);
		try { System.out.println(operator.getOperator(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Insertion of a new operator with operator_id = 4");
		OperatorDTO operatorDTO = new OperatorDTO(4,"Don","Juan","DJ","000000-0000","iloveyou",false);
		try { operator.createOperator(operatorDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Operator no. 4:");
		try { System.out.println(operator.getOperator(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Updating initials for operator no. 4");
		operatorDTO.setInitials("DoJu");
		try { operator.updateOperator(operatorDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operator no. 4");
		try { System.out.println(operator.getOperator(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("All operators:");
		try { System.out.println(operator.getOperatorList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Operator no. 5:");
		try { System.out.println(operator.getOperator(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		
		
	}
}
