package com.danikkk.walletWebApp.utils;

import com.danikkk.walletWebApp.models.Account;
import com.danikkk.walletWebApp.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class AccountUtil {
    /**
     * Returns an Account object by account id
     *
     * @param user      desired user
     * @param accountId unique account id
     * @return account that meets above mentioned criteria
     */
    public static Account getAccountByAccountId(User user, String accountId) {
        return user.getAccounts().stream()
                .filter(account -> account.getId()
                        .contentEquals(accountId)).findAny().orElse(null);
    }


    /**
     * Returns an Account objects by currency and account name
     *
     * @param user        desired user
     * @param currency    desired currency
     * @param accountName desired account name
     * @return accounts that meets above mentioned criteria
     */
    public static List<Account> getAccountsByCurrencyAndName(User user, String currency, String accountName) {
        return user.getAccounts().stream()
                .filter(account -> account.getCurrency()
                        .equals(currency) && account.getName().equals(accountName)).collect(Collectors.toList());
    }

    /**
     * Returns an Account objects by currency
     *
     * @param user     desired user
     * @param currency desired currency
     * @return accounts that meets above mentioned criteria
     */
    public static List<Account> getAccountsByCurrency(User user, String currency) {
        return user.getAccounts().stream()
                .filter(account -> account.getCurrency()
                        .equals(currency)).collect(Collectors.toList());
    }
}
