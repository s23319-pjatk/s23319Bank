package pl.pjatk.s23319Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class BankServiceTest {

    private BankStorage bankStorage;
    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankStorage = mock(BankStorage.class);
        bankService = new BankService(bankStorage);
    }

    @Test
    void registerUser_shouldAddNewUser() {
        //GIVEN
        String userId = "1";
        double initialBalance = 1000.0;
        when(bankStorage.checkUserExist(userId)).thenReturn(false);

        //WHEN
        bankService.registerUser(userId, initialBalance);

        //THEN
        verify(bankStorage, times(1)).addUser(any(User.class));
    }

    @Test
    void registerUser_shouldNotAddExistingUser() {
        //GIVEN
        String userId = "1";
        double initialBalance = 1000.0;
        when(bankStorage.checkUserExist(userId)).thenReturn(true);

        //WHEN
        bankService.registerUser(userId, initialBalance);

        //THEN
        verify(bankStorage, never()).addUser(any(User.class));
    }
}