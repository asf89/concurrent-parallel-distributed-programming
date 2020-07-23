package school.cesar.sd.attend.attendserver;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TicketController {

    private Map<String, Integer> filas = new HashMap<String,Integer>();

    public Ticket solicitarTicket(String fila) {
        Ticket ticket = new Ticket();

        synchronized (filas) {
            ticket.setFila(fila);
            Integer atual = filas.get(fila);
            if (atual == null) {
                ticket.setNumero(1);
                filas.put(fila, 1);
            } else {
                ticket.setNumero(++atual);
                filas.put(fila, atual);
            }
        }
        return ticket;
    }

    public Ticket chamarProximoTicket() {
        return null;
    }

    public List<Ticket> consultarTicket() {
        return null;
    }
}