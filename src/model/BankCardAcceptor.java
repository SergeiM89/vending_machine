package model;

public class BankCardAcceptor extends MoneyAcceptor {
    private long cardNumber;
    private String cardPassword;

    public BankCardAcceptor() {
        super();
        this.name = "card";
    }
}
