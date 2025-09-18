package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankCardAcceptor extends MoneyAcceptor {
    private String cardNumber;
    private String cardOTP;

    public BankCardAcceptor() {
        super();
        this.name = "card";
        this.cardNumber = "";
        this.cardOTP = "";
    }

    @Override
    public int addBalance() {
        String cardNumberNew;
        String cardOTPNew;

        if (this.cardNumber.isEmpty() && this.cardOTP.isEmpty()) {
            cardNumberNew = askCardNumber();
            if (cardNumberNew.equalsIgnoreCase("h")) {
                return -1;
            }
            cardOTPNew = askCardOTP();
            if (cardOTPNew.equalsIgnoreCase("h")) {
                return -1;
            }
            this.cardNumber = cardNumberNew;
            this.cardOTP = cardOTPNew;
            System.out.println("Ваша карта сохранена.");
        }

        while (true) {
            System.out.print("Сколько денег хотите закинуть на баланс: ");
            try {
                int amount = new Scanner(System.in).nextInt();
                if (amount <= 0) {
                    throw new IllegalArgumentException("Введите положительное число. Попробуйте еще раз.");
                }
                return amount;
            } catch (InputMismatchException ime) {
                System.out.println("Вы ввели нецелое число или строку.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

    }

    @Override
    public String showBalance() {
        return "Баланс на счету: " + this.getAmount();
    }

    private static boolean isValidCardFormat(String cardNumber) {
        return cardNumber.matches("\\d{16}");
    }

    private static boolean isValidOTPFormat(String cardNumber) {
        return cardNumber.matches("\\d{6}");
    }

    private String askCardNumber() {
        String cardNumber;
        boolean isEmpty, isValid = false;
        do {
            System.out.print("Введите номер карты (16 цифр или \"h\" - для отмены): ");
            cardNumber = new Scanner(System.in).nextLine().trim();
            isEmpty = cardNumber.isBlank();
            if (isEmpty) {
                System.out.println("Вы ввели пустую строку. Попробуйте еще раз.");
                continue;
            }
            if (cardNumber.equalsIgnoreCase("h")) {
                return cardNumber;
            }
            isValid = isValidCardFormat(cardNumber);
            if (!isValid) {
                System.out.println("Неверный номер карты. Попробуйте еще раз.");
            }
        } while (isEmpty || !isValid);
        return cardNumber;
    }

    private String askCardOTP() {
        String cardOTP;
        boolean isEmpty, isValid = false;
        do {
            System.out.print("Введите одноразовый пароль для карты (6 цифр или \"h\" - для отмены): ");
            cardOTP = new Scanner(System.in).nextLine().trim();
            isEmpty = cardOTP.isBlank();
            if (isEmpty) {
                System.out.println("Вы ввели пустую строку. Попробуйте еще раз.");
                continue;
            }
            if (cardOTP.equalsIgnoreCase("h")) {
                return cardOTP;
            }
            isValid = isValidOTPFormat(cardOTP);
            if (!isValid) {
                System.out.println("Неверный OTP код карты. Попробуйте еще раз.");
            }
        } while (isEmpty || !isValid);
        return cardOTP;
    }
}
