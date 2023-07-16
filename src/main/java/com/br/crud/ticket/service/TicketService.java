package com.br.crud.ticket.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.br.crud.ticket.model.TicketEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final DynamoDBMapper mapper;


    public TicketService(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }


    //Realiza o cadastro do ticket
    public void createTicket(TicketEntity ticketEntity){
        mapper.save(ticketEntity);
    }

    //Realiza a consulta do ticket
    public TicketEntity getTicket(String userId, Long openedAt) {
        return mapper.load(TicketEntity.class, userId, openedAt);
    }

}
