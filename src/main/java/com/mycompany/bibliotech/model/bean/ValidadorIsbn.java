package com.mycompany.bibliotech.model.bean;

public class ValidadorIsbn {

    public boolean valida(String isbn) {
        // Formata o ISBN removendo todos os '-' deixando somente os números.
        isbn = isbn.replace("-", "");

        // Verifica se o tamanho está correto e passa para o método de
        // verificação adequado caso sim.
        boolean isbnValido = false;

        isbnValido = switch (isbn.length()) {
            case 10 ->
                verificaIsbn10(isbn);
            case 13 ->
                verificaIsbn13(isbn);
            default ->
                false;
        };

        return isbnValido;
    }

    private static boolean verificaIsbn10(String isbn) {
        int soma = 0;
        String dString;
        for (int i = 0; i < 10; i++) {
            dString = isbn.substring(i, i + 1);
            if (i < 9 || !dString.equals("X")) {
                soma += Integer.parseInt(dString) * (10 - i);
            } else {
                soma += 10;
            }
        }
        return (soma % 11 == 0);
    }

    private static boolean verificaIsbn13(String isbn) {
        int soma = 0;
        int dVal;
        for (int i = 0; i < 13; i++) {
            dVal = Integer.parseInt(isbn.substring(i, i + 1));
            if (i % 2 == 0) {
                soma += dVal * 1;
            } else {
                soma += dVal * 3;
            }
        }
        return (soma % 10 == 0);

    }
}
