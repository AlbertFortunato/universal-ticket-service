package com.br.crud.ticket.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@DynamoDBTable(tableName = "r00_ticket")
public class TicketEntity {

    @DynamoDBHashKey(attributeName = "userId")
    private String userId;

    @DynamoDBRangeKey(attributeName = "openedAt")
    private Long openedAt;

    @DynamoDBAttribute(attributeName = "closedAt")
    private Long closedAt;

    @DynamoDBAttribute(attributeName = "description")
    private String description;

    @DynamoDBAttribute(attributeName = "openedBy")
    private String openedBy;

    @DynamoDBAttribute(attributeName = "closedBy")
    private String closedBy;

}
