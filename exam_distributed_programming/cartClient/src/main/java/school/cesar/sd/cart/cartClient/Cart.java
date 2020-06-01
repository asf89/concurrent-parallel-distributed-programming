package school.cesar.sd.cart.cartClient;

import java.util.ArrayList;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Cart implements CommandLineRunner {

    @Autowired
    RabbitTemplate template;

    @Override
    public void run(String... args) throws Exception {

        ArrayList<String> skus = new ArrayList<String>();
        skus.add("kjp12");
        skus.add("mvn48");
        skus.add("crz8s");

        Customer customer = new Customer("asf@email.com", "80471-962", skus, 671.80); 

        System.out.println("Sending cart data...");

        template.convertAndSend("Shopping Cart", customer);

        System.out.println("Data sent.");

    }
    
}