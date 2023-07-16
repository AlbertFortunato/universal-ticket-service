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

@DynamoDBTable(tableName = "r00_user")
public class UserEntity {

    @DynamoDBHashKey
    private String userId;

    @DynamoDBAttribute
    private Long createdAt;

    @DynamoDBAttribute
    private Boolean isActive;

}
