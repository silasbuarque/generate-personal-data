package br.com.silasbuarque.personaldata.service;

import br.com.silasbuarque.personaldata.model.request.PersonRequest;
import br.com.silasbuarque.personaldata.model.response.Bank;
import br.com.silasbuarque.personaldata.model.response.PersonReturn;
import br.com.silasbuarque.personaldata.utils.BankDataGenerator;
import br.com.silasbuarque.personaldata.utils.CPFGenerator;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

@Service
public class GeneratePersonServiceImpl implements GeneratePersonService{

    @Override
    public PersonReturn getPerson(PersonRequest personRequest) {

        Faker faker = new Faker(new Locale("pt-BR"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("pt-BR"), new RandomService());
        LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        PersonReturn personReturn = new PersonReturn();
        personReturn.setName(faker.name().name());

        String cpf = CPFGenerator.generate(personRequest);
        personReturn.setCpf(cpf);

        personReturn.setDateOfBirth(birthday.format(formatter));
        personReturn.setPhoneNumber(faker.phoneNumber().cellPhone());

        String name = personReturn.getName();
        String dominio = "gmail.com";
        String email = name.toLowerCase().replace(" ", "") + "@" + dominio;
        personReturn.setEmail(email);

        personReturn.setAddress(faker.address().fullAddress());

        Bank bank = new Bank();
        bank.setBankCode(BankDataGenerator.generateBankCode());
        bank.setBankName(BankDataGenerator.generateBankName());
        bank.setAccountNumber(BankDataGenerator.generateAccountNumber());
        bank.setAgencyNumber(BankDataGenerator.generateAgencyNumber());

        personReturn.setBank(bank);

        return personReturn;
    }
}
