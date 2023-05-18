package br.com.silasbuarque.personaldata.service;

import br.com.silasbuarque.personaldata.model.response.PersonReturn;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class GeneratePersonServiceImpl implements GeneratePersonService{

    Faker faker = new Faker(new Locale("pt-BR"));

    @Override
    public PersonReturn getPerson() {

        PersonReturn personReturn = new PersonReturn();
        personReturn.setName(getName());
        personReturn.setCpf(getCpf());
        personReturn.setDateOfBirth(getDateOfBirth());
        personReturn.setPhoneNumber(getPhoneNumber());
        personReturn.setEmail(getEmail(personReturn.getName()));

        return personReturn;
    }

    public String getName() {
        return faker.name().name();
    }

    public String getCpf() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pt-BR"), new RandomService());
        return fakeValuesService.numerify("###.##8.6##-##");
    }

    public String getDateOfBirth() {
        LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return birthday.format(formatter);
    }

    public String getEmail(String name) {
        return faker.internet().emailAddress(name);
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

}
