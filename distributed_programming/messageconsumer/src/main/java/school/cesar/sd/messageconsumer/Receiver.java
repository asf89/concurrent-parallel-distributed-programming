package school.cesar.sd.messageconsumer;

import org.springframework.stereotype.Component;

@Component
public class Receiver {
    public void receiveMessage(String message) {
        System.out.println("Message Received " + message);        
    }
}