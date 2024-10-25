package com.core.banking.model;

import com.core.banking.model.Transaction;
import junit.framework.TestCase;

import java.util.Date;

public class TransactionTest extends TestCase {

    private Transaction transaction;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        transaction = new Transaction();
    }

    public void testSetAndGetTransactionId() {
        transaction.setTransactionId("T123");
        assertEquals("T123", transaction.getTransactionId());
    }

    public void testSetAndGetType() {
        transaction.setType("DEPOSIT");
        assertEquals("DEPOSIT", transaction.getType());
    }

    public void testSetAndGetAmount() {
        transaction.setAmount(100.0);
        assertEquals(100.0, transaction.getAmount());
    }

    public void testSetAndGetDate() {
        Date date = new Date();
        transaction.setDate(date);
        assertEquals(date, transaction.getDate());
    }
}
