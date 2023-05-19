package br.com.silasbuarque.personaldata.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    private String bankName;
    private String bankCode;
    private String agencyNumber;
    private String accountNumber;

}
