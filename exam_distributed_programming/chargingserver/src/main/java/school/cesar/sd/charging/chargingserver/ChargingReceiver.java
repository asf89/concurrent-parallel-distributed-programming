package school.cesar.sd.charging.chargingserver;

import org.springframework.stereotype.Component;

@Component
public class ChargingReceiver {

    
    public void chargingReceiveMessage(String customer) {
        System.out.println(customer);
    }
    
}