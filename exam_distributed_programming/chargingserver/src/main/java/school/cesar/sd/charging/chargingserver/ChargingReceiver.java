package school.cesar.sd.charging.chargingserver;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ChargingReceiver {

    private static final Logger log = LoggerFactory.getLogger(ChargingReceiver.class);

    public void chargingReceiveMessage(String customer) {
        //log.info("Charging info: {}", customer.toString());
        System.out.println(customer);
    }
    
}