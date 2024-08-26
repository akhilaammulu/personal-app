package com.example.personal_finance_management_app.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "recurring_transactions")
public class RecurringTransaction {

    @Id
    private String id;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public LocalDate getNextDate() {
		return nextDate;
	}
	public void setNextDate(LocalDate nextDate) {
		this.nextDate = nextDate;
	}
	private String name;
    private double amount;
    private String category;
    private String frequency; // e.g., "monthly", "weekly"
    private LocalDate nextDate;

    // Getters and Setters
}
