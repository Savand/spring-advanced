package beans.models;

import java.util.Objects;

public class UserAccount {

    private long id;
    private double amount;

    public UserAccount() {
    }

    public UserAccount(double amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void chargeAmount(double amount) {
        this.amount += amount;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAccount that = (UserAccount) o;
        return Double.compare(that.amount, amount) == 0;
    }

    @Override public int hashCode() {

        return Objects.hash(amount);
    }

    @Override public String toString() {
        return "UserAccount{" +
               "amount=" + amount +
               '}';
    }
}
