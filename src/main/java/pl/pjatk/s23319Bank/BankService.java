package pl.pjatk.s23319Bank;

import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final BankStorage bankStorage;

    public BankService(BankStorage bankStorage) {
        this.bankStorage = bankStorage;
    }

    public void registerUser(String userId, double balance) {
        if (!bankStorage.checkUserExist(userId)) {
            bankStorage.addUser(new User(userId, balance));
            System.out.println("Użytkownik zarejestrowany: " + userId);
        } else {
            System.out.println("Użytkownik o podanym ID już istnieje: " + userId);
        }
    }

    public Transaction processTransfer(String userId, double amount) {
        User user = bankStorage.findUserById(userId);
        if (user == null) {
            return new Transaction("DECLINED", "Użytkownik nie istnieje.", 0);
        }
        if (user.getBalance() < amount) {
            return new Transaction("DECLINED", "Brak wystarczających środków.", user.getBalance());
        }
        user.setBalance(user.getBalance() - amount);
        Order order = new Order(user, amount, "ACCEPTED");
        bankStorage.addOrder(order);
        return new Transaction("ACCEPTED", "Przelew wykonany.", user.getBalance());
    }


    public Transaction deposit(String userId, double amount) {
        User user = bankStorage.findUserById(userId);
        if (user == null) {
            return new Transaction("DECLINED", "Użytkownik nie istnieje.", 0);
        }
        user.setBalance(user.getBalance() + amount);
        return new Transaction("ACCEPTED", "Wpłata wykonana.", user.getBalance());
    }

    public User getUserDetails(String userId) {
        return bankStorage.findUserById(userId);
    }
}
