package com.example.personal_finance_management_app.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "currencies")
public class Currency {

    @Id
    private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public double getExchangeRateToBaseCurrency() {
		return exchangeRateToBaseCurrency;
	}
	public void setExchangeRateToBaseCurrency(double exchangeRateToBaseCurrency) {
		this.exchangeRateToBaseCurrency = exchangeRateToBaseCurrency;
	}
	private String currencyCode; // e.g., "USD", "EUR"
    private double exchangeRateToBaseCurrency; // Exchange rate to your base currency, e.g., USD to INR

    // Getters and Setters
}
