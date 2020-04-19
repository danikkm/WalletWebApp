package com.danikkk.walletWebApp.utils;

import com.danikkk.walletWebApp.models.Category;
import com.danikkk.walletWebApp.models.Subcategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@NoArgsConstructor
public class CategoryUtil {
    /**
     * Returns specified Category from Json file
     *
     * @param jsonFileName Json filename
     * @return category that meets above mentioned criteria
     */
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

    /**
     * Returns specified Subcategory from Json file
     *
     * @param jsonFileName     Json filename
     * @param subcategoryTitle desired subcategory title
     * @return subcategory that meets above mentioned criteria
     */
    public static Subcategory getSubcategoryFromCategoryJson(String jsonFileName, String subcategoryTitle) {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = CategoryUtil.class.getClassLoader();
        try {
            File file = new File(Objects.requireNonNull(classLoader
                    .getResource("static/categories/" + jsonFileName)).getFile());
            return mapper.readValue(file, Category.class).getSubcategories()
                    .stream().filter(subcategory -> subcategory.getTitle()
                            .contentEquals(subcategoryTitle)).findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns specified Subcategory from Category
     *
     * @param category         category object
     * @param subcategoryTitle desired subcategory title
     * @return subcategory that meets above mentioned criteria
     */
    public static Subcategory getSubcategoryFromCategory(Category category, String subcategoryTitle) {
        return category.getSubcategories().stream().filter(subcategory -> subcategory.getTitle()
                .contentEquals(subcategoryTitle)).findFirst().orElse(null);
    }
}
