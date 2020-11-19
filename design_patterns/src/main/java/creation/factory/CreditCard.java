package creation.factory;

public abstract class CreditCard {
    protected double balance;
    protected String name;

    public CreditCard(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void calculateBalance(Double amount) {
        if (amount >= balance) {
            System.out.println("There is no enough money on your credit card");
            return;
        }
        Double rate = getRate();
        Double resultAmount = balance - (amount + (amount * rate / 100));
        if (resultAmount < 0) {
            System.out.println("There is no enough money on your credit card");
            return;
        }
        balance = resultAmount;
        System.out.printf("Transaction complete: Card: %s, Amount: %s, cash rate: %s", getName(), getBalance(), getRate());
    }

    protected abstract Double getRate();
}
