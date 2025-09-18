package model;

public class BankCardAcceptor extends MoneyAcceptor {
    private String cardNumber;
    private String cardPassword;

    public BankCardAcceptor() {
        super();
        this.name = "card";
    }
}
