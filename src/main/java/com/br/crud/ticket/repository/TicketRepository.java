package com.br.crud.ticket.repository;

import com.br.crud.ticket.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketEntity, String> {
}
