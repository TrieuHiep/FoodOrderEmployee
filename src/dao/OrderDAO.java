package dao;

import model.orderpkg.FoodOrder;
import state.ProductOrder;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    public abstract List<FoodOrder> getAllOrders() throws SQLException;

    public abstract List<ProductOrder> getAllOrdersByState() throws SQLException;

    public abstract boolean updateOrderStatus(ProductOrder productOrder) throws SQLException;

}
