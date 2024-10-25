package com.core.banking.service;

import com.core.banking.model.Account;
import com.core.banking.service.AccountService;
import junit.framework.TestCase;

public class AccountServiceTest extends TestCase {

    private AccountService accountService;
    private Account account;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        accountService = new AccountService();
        account = new Account();
        accountService.setAccount(account);
    }

    public void testCheckAccountBalance() {
        assertEquals(0.0, accountService.checkAccountBalance());
    }

    public void testDeposit() {
        accountService.deposit(100.0);
        assertEquals(100.0, accountService.checkAccountBalance());
    }

    public void testWithdrawWithSufficientFunds() {
        accountService.deposit(100.0);
        accountService.withdraw(50.0);
        assertEquals(50.0, accountService.checkAccountBalance());
    }

    public void testWithdrawWithInsufficientFunds() {
        accountService.deposit(50.0);
        accountService.withdraw(100.0);
        assertEquals(50.0, accountService.checkAccountBalance());
    }
}
