package com.gitmuts.messagebrokers.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Customer {
    private String name;
    private Date dob;
    private BigDecimal balance;
    private String job;
    private String address;
    private String phoneNumber;
    private Integer idNumber;
}
