package model.personpkg;

/**
 * Created by tatsuya on 07/04/2018.
 */

public class Person{
    protected int id;
    protected Account account;
    protected int age;
    protected String fullName;

    public Person() {
    }

    public Person(int id, Account account, int age, String fullName) {
        this.id = id;
        this.account = account;
        this.age = age;
        this.fullName = fullName;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
