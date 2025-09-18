package model;

public abstract class MoneyAcceptor {
    protected int amount;
    protected String name;

    protected MoneyAcceptor() {
        this.amount = 0;
    }

    public abstract int addBalance();
    public abstract String showBalance();

    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

