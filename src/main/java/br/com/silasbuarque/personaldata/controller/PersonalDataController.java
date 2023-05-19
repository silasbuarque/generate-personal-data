package br.com.silasbuarque.personaldata.controller;

import br.com.silasbuarque.personaldata.model.request.PersonRequest;
import br.com.silasbuarque.personaldata.model.response.PersonReturn;
import br.com.silasbuarque.personaldata.service.GeneratePersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generate")
public class PersonalDataController {

    private final GeneratePersonService generatePersonService;

    public PersonalDataController(GeneratePersonService generatePersonService) {
        this.generatePersonService = generatePersonService;
    }

    @PostMapping("/person")
    public PersonReturn getPerson(@RequestBody PersonRequest personRequest){
        return generatePersonService.getPerson(personRequest);
    }

}
