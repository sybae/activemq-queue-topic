package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactoryQueue")
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }

    @JmsListener(destination = "mailbox-topic", containerFactory = "myFactoryTopic")
    public void receiveMessageFromTopic(Email email) {
        System.out.println("Received (Topic) <" + email + ">");
    }
}