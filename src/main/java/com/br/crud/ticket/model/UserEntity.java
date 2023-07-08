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

@DynamoDBTable(tableName = "r00_user")
public class UserEntity {

    @DynamoDBHashKey
    private String userId;

    @DynamoDBAttribute
    private Long createdAt;

    @DynamoDBAttribute
    private Boolean isActive;

    @PrePersist
    private void prePersist() {
        if (userId == null) {
            userId = UUID.randomUUID().toString();
        }
        if (createdAt == null){
            Date date = new Date();
            createdAt = date.getTime();
        }
    }
}
