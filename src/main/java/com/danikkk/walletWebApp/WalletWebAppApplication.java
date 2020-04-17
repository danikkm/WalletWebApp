package com.danikkk.walletWebApp;

import com.danikkk.walletWebApp.repositories.AccountRepository;
import com.danikkk.walletWebApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class WalletWebAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(userRepository.findAll());
		System.out.println("\n");
//		System.out.println(userRepository.findAllByAccountsEqualsOrId("5e9879ea8266aa7899867901"));

	}

	public static void main(String[] args) {
		SpringApplication.run(WalletWebAppApplication.class, args);
	}


}
