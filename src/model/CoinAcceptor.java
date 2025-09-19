package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoinAcceptor extends MoneyAcceptor {

    public CoinAcceptor() {
       super();
       this.name = "coin";
    }

    @Override
    public int addBalance() {
        while (true) {
            System.out.print ("Сколько монет вы хотите закинуть: ");
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
        return "Монет на сумму: " + this.getAmount();
    }
}
