package com.digitalbank.accounts.entities;

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
public class Customer {

    private String id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String phone;
    private String motherName;
    private Date birthDate;
    private Double income;
    private List<BankAccount> bankAccounts;
    private Address address;
}
