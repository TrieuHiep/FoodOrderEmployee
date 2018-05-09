package observer;

import com.sun.mail.smtp.SMTPTransport;
import model.orderpkg.FoodOrder;
import state.ProductOrder;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class EMailSender implements IObserver {
    private ProductOrder productOrder;

    public EMailSender(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public void update() {
        String orderState = this.productOrder.getState().handle();
        System.out.println("sending mail to " +
                productOrder.getOrder().getMeal().getCustomer().getEmail() + "...");

        // send email to customer

//        FoodOrder order = productOrder.getOrder();
//        String email = productOrder.getOrder().getMeal().getCustomer().getEmail();
//
//        try {
//            String username = "trieuhiepptit";
//            String password = "nthangzuzu";
//            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
//
//            Properties props = System.getProperties();
//            props.setProperty("mail.smtps.host", "smtp.gmail.com");
//            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
//            props.setProperty("mail.smtp.socketFactory.fallback", "false");
//            props.setProperty("mail.smtp.port", "465");
//            props.setProperty("mail.smtp.socketFactory.port", "465");
//            props.setProperty("mail.smtps.auth", "true");
//            props.put("mail.smtps.quitwait", "false");
//
//            Session session = Session.getInstance(props, null);
//
//            // -- Create a new message --
//            final MimeMessage msg = new MimeMessage(session);
//
//            // -- Set the FROM and TO fields --
//            msg.setFrom(new InternetAddress(username + "@gmail.com"));
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
//
//            String title = "Your Order has been Delivered!"
//                    + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//            msg.setSubject(title);
//            msg.setText("Email Content", "utf-8");
//            msg.setSentDate(new Date());
//
//            SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
//
//            t.connect("smtp.gmail.com", username, password);
//            t.sendMessage(msg, msg.getAllRecipients());
//            t.close();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
    }
}
