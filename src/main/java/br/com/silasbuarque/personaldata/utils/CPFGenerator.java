package br.com.silasbuarque.personaldata.utils;

import br.com.silasbuarque.personaldata.model.request.PersonRequest;

import java.util.Random;

public class CPFGenerator {
    public static String generate(PersonRequest personRequest) {
        int[] digits = new int[11];
        Random random = new Random();

        // Gera os 9 primeiros dígitos aleatórios
        for (int i = 0; i < 9; i++) {
            digits[i] = random.nextInt(10);
        }

        digits[5] = personRequest.getSextoDigito(); // Fixa o sexto dígito como 8
        digits[6] = personRequest.getSétimoDigito(); // Fixa o sétimo dígito como 6

        // Calcula o primeiro dígito verificador
        digits[9] = calculateVerifierDigit(digits, 10);

        // Calcula o segundo dígito verificador
        digits[10] = calculateVerifierDigit(digits, 11);

        // Formata o CPF no formato XXX.XXX.XXX-XX
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
