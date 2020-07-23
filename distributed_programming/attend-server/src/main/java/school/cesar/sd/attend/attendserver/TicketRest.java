package school.cesar.sd.attend.attendserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketRest {

    @Autowired
    private TicketController controller;

    @PostMapping("/requisitar")
    public Ticket requisitarTicket(RequisicaoTicket requisicao) {
        try {
            Thread.currentThread().sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return controller.solicitarTicket(requisicao.getFila());
    }

    public Ticket chamarProximoTicket() {
        return null;
    }

    public Ticket consultarTicket() {
        return null;
    }

}