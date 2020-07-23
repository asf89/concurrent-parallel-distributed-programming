package school.cesar.sd.messageproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer implements CommandLineRunner {
    
    @Autowired
    RabbitTemplate template;
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        template.convertAndSend("fanout-exchange", "", "Hello world " + System.currentTimeMillis());
    }
    
}