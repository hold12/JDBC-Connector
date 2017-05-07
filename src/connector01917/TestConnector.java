package connector01917;

import daointerfaces01917.DALException;
import dto01917.*;
import org.jmock.Expectations;
import org.jmock.Mockery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by AndersWOlsen on 07-05-2017.
 */
public class TestConnector implements IConnector {
    private final Mockery mockery = new Mockery();
    private final ResultSet resultSet = mockery.mock(ResultSet.class);
    private boolean selected;
    private boolean inserted;
    private boolean updated;
    private boolean deleted;

    public TestConnector() throws SQLException{
        this.selected = false;
        this.inserted = false;
        this.updated = false;
        this.deleted = false;

        mockery.checking(new Expectations() {{
            allowing(resultSet).first(); will(returnValue(true));
        }});
    }

    @Override
    public Connection connectToDatabase(String url, String username, String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ResultSet doQuery(String cmd) throws DALException {
        cmd = cmd.toLowerCase();
        if (cmd.contains("select")) {
            this.selected = true;

            // If the SQL statement includes "operator" in it
            if (cmd.contains("from view_operator")) {
                OperatorDTO operator = new OperatorDTO(1, "John", "Doe", "JD", "010190-1234", "p455w0rd!", false);
                // Insert an operator to the ResultSet
                insertOperatorResultSet(operator);
            } else if (cmd.contains("from view_ingredientbatch")) {
                IngredientBatchDTO ingredientBatchDTO = new IngredientBatchDTO(1, 2, 3.4);
                // Insert an ingredient batch to the ResultSet
                insertIngredientBatchResultSet(ingredientBatchDTO);
            } else if (cmd.contains("from view_ingredient")) {
                IngredientDTO ingredientDTO = new IngredientDTO(1, "tomato", "Heinz");
                // Insert an ingredient to the ResultSet
                insertIngredientResultSet(ingredientDTO);
            } else if (cmd.contains("from view_productbatchcomponent")) {
                ProductBatchComponentDTO productBatchComponentDTO = new ProductBatchComponentDTO(1, 1, 0.5, 10, 1);
                // Insert an ingredient to the ResultSet
                insertProductBatchComponentResultSet(productBatchComponentDTO);
            } else if(cmd.contains("from view_recipecomponent")){
                RecipeComponentDTO recipeComponentDTO = new RecipeComponentDTO(1,2, 1.2, 1.2);
                insertRecipeComponentResultSet(recipeComponentDTO);
            }
        }

        return resultSet;
    }

    @Override
    public int doUpdate(String cmd) throws DALException {
        cmd = cmd.toLowerCase();
        if (cmd.contains("update"))
            this.updated = true;
        else if (cmd.contains("delete"))
            this.deleted = true;
        else if (cmd.contains("insert"))
            this.inserted = true;
        return 0;
    }

    private void insertOperatorResultSet(OperatorDTO operator) throws DALException {
        try {
            mockery.checking(new Expectations() {{
                allowing(resultSet).getInt("operator_id");           will(returnValue(operator.getOperatorId()));
                allowing(resultSet).getString("operator_firstname"); will(returnValue(operator.getOperatorFirstname()));
                allowing(resultSet).getString("operator_lastname");  will(returnValue(operator.getOperatorLastname()));
                allowing(resultSet).getString("initials");           will(returnValue(operator.getInitials()));
                allowing(resultSet).getString("cpr");                will(returnValue(operator.getCpr()));
                allowing(resultSet).getString("password");           will(returnValue(operator.getPassword()));
                allowing(resultSet).getBoolean("is_active");         will(returnValue(operator.isActive()));
            }});
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    private void insertIngredientBatchResultSet(IngredientBatchDTO ingredientBatch) throws DALException {
        try {
            mockery.checking(new Expectations() {{
                allowing(resultSet).getInt("ingredientbatch_id"); will(returnValue(1));
                allowing(resultSet).getInt("ingredient_id");      will(returnValue(2));
                allowing(resultSet).getDouble("amount");          will(returnValue(3.4));
            }});
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    private void insertIngredientResultSet(IngredientDTO ingredient) throws DALException {
        try {
            mockery.checking(new Expectations() {{
                allowing(resultSet).getInt("ingredient_id");      will(returnValue(ingredient.getIngredientId()));
                allowing(resultSet).getString("ingredient_name"); will(returnValue(ingredient.getIngredientName()));
                allowing(resultSet).getString("supplier");        will(returnValue(ingredient.getSupplier()));
            }});
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    private void insertProductBatchComponentResultSet(ProductBatchComponentDTO productBatchComponent) throws DALException {
        try {
            mockery.checking(new Expectations() {{
                allowing(resultSet).getInt("productbatch_id");    will(returnValue(productBatchComponent.getProductbatchId()));
                allowing(resultSet).getInt("ingredientbatch_id"); will(returnValue(productBatchComponent.getIngredientbatchId()));
                allowing(resultSet).getDouble("tare");            will(returnValue(productBatchComponent.getTare()));
                allowing(resultSet).getDouble("net_weight");      will(returnValue(productBatchComponent.getNetWeight()));
                allowing(resultSet).getInt("operator_id");        will(returnValue(productBatchComponent.getOperatorId()));
            }});
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }

    private void insertRecipeComponentResultSet(RecipeComponentDTO recipeComponent) throws DALException{
        try {
            mockery.checking(new Expectations() {{
                allowing(resultSet).getInt("recipe_id"); will(returnValue(recipeComponent.getRecipeId()));
                allowing(resultSet).getInt("ingredient_id"); will(returnValue(recipeComponent.getIngredientId()));
                allowing(resultSet).getDouble("nominated_net_weight"); will(returnValue(recipeComponent.getNominatedNetWeight()));
                allowing(resultSet).getDouble("tolerance"); will(returnValue(recipeComponent.getTolerance()));
            }});
        } catch (SQLException e) {
            throw new DALException(e);
        }
    }



    public boolean isSelected() { return selected; }
    public boolean isInserted() { return inserted; }
    public boolean isUpdated() { return updated; }
    public boolean isDeleted() { return deleted; }
}
