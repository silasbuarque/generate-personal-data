package br.com.silasbuarque.personaldata.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequest {

    private int sextoDigito;
    private int setimoDigito;

}
