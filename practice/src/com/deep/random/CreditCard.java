package com.deep.random;

public class CreditCard {

    private static final char MASKED_CHARACTER = '#';
    public static String musk(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 6) {
            return cardNumber;
        }

        StringBuilder maskedNumber = new StringBuilder();
        for (int cardCharacterIndex = 0; cardCharacterIndex < cardNumber.length(); cardCharacterIndex++) {
            char character = cardNumber.charAt(cardCharacterIndex);
            if (cardCharacterIndex == 0 || cardCharacterIndex > cardNumber.length() - 5) {
                maskedNumber.append(character);
                continue;
            }
            if (Character.isDigit(character)) {
                maskedNumber.append(MASKED_CHARACTER);
            } else {
                maskedNumber.append(character);
            }
        }

        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        System.out.println(CreditCard.musk(""));
    }
}
