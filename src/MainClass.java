import controller.MainController;
import view.MainView;

public class MainClass {
    public static void main(String[] args) {
//        ProductOrder productOrder = new ProductOrder();
//        productOrder.attachObserver(new MailSender(productOrder));
//        productOrder.setState(new DeliveredState());
//        productOrder.notifyAllObservers();
        MainController controller = new MainController(new MainView());
    }
}