package com.br.crud.ticket.service;

import com.br.crud.ticket.model.TicketEntity;
import com.br.crud.ticket.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }


    //Realiza a consulta do ID do ticket
    public TicketEntity getTicket(String id){
        return repository.findById(id).orElse(null);
    }

    //Realiza o cadastro do ticket
    public TicketEntity save(TicketEntity ticketEntity){
        return repository.save(ticketEntity);
    }
}
