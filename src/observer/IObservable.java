package observer;

public interface IObservable {

    public abstract void attachObserver(IObserver observer);

    public abstract void detachObserver(IObserver observer);

    public void notifyAllObservers();
}
