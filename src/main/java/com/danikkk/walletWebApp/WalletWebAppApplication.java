package com.danikkk.walletWebApp;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.Category;
import com.danikkk.walletWebApp.models.Subcategory;
import com.danikkk.walletWebApp.services.LedgerService;
import com.danikkk.walletWebApp.services.UserService;
import com.danikkk.walletWebApp.utils.CategoryUtil;
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
		Account specificAccount = userService.findFirstByUsername("user1").getAccounts().stream()
				.filter(account -> account.getName()
						.contentEquals("Swedbank")).findFirst().orElse(null);

		Category category = CategoryUtil.getCategoryFromJson("foodAndDrinks.json");
//		System.out.println(category.getSubcategories().stream().filter(subcategory -> subcategory.getTitle()
//				.contentEquals("Groceries")).findFirst().orElse(null));

		Subcategory groceries = category.getSubcategories().stream().filter(subcategory -> subcategory.getTitle()
				.contentEquals("Groceries")).findFirst().orElse(null);


//		ledgerService.saveOrUpdateLedger(new Ledger(groceries, specificAccount
//				, "exp", "Maxima", "Food and stuff"
//				, CurrentDateAndTime.getCurrentDateAndTime(), 67.20));
		System.out.println(ledgerService.findAll());
		System.out.println(ledgerService.findByTransactionType("inc"));
		System.out.println(ledgerService.findByTransactionType("exp"));

	}

	public static void main(String[] args) {
		SpringApplication.run(WalletWebAppApplication.class, args);
	}


}
