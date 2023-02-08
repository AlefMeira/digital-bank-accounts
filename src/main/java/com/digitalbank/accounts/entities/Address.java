package com.digitalbank.accounts.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String city;
    private String street;
    private String neighborhood;
    private String complement;
    private Integer number;
    private String stateCode;
    private String zipCode;
}
