package com.digitalbank.accounts.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    private String city;
    private String street;
    private String neighborhood;
    private String complement;
    private Integer number;
    private String stateCode;
    private String zipCode;
}
