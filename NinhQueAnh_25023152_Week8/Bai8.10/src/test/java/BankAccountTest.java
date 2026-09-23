import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("123", "Quy", 500);
    }

    // =========================
    // TEST deposit
    // =========================

    @Test
    void testDepositValid() {
        account.deposit(100);
        assertEquals(600, account.getBalance());
    }

    @Test
    void testDepositBoundary1() {
        account.deposit(1);
        assertEquals(501, account.getBalance());
    }

    @Test
    void testDepositZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(0);
        });
    }

    @Test
    void testDepositNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }

    // =========================
    // TEST withdraw
    // =========================

    @Test
    void testWithdrawValid() {
        boolean result = account.withdraw(200);
        assertTrue(result);
        assertEquals(300, account.getBalance());
    }

    @Test
    void testWithdrawExactBalance() {
        boolean result = account.withdraw(500);
        assertTrue(result);
        assertEquals(0, account.getBalance());
    }

    @Test
    void testWithdrawTooMuch() {
        boolean result = account.withdraw(600);
        assertFalse(result);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(0);
        });
    }

    @Test
    void testWithdrawNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-10);
        });
    }
    @Test
    void testSequenceOperations() {
        BankAccount acc = new BankAccount("123", "Quy");

        acc.deposit(500);        // 500
        boolean r1 = acc.withdraw(200); // còn 300
        boolean r2 = acc.withdraw(400); // fail

        assertTrue(r1);
        assertFalse(r2);
        assertEquals(300, acc.getBalance());
    }
}