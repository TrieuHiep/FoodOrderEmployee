package observer;

import dao.OrderDAO;
import dao.OrderDAOImpl;
import state.ProductOrder;
import utils.MySQLConnector;

import java.sql.SQLException;

public class OrderUpdator implements IObserver {
    private ProductOrder productOrder;
    private OrderDAO orderDAO;
    public OrderUpdator(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public void update() {
        this.orderDAO = new OrderDAOImpl(
                MySQLConnector.getInstance().getMySQLConnection()
        );
        try {
            orderDAO.updateOrderStatus(productOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
