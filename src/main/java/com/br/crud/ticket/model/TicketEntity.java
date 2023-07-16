package com.br.crud.ticket.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Getter;
import java.util.Date;

@Getter
@DynamoDBTable(tableName = "r00_ticket")
public class TicketEntity {

    @DynamoDBHashKey(attributeName = "openedBy")
    private String openedBy;

    @DynamoDBRangeKey(attributeName = "openedAt")
    private Long openedAt;

    @DynamoDBAttribute(attributeName = "owneredBy")
    private String owneredBy;

    @DynamoDBAttribute(attributeName = "closedAt")
    private Long closedAt;

    @DynamoDBAttribute(attributeName = "description")
    private String description;

    public TicketEntity(
        String openedBy, 
        String description
        ) {
            this.openedBy = openedBy;
            this.description = description;
            this.openedAt = new Date().getTime();
    }

    public void closeTicket(){
        this.closedAt = new Date().getTime();
    }

    public void changeOwner(
        String owner
    ){
        this.owneredBy = owner;
    }
}
