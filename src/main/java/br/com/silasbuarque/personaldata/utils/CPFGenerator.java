package br.com.silasbuarque.personaldata.utils;

import br.com.silasbuarque.personaldata.model.request.PersonRequest;

import java.util.Random;

public class CPFGenerator {
    public static String generate(PersonRequest personRequest) {
        int[] digits = new int[11];
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            digits[i] = random.nextInt(10);
        }

        digits[5] = personRequest.getSextoDigito();
        digits[6] = personRequest.getSetimoDigito();

        digits[9] = calculateVerifierDigit(digits, 10);

        digits[10] = calculateVerifierDigit(digits, 11);

        StringBuilder cpf = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            if (i == 3 || i == 6) {
                cpf.append('.');
            } else if (i == 9) {
                cpf.append('-');
            }
            cpf.append(digits[i]);
        }

        return cpf.toString();
    }

    private static int calculateVerifierDigit(int[] digits, int length) {
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            sum += digits[i] * (length - i);
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }
}
