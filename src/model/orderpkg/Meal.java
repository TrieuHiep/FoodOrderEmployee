package model.orderpkg;


import model.ctmpkg.Customer;
import model.foodpkg.Food;

/**
 * Created by tatsuya on 07/04/2018.
 */

public class Meal {
    private int ID;
    private Customer customer;
    private Food food;
    private int quantity;

    public Meal() {
    }

    public Meal(Customer customer, Food food, int quantity) {
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
    }

    public Meal(int ID, Customer customer, Food food, int quantity) {
        this.ID = ID;
        this.customer = customer;
        this.food = food;
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "ID=" + ID +
                '}';
    }
}
