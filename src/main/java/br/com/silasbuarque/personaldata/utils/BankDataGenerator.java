package br.com.silasbuarque.personaldata.utils;
import java.util.Random;

public class BankDataGenerator {
    private static final String[] BANK_CODES = {"001", "237", "341", "033", "104"}; // Códigos dos bancos
    private static final String[] BANK_NAMES = {"Banco do Brasil", "Bradesco", "Itaú", "Santander", "Caixa"}; // Nomes dos bancos

    public static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    public static String generateAgencyNumber() {
        Random random = new Random();
        StringBuilder agencyNumber = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);
            agencyNumber.append(digit);
        }

        return agencyNumber.toString();
    }

    public static String generateBankCode() {
        Random random = new Random();
        int index = random.nextInt(BANK_CODES.length);
        return BANK_CODES[index];
    }

    public static String generateBankName() {
        Random random = new Random();
        int index = random.nextInt(BANK_NAMES.length);

        return BANK_NAMES[index];
    }
}

