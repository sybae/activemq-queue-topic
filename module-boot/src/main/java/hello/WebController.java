package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/sendQueue")
    public void sendQueue() {
        System.out.println("Sending an email message. (Queue)");
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.setPubSubDomain(false);
        jmsTemplate.convertAndSend("mailbox", new Email("queue@example.com", "Queue"));
    }

    @RequestMapping("/sendTopic")
    public void sendTopic() {
        System.out.println("Sending an email message. (Topic)");
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend("mailbox-topic", new Email("topic@example.com", "Topic"));
    }
}
