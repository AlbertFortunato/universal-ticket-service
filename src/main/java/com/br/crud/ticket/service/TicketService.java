package com.br.crud.ticket.service;

import com.br.crud.ticket.model.TicketEntityV1;
import com.br.crud.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }


    //Realiza a consulta do ID do ticket
    public TicketEntityV1 getTicket(String id){
        return repository.findById(id).orElse(null);
    }

    //Realiza o cadastro do ticket
    public TicketEntityV1 save(TicketEntityV1 ticketEntityV1){
        return repository.save(ticketEntityV1);
    }
}
