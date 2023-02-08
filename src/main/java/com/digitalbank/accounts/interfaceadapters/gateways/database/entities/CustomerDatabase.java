package com.digitalbank.accounts.interfaceadapters.gateways.database.entities;

import com.digitalbank.accounts.entities.Address;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CustomerDatabase {

    @Id
    private String id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String phone;
    private String motherName;
    private Date birthDate;
    private Double income;
    @OneToMany
    @JoinColumn(name = "BANK_ACCOUNT_ID")
    private List<BankAccountDatabase> bankAccounts;
    @Embedded
    private Address address;
}
