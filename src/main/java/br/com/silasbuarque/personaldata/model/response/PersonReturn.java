package br.com.silasbuarque.personaldata.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonReturn {

    private String name;
    private String cpf;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private Address address;
    private Bank bank;
    private String plate;

}
