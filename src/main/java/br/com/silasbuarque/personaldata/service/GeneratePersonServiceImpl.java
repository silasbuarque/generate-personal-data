package br.com.silasbuarque.personaldata.service;

import br.com.silasbuarque.personaldata.model.request.PersonRequest;
import br.com.silasbuarque.personaldata.model.response.Address;
import br.com.silasbuarque.personaldata.model.response.Bank;
import br.com.silasbuarque.personaldata.model.response.PersonReturn;
import br.com.silasbuarque.personaldata.utils.BankDataGenerator;
import br.com.silasbuarque.personaldata.utils.CPFGenerator;
import br.com.silasbuarque.personaldata.utils.PlateGenerate;
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

        Address address = new Address();
        address.setStreetName(faker.address().streetName());
        address.setStreetAddress(faker.address().streetAddress());
        address.setCity(faker.address().city());
        address.setState(faker.address().state());
        address.setZipCode(faker.address().zipCode());
        address.setCountry(faker.address().country());
        personReturn.setAddress(address);

        Bank bank = new Bank();
        bank.setBankCode(BankDataGenerator.generateBankCode());
        bank.setBankName(BankDataGenerator.generateBankName());
        bank.setAccountNumber(BankDataGenerator.generateAccountNumber());
        bank.setAgencyNumber(BankDataGenerator.generateAgencyNumber());

        personReturn.setBank(bank);

        personReturn.setPlate(PlateGenerate.generatePlates());

        return personReturn;
    }
}
