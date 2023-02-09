package com.digitalbank.accounts.interfaceadapters.gateways.database.entities;

import com.digitalbank.accounts.entities.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CUSTOMER")
public class CustomerDatabase {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "ID", updatable = false)
    private String id;
    @Column(name = "NAME", length = 12)
    private String name;
    @Column(name = "LAST_NAME", length = 25)
    private String lastName;
    @Column(name = "DOCUMENT_NUMBER", length = 14)
    private String documentNumber;
    @Column(name = "PHONE", length = 11)
    private String phone;
    @Column(name = "MOTHER_NAME", length = 37)
    private String motherName;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name = "INCOME")
    private BigDecimal income;
    @Column(name = "BANK_ACCOUNTS")
    @OneToMany
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private List<BankAccountDatabase> bankAccounts;
    @Column(name = "ADDRESS")
    @Embedded
    private Address address;
}
