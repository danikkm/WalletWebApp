package com.danikkk.walletWebApp.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class IdGenerator {
    public static String generateRandomStringId(int length) {
        return RandomStringUtils.random(length, true, true);
    }
}
