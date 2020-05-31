package school.cesar.sd.cart.cartClient;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    static final String fanoutExchangeName = "fanout-exchange";

    static final String queueName = "Carrinho de compras";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(fanoutExchangeName);
    }
    
}