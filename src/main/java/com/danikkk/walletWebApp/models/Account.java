package com.danikkk.walletWebApp.models;


import com.danikkk.walletWebApp.utils.IdGenerator;

//@TypeAlias(value = "Account")
public class Account {

    private String id;
    private String name;
    private String type;
    private String currency;

    public Account(String name, String type, String currency) {
        this.id = IdGenerator.generateRandomStringId(7);
        this.name = name;
        this.type = type;
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
