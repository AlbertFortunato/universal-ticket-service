package com.br.crud.ticket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.br.crud.ticket.model.TicketEntity;

@Service
public class TicketService {

    private final DynamoDBMapper mapper;


    public TicketService(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }


    public void saveTicket(TicketEntity ticketEntity){
        mapper.save(ticketEntity);
    }

    public TicketEntity getTicket(String openedBy, Long openedAt) {

    Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
    eav.put(":v1", new AttributeValue().withS(openedBy));
    eav.put(":v2",new AttributeValue().withN(openedAt.toString()));

    DynamoDBQueryExpression<TicketEntity> queryExpression = new DynamoDBQueryExpression<TicketEntity>()
        .withKeyConditionExpression("openedBy = :v1 and openedAt = :v2")
        .withExpressionAttributeValues(eav);

    List<TicketEntity> latestReplies = mapper.query(TicketEntity.class, queryExpression);

    return latestReplies.get(0);
    
    }

}
