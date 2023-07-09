package com.br.crud.ticket.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@DynamoDBTable(tableName = "r00_ticket")
public class TicketEntityV2 {

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

    @DynamoDBIgnore
    @PrePersist
    private void prePersist() {
        if (userId == null) {
            userId = UUID.randomUUID().toString();
        }
        if (openedAt == null){
            openedAt = new Date().getTime();
        }
    }
}
