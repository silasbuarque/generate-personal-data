package br.com.silasbuarque.personaldata.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String streetName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}
