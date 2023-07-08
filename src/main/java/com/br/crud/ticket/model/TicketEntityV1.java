package com.br.crud.ticket.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ticket")
public class TicketEntityV1 {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "title")
    private String description;

    @Column(name = "description")
    private String openedBy;

    @Column(name = "opened_by")
    private String closedBy;

    @Column(name = "closed_by")
    private Integer openedAt;

    @Column(name = "opened_at")
    private Integer closedAt;

    @PrePersist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
