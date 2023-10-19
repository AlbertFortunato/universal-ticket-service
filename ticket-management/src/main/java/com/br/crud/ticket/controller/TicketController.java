package com.br.crud.ticket.controller;

import com.br.crud.ticket.model.CloseTicketDTO;
import com.br.crud.ticket.model.OpenTicketDTO;
import com.br.crud.ticket.model.TicketEntity;
import com.br.crud.ticket.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
//
@GetMapping("/ticket")
public ResponseEntity<TicketEntity> getTicket(
        @PathParam("openedBy") String openedBy,
        @PathParam("openedAt") Long openedAt
) {
    
    TicketEntity ticket = ticketService.getTicket(openedBy, openedAt);
    if (ticket != null) {
        return ResponseEntity.ok(ticket);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    @DeleteMapping("/ticket")
    public ResponseEntity<Void> closeTicket(
        @RequestBody CloseTicketDTO closeTicketDTO
    ){
        String openedBy = closeTicketDTO.getOpenedBy();
        Long openedAt = closeTicketDTO.getOpenedAt();

        TicketEntity ticket = ticketService.getTicket(openedBy, openedAt);
        ticket.closeTicket();
        ticketService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/ticket")
    public ResponseEntity<Void> openTicket(
        @RequestBody OpenTicketDTO openTicketDTO
    ){
        String openedBy = SecurityContextHolder
                            .getContext()
                            .getAuthentication()
                            .getName();
        String description = openTicketDTO.getDescription();
        
        TicketEntity ticket = new TicketEntity(openedBy, description);
        ticketService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
