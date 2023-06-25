package com.br.crud.ticket.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandarError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandarError(Instant timestamp, Integer status, String error, String message) {
        this.timestamp = timestamp.toEpochMilli();
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
