package br.com.silasbuarque.personaldata.service;

import br.com.silasbuarque.personaldata.model.request.PersonRequest;
import br.com.silasbuarque.personaldata.model.response.PersonReturn;

public interface GeneratePersonService {

    PersonReturn getPerson(PersonRequest personRequest);
}
