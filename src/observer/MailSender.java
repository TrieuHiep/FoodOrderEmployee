package observer;

import state.ProductOrder;

public class MailSender implements IObserver {
    private ProductOrder productOrder;

    public MailSender(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public void update() {
        String orderState = this.productOrder.getState().handle();
        System.out.println("sending mail to client.....");
        // send email to customer
    }
}
