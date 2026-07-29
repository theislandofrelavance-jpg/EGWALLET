package com.egwallet.app.model;

public class Beneficiary {
    private final String id;
    private final String name;
    private final String details; // IBAN / phone / email

    public Beneficiary(String id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDetails() { return details; }
}
