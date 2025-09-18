package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankCardAcceptor extends MoneyAcceptor {
    private String cardNumber;
    private String cardOTP;

    public BankCardAcceptor() {
        super();
        this.name = "card";
    }

    @Override
    public int addBalance() {
        if (getCardNumber().equalsIgnoreCase("h") || getCardOTP().equalsIgnoreCase("h")) {
            return -1;
        } else {
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

    private String getCardNumber() {
        String cardNumber;
        boolean isEmpty, isValid = false;
        do {
            System.out.print("Введите номер карты (или h - для отмены): ");
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

    private String getCardOTP() {
        String cardOTP;
        boolean isEmpty, isValid = false;
        do {
            System.out.print("Введите одноразовый пароль для карты (или h - для отмены): ");
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
