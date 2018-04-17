package dao;

import model.empkg.Employee;
import model.orderpkg.FoodOrder;
import state.ProductOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillDAOImpl implements BillDAO {
    private Connection connection;

    public BillDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createBill(ProductOrder productOrder, Employee employee) throws SQLException {
        FoodOrder foodOrder = productOrder.getOrder();
        String sqlCommand = "INSERT INTO Bill(EmployeePersonID, OrderID, Description) " +
                "VALUES (?,?,?)";
        PreparedStatement statement = this.connection.prepareStatement(sqlCommand);
        statement.setInt(1, employee.getID());
        statement.setInt(2, foodOrder.getID());
        statement.setString(3, "No description");
        this.connection.setAutoCommit(false);
        try {
            statement.executeUpdate();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
        }
    }
}
