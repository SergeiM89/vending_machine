package model;

public abstract class MoneyAcceptor {
    protected int amount;
    protected String name;

    protected MoneyAcceptor() {
        this.amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

