package com.danikkk.walletWebApp;

import com.danikkk.walletWebApp.services.LedgerService;
import com.danikkk.walletWebApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * https://attacomsian.com/blog/processing-json-spring-boot
 * https://medium.com/javarevisited/building-a-rest-service-with-spring-boot-and-mongodb-3aa5cd2dce73
 * https://attacomsian.com/blog/processing-json-spring-boot
 */
@SpringBootApplication()
public class WalletWebAppApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	@Autowired
	LedgerService ledgerService;

	@Override
	public void run(String... args) throws IOException {


//		System.out.println(userService.findFirstByUsername("user1").getAccounts().stream()
//				.filter(account -> account.getName()
//						.contentEquals("Swedbank")).findFirst().orElse(null));
//		Account specificAccount = userService.findFirstByUsername("user1").getAccounts().stream()
//				.filter(account -> account.getName()
//						.contentEquals("Swedbank")).findFirst().orElse(null);


		System.out.println(userService.findUserByAccountId("4LrBi4W"));
		System.out.println(userService.findAllAccountsByUsername("user1"));

//		ledgerService.saveOrUpdateLedger(new Ledger(groceries, specificAccount
//				, "expense", "Maxima", "Food and stuff"
//				, CurrentDateAndTime.getCurrentDateAndTime(), 67.20));
//		System.out.println(ledgerService.findAll());
//		System.out.println(ledgerService.findByTransactionType("expense"));

	}

	public static void main(String[] args) {
		SpringApplication.run(WalletWebAppApplication.class, args);
	}


}
