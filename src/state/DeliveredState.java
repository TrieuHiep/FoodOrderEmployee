package state;

public class DeliveredState implements State {
    @Override
    public String handle() {
        return "Delivered";
    }
}
