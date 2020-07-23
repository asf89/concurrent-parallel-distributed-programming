package school.cesar.sd.atend.imp;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.util.Arrays;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

public class Imp {

    public static void main(String[] args) {

        TicketService service = JAXRSClientFactory.create("http://localhost:8080", TicketService.class, Arrays.asList(new JacksonJsonProvider()));
        TicketRequest request = new TicketRequest();
        request.setFila("preferencial");
        Ticket ticket = service.requestTicket(request);
        System.out.println(ticket.getNumero());

    }

}