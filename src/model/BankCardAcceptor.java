package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankCardAcceptor extends MoneyAcceptor {
    private String cardNumber;
    private String cardPassword;

    public BankCardAcceptor() {
        super();
        this.name = "card";
    }

    @Override
    public int addBalance() {
        while (true) {
            System.out.print ("Сколько денег хотите закинуть на баланс: ");
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



}
