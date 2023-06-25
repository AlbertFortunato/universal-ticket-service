package com.br.crud.ticket.controller;

import com.br.crud.ticket.model.TicketEntity;
import com.br.crud.ticket.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/ticket")
    public ResponseEntity<TicketEntity> getTicket(@PathParam("id") String id){
        TicketEntity ticket = ticketService.getTicket(id);
        if(ticket != null)
            return ResponseEntity.ok(ticket);
        else {
        return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/ticket")
    public ResponseEntity<TicketEntity> save(@RequestBody TicketEntity ticketEntity){
        TicketEntity savedTicket = ticketService.save(ticketEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }
}
