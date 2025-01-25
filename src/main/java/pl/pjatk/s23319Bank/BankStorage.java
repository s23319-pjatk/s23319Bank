package pl.pjatk.s23319Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankStorage {
    private final List<User> users = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public BankStorage() {
        this.users.add(new User("5", 5000.0));
        this.users.add(new User("6", 50.0));
        this.users.add(new User("7", 1519.0));
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean checkUserExist(String userId) {
        return users.stream().anyMatch(user -> user.getUserId().equals(userId));
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserById(String userId) {
        return users.stream()
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElse(null);
    }
}