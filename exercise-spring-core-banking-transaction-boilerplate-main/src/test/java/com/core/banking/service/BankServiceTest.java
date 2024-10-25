package com.core.banking.service;

import com.core.banking.model.Account;
import com.core.banking.service.BankService;
import junit.framework.TestCase;

public class BankServiceTest extends TestCase {

    private BankService bankService;
    private Account account;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bankService = new BankService();
        account = new Account();
        bankService.setAccount(account);
    }

    public void testCheckAccountBalance() {
        assertEquals(0.0, bankService.checkAccountBalance());
    }

    public void testDeposit() {
        bankService.deposit(100.0);
        assertEquals(100.0, bankService.checkAccountBalance());
    }

    public void testWithdrawWithSufficientFunds() {
        bankService.deposit(100.0);
        assertTrue(bankService.withdraw(50.0));
        assertEquals(50.0, bankService.checkAccountBalance());
    }

    public void testWithdrawWithInsufficientFunds() {
        bankService.deposit(50.0);
        assertFalse(bankService.withdraw(100.0));
        assertEquals(50.0, bankService.checkAccountBalance());
    }
}
