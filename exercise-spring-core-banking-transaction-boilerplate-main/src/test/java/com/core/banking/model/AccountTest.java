package com.core.banking.model;

import com.core.banking.model.Account;
import junit.framework.TestCase;

public class AccountTest extends TestCase {

    private Account account;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        account = new Account();
    }

    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }

    public void testSetAndGetAccountNumber() {
        account.setAccountNumber("1234567890");
        assertEquals("1234567890", account.getAccountNumber());
    }

    public void testSetAndGetBalance() {
        account.setBalance(100.0);
        assertEquals(100.0, account.getBalance());
    }
}
