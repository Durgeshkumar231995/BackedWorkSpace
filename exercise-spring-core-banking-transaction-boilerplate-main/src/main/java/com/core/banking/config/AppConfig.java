package com.core.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.core.banking.App;
import com.core.banking.model.Account;
import com.core.banking.service.AccountService;
import com.core.banking.service.BankService;

// add necessary annotation
@Configuration
public class AppConfig {

    //add necessary annotation
	 @Bean
    public Account account() {


    	return new Account(); 
    }

    //add necessary annotation
	 @Bean
    public AccountService accountService(Account account) {
         

        return new AccountService();
    }

    //add necessary annotation
	 @Bean
    public BankService bankService(Account account) {


        return new BankService();
    }

    //add necessary annotation
	 @Bean
    public App app(BankService bankService) {


        return new App();
    }

}
