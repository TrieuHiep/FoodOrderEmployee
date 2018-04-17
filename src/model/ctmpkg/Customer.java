package model.ctmpkg;


import model.personpkg.Account;
import model.personpkg.Person;

/**
 * Created by tatsuya on 07/04/2018.
 */

public class Customer extends Person {
    private String email;

    public Customer() {
    }

    public Customer(int ID, Account account, int age, String fullName, String email) {
        super(ID, account, age, fullName);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                '}';
    }
}
