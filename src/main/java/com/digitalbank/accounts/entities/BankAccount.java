package com.digitalbank.accounts.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class BankAccount {

    @EqualsAndHashCode.Include
    private String id;
    private String aliasAccountNumber;
    private String branch;
    private String type;
    private BigDecimal balance;
    private BigDecimal creditLimit;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
