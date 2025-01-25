package pl.pjatk.s23319Bank;

public class User {
    private final String userId;
    private double balance;

    public User(String userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
