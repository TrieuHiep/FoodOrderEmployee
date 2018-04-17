package dao;

import model.ctmpkg.Customer;
import model.orderpkg.FoodOrder;
import model.orderpkg.Meal;
import state.ProductOrder;
import state.SentState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;

    public OrderDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<FoodOrder> getAllOrders() throws SQLException {
        List<FoodOrder> foodOrders = new ArrayList<>();
        String sqlComamnd = "SELECT FoodOrder.ID AS idOrder, email, CreattionDate , Address , Meal.ID AS idMeal, PaymentType, Status " +
                "FROM Meal, Customer, FoodOrder " +
                "WHERE FoodOrder.MealID = Meal.ID " +
                "AND Meal.CustomerPersonID = Customer.PersonID " +
                "ORDER BY FoodOrder.ID";
        PreparedStatement statement = this.connection.prepareStatement(sqlComamnd);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Customer customer = new Customer();
            customer.setEmail(result.getString("email"));
            Meal meal = new Meal();
            meal.setID(result.getInt("idMeal"));
            meal.setCustomer(customer);

            FoodOrder foodOrder = new FoodOrder();
            foodOrder.setMeal(meal);
            foodOrder.setID(result.getInt("idOrder"));
            foodOrder.setPaymentType(result.getString("PaymentType"));
            foodOrder.setCreationDate(result.getString("CreattionDate"));
            foodOrder.setAddress(result.getString("Address"));
            foodOrder.setStatus(result.getString("Status"));
            System.out.println(foodOrder);
            foodOrders.add(foodOrder);
        }

        return foodOrders;
    }

    @Override
    public List<ProductOrder> getAllOrdersByState() throws SQLException {
        List<ProductOrder> foodOrders = new ArrayList<>();
        String sqlComamnd = "SELECT FoodOrder.ID AS idOrder, email, CreattionDate , Address , Meal.ID AS idMeal, PaymentType, Status " +
                "FROM Meal, Customer, FoodOrder " +
                "WHERE FoodOrder.MealID = Meal.ID " +
                "AND Meal.CustomerPersonID = Customer.PersonID " +
                "ORDER BY FoodOrder.ID";
        PreparedStatement statement = this.connection.prepareStatement(sqlComamnd);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Customer customer = new Customer();
            customer.setEmail(result.getString("email"));
            Meal meal = new Meal();
            meal.setID(result.getInt("idMeal"));
            meal.setCustomer(customer);

            FoodOrder foodOrder = new FoodOrder();
            foodOrder.setMeal(meal);
            foodOrder.setID(result.getInt("idOrder"));
            foodOrder.setPaymentType(result.getString("PaymentType"));
            foodOrder.setCreationDate(result.getString("CreattionDate"));
            foodOrder.setAddress(result.getString("Address"));
            String status = result.getString("Status");
            foodOrder.setStatus(status);
            ProductOrder productOrder = new ProductOrder(foodOrder);
            switch (status) {
                case "Sent": {
                    productOrder.setState(new SentState());
                }
            }
            foodOrders.add(productOrder);
        }

        return foodOrders;
    }

    @Override
    public boolean updateOrderStatus(ProductOrder productOrder) throws SQLException {
        FoodOrder foodOrder = productOrder.getOrder();
        foodOrder.setStatus(productOrder.getState().handle());

        String sqlCommand = "UPDATE FoodOrder SET Status = ? WHERE FoodOrder.ID = ?";
        PreparedStatement statement = this.connection.prepareStatement(sqlCommand);
        statement.setString(1, foodOrder.getStatus());
        statement.setInt(2, foodOrder.getID());
        this.connection.setAutoCommit(false);
        try {
            statement.executeUpdate();
            this.connection.commit();
            return true;
        } catch (SQLException e) {
            this.connection.rollback();
            return false;
        }
    }
}
