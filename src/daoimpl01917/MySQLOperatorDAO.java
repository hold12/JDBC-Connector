package daoimpl01917;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.OperatorDAO;
import dto01917.OperatorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOperatorDAO implements OperatorDAO {
    public OperatorDTO getOperator(int operatorId) throws DALException {
        ResultSet rs = Connector.doQuery(Queries.getFormatted(
                "operator.select.where.id", Integer.toString(operatorId)
        ));

        try {
            if (!rs.first()) throw new DALException("The operator " + operatorId + " does not exist.");
            return new OperatorDTO(
                    rs.getInt("operator_id"),
                    rs.getString("operator_firstname"),
                    rs.getString("operator_lastname"),
                    rs.getString("initials"),
                    rs.getString("cpr"),
                    rs.getString("password"),
                    rs.getBoolean("is_active")
            );
        } catch (SQLException e) {
            throw new DALException(e);
        }

    }

    public void createOperator(OperatorDTO operator) throws DALException {
        Connector.doUpdate(Queries.getFormatted(
                "operator.insert",
                operator.getOperatorFirstname(),
                operator.getOperatorLastname(),
                operator.getInitials(),
                operator.getCpr(),
                operator.getPassword()
        ));
    }

    public void updateOperator(OperatorDTO operator) throws DALException {
        int isActive = 0;

        if (operator.isActive()) {
            isActive = 1;
        }

        Connector.doUpdate(Queries.getFormatted(
                "operator.update",
                Integer.toString(operator.getOperatorId()),
                operator.getOperatorFirstname(),
                operator.getOperatorLastname(),
                operator.getInitials(),
                operator.getCpr(),
                operator.getPassword(),
                Integer.toString(isActive)
        ));
    }

    public void deleteOperator(OperatorDTO operator) throws DALException {
        Connector.doUpdate(Queries.getFormatted(
                "operator.delete",
                Integer.toString(operator.getOperatorId())
        ));
    }

    public List<OperatorDTO> getOperatorList() throws DALException {
        List<OperatorDTO> list = new ArrayList<OperatorDTO>();
        ResultSet rs = Connector.doQuery(
                Queries.getSQL("operator.select.all")
        );

        try {
            while (rs.next()) {
                list.add(new OperatorDTO(
                        rs.getInt("operator_id"),
                        rs.getString("operator_firstname"),
                        rs.getString("operator_lastname"),
                        rs.getString("initials"),
                        rs.getString("cpr"),
                        rs.getString("password"),
                        rs.getBoolean("is_active"))
                );
            }
        } catch (SQLException e) {
            throw new DALException(e);
        }
        return list;
    }
}