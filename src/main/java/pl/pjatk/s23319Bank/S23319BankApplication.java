package pl.pjatk.s23319Bank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S23319BankApplication {
    public S23319BankApplication(BankService bankService) {
        bankService.registerUser("1", 2500.0);
        bankService.registerUser("2", 100.0);

        System.out.println(bankService.processTransfer("1", 1000.0));
        System.out.println(bankService.processTransfer("1", 5000.0));
        System.out.println(bankService.deposit("2", 500.0));
        System.out.println(bankService.getUserDetails("1"));
        System.out.println(bankService.getUserDetails("2"));
    }

    public static void main(String[] args) {
        SpringApplication.run(S23319BankApplication.class, args);
    }
}
