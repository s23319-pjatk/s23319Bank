package pl.pjatk.s23319Bank;

public class Transaction {
    private final String status;
    private final String message;
    private final double newBalance;

    public Transaction(String status, String message, double newBalance) {
        this.status = status;
        this.message = message;
        this.newBalance = newBalance;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public double getNewBalance() {
        return newBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", newBalance=" + newBalance +
                '}';
    }
}
