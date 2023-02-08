package com.digitalbank.accounts.interfaceadapters.gateways.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BankAccountDatabase {

    @Id
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
