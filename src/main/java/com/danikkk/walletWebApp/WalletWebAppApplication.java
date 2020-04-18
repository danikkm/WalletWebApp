package com.danikkk.walletWebApp;

import com.danikkk.walletWebApp.models.Category;
import com.danikkk.walletWebApp.repositories.UserRepository;
import com.danikkk.walletWebApp.utils.CategoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * https://attacomsian.com/blog/processing-json-spring-boot
 * https://medium.com/javarevisited/building-a-rest-service-with-spring-boot-and-mongodb-3aa5cd2dce73
 */
@SpringBootApplication()
public class WalletWebAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws IOException {
		System.out.println(userRepository.findAll());
		System.out.println("\n");

		Category newCategory = CategoryUtil.getCategoryFromJson("communicationPC.json");

		System.out.println(newCategory);
	}

	public static void main(String[] args) {
		SpringApplication.run(WalletWebAppApplication.class, args);
	}


}
