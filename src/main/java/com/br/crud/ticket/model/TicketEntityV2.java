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

    @DynamoDBHashKey
    private String userId;

    @DynamoDBRangeKey
    @DynamoDBAttribute
    private Long openedAt;

    @DynamoDBAttribute
    private Long closedAt;

    @DynamoDBAttribute
    private String description;

    @DynamoDBAttribute
    private String openedBy;

    @DynamoDBAttribute
    private String closedBy;

    @PrePersist
    private void prePersist() {
        if (userId == null) {
            userId = UUID.randomUUID().toString();
        }
        if (openedAt == null){
            Date date = new Date();
            openedAt = date.getTime();
        }
    }
}
