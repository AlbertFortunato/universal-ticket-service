package com.br.crud.ticket.repository;

import com.br.crud.ticket.model.TicketEntityV1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntityV1, String> {
}
