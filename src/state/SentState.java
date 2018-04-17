package state;

public class SentState implements State {
    @Override
    public String handle() {
        return "Sent";
    }
}
