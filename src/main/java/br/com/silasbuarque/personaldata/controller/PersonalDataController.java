package br.com.silasbuarque.personaldata.controller;

import br.com.silasbuarque.personaldata.model.response.PersonReturn;
import br.com.silasbuarque.personaldata.service.GeneratePersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class PersonalDataController {

    private final GeneratePersonService generatePersonService;

    public PersonalDataController(GeneratePersonService generatePersonService) {
        this.generatePersonService = generatePersonService;
    }

    @GetMapping("/person")
    public PersonReturn getPerson(){
        return generatePersonService.getPerson();
    }

}
