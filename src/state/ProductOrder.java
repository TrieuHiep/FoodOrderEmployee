package state;

import model.orderpkg.FoodOrder;
import observer.IObservable;
import observer.IObserver;

import java.util.ArrayList;
import java.util.List;

public class ProductOrder implements IObservable {
    private State state;
    private FoodOrder order;

    public ProductOrder(FoodOrder order) {
        this.order = order;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        System.out.println("setting new State for order.....");
        this.state = state;
    }

    public FoodOrder getOrder() {
        return order;
    }

    public void setOrder(FoodOrder order) {
        this.order = order;
    }

    private List<IObserver> observerList = new ArrayList<>();

    @Override
    public void attachObserver(IObserver observer) {
        this.observerList.add(observer);
    }

    @Override
    public void detachObserver(IObserver observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (IObserver observer : this.observerList) {
            observer.update();
        }
    }
}
