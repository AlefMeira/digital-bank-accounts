package com.digitalbank.accounts.interfaceadapters.gateways.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "BANK_ACCOUNT")
public class BankAccountDatabase {

    @Column(name = "ID", updatable = false)
    @Id
    private String id;
    @Column(name = "ALIAS_ACCOUNT_NUMBER", length = 12)
    private String aliasAccountNumber;
    @Column(name = "BRANCH", length = 12)
    private String branch;
    @Column(name = "TYPE", length = 10)
    private String type;
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Column(name = "CREDIT_LIMIT")
    private BigDecimal creditLimit;
    @Column(name = "STATUS", length = 12)
    private String status;
    @Column(name = "CREATE_AT", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;
}
