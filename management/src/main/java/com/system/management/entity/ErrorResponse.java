package com.system.management.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ErrorResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private int status;
    private String message;
    private long timestamp;
}
