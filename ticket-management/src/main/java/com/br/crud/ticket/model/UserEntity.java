package com.br.crud.ticket.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "r01_users")
public class UserEntity {

    @Id
    @GeneratedValue
    private java.util.UUID id;

    @Column
    private String UserName;

    @Column
    private String Password;

    @Column
    private String Email;

    @Column
    private String FirstName;

    @Column
    private String LastName;

    @Column
    private String Address;

    @Column
    private String City;

    @Column
    private String State;

    @Column
    private String Country;

    @Column
    private String PostalCode;

    @Column
    private Date CreatedAt;

    @Column
    private Date UpdatedAt;

    // TODO : Make enum for this column
    @Column
    private String Status;

    // TODO : Make enum for this column
    @Column
    private String Role;

}
