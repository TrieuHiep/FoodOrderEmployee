package dao;

import model.empkg.Employee;
import state.ProductOrder;

import java.sql.SQLException;

public interface BillDAO {
    public abstract void createBill(ProductOrder productOrder, Employee employee) throws SQLException;
}
