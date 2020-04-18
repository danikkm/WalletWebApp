package com.danikkk.walletWebApp.utils;

import com.danikkk.walletWebApp.models.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@NoArgsConstructor
public class CategoryUtil {
    public static Category getCategoryFromJson(String jsonFileName) {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = CategoryUtil.class.getClassLoader();
        try {
            File file = new File(Objects.requireNonNull(classLoader
                    .getResource("static/categories/" + jsonFileName)).getFile());
            return mapper.readValue(file, Category.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
