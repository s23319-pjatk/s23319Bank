package pl.pjatk.s23319Bank;

public class Order {
    private static int count = 0;
    private final int orderId;
    private final User user;
    private final double cash;
    private final String status;

    public Order(User user, double cash, String status) {
        this.orderId = ++count;
        this.user = user;
        this.cash = cash;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public double getCash() {
        return cash;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", cash=" + cash +
                ", status='" + status + '\'' +
                '}';
    }
}
