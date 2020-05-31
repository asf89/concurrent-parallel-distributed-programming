package school.cesar.sd.cart.cartClient;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Cart implements CommandLineRunner {

    @Autowired
    RabbitTemplate template;
    public void run(String[] args) throws Exception {

    }
    
}