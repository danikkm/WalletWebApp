package com.danikkk.walletWebApp.models;

import lombok.ToString;

import java.util.List;

@ToString
public class Category {
    private int id;
    private String title;
    private List<Subcategory> subcategories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
