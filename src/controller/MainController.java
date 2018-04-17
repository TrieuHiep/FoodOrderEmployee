package controller;

import dao.BillDAO;
import dao.BillDAOImpl;
import dao.OrderDAO;
import dao.OrderDAOImpl;
import model.empkg.Employee;
import observer.MailSender;
import observer.OrderUpdator;
import state.DeliveredState;
import state.ProductOrder;
import utils.MySQLConnector;
import view.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class MainController {
    private MainView view;
    private OrderDAO orderDAO;
    private List<ProductOrder> foodOrderList;

    public MainController(MainView view) {
        this.view = view;
        initListener();
        this.orderDAO = new OrderDAOImpl(MySQLConnector.getInstance().getMySQLConnection());
        try {
            this.foodOrderList = this.orderDAO.getAllOrdersByState();
            initObservers(foodOrderList);

            this.view.showDataToTable(foodOrderList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initObservers(List<ProductOrder> foodOrderList) {
        for (ProductOrder order : foodOrderList) {
            order.attachObserver(new MailSender(order));
            order.attachObserver(new OrderUpdator(order));
        }
    }

    private void initListener() {
        this.view.setBtnCreateBillListener(new BillCreator());
    }

    class BillCreator implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = MainController.this.view.getTableSelectedIndex();
            System.out.println("selected at " + index);
            ProductOrder productOrder = foodOrderList.get(index);
            productOrder.setState(new DeliveredState());
            productOrder.notifyAllObservers();
            Employee employee = new Employee();
            employee.setID(3);
            BillDAO billDAO = new BillDAOImpl(
                    MySQLConnector.getInstance().getMySQLConnection()
            );
            try {
                billDAO.createBill(productOrder, employee);
                MainController.this.view.showMessage("Done!");
            } catch (SQLException e1) {
                MainController.this.view.showMessage("Failed!");
                e1.printStackTrace();
            }
        }
    }

}
