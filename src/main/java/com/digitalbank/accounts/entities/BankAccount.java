package com.digitalbank.accounts.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    private String id;
    private String aliasAccountNumber;
    private String branch;
    private String type;
    private Double balance;
    private Double creditLimit;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
