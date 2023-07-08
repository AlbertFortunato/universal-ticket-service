package com.br.crud.ticket.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.br.crud.ticket.model.TicketEntityV1;
import com.br.crud.ticket.model.TicketEntityV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

//    private final TicketRepository repository;

    private final DynamoDBMapper mapper;


    public TicketService(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }
//
//
//    //Realiza a consulta do ID do ticket
//    public TicketEntityV1 getTicket(String id){
//        return repository.findById(id).orElse(null);
//    }

    //Realiza o cadastro do ticket
    public void createTicket(TicketEntityV2 ticketEntityV2){
        mapper.save(ticketEntityV2);
    }
}
