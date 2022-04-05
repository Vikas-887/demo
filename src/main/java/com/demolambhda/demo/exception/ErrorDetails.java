package com.demolambhda.demo.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    
   private String details;
   private Date timestamp;
   private String detail;

}
