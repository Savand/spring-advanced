package beans.models;

import java.util.Objects;

public class UserAccount {

    private Long userId;
    private Double amount = 0.0;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void chargeAmount(Double amount) {
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
