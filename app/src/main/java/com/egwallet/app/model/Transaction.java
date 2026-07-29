package com.egwallet.app.model;

public class Transaction {
    private String id;
    private String title;
    private String subtitle;
    private double amount;
    private String date; // ISO or display string

    public Transaction(String id, String title, String subtitle, double amount, String date) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.amount = amount;
        this.date = date;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSubtitle() { return subtitle; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
