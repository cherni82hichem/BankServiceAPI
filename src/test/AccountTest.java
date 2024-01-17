package test;
import com.service.Account;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void depositShouldIncreaseBalance() {
        Account account = new Account();
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    public void withdrawShouldDecreaseBalance() {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    public void withdrawWithInsufficientFundsShouldThrowException() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(50));
    }

    @Test
    public void depositWithNegativeAmountShouldThrowException() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    public void withdrawWithNegativeAmountShouldThrowException() {
        Account account = new Account();
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    public void printStatementShouldIncludeDate() {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(50);
        String expected = "Date | Operation | Amount | Balance\n"
                + LocalDate.now() + " | Deposit | 100 | 100\n"
                + LocalDate.now() + " | Withdrawal | -50 | 50";
        assertEquals(expected, account.printStatement());
    }
}
