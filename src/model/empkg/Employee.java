package model.empkg;


import model.personpkg.Account;
import model.personpkg.Person;

/**
 * Created by tatsuya on 07/04/2018.
 */

public class Employee extends Person {
    private String internalMail;

    public Employee() {
    }

    public Employee(int ID, Account account, int age, String fullName, String internalMail) {
        super(ID, account, age, fullName);
        this.internalMail = internalMail;
    }

    public String getInternalMail() {
        return internalMail;
    }

    public void setInternalMail(String internalMail) {
        this.internalMail = internalMail;
    }
}
