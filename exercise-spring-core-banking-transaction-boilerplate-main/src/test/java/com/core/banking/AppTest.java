package com.core.banking;

import com.core.banking.App;
import com.core.banking.service.BankService;
import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AppTest extends TestCase {

    private BankService bankService;
    private App app;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bankService = new BankService();
        app = new App();
        app.setBankService(bankService);

        // Redirect System.out to outContent
        System.setOut(new PrintStream(outContent));
    }

    

    public void testMakeTransactionExit() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        app.makeTransaction();
        assertEquals(0.0, bankService.checkAccountBalance());
    }

    public void testMakeTransactionInvalidChoice() {
        String input = "4\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirecting System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        app.makeTransaction();

        // Reset System.out
        System.setOut(originalOut);

        // Validating the output
        assertTrue(outContent.toString().contains("Invalid choice"));
    }
    public void testMakeTransactionInsufficientFunds() {
        bankService.deposit(50.0);
        String input = "2\n100.0\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        app.makeTransaction();
        
        // Validating the output
        assertTrue(outContent.toString().contains("Insufficient funds"));
    }
}
