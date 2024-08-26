package com.example.personal_finance_management_app.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tax_details")
public class TaxDetails {

    @Id
    private String id;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}
	public double getCalculatedTax() {
		return calculatedTax;
	}
	public void setCalculatedTax(double calculatedTax) {
		this.calculatedTax = calculatedTax;
	}
	private double annualIncome;
    private double taxRate; // Tax rate as a percentage
    private double calculatedTax;

    // Getters and Setters
}
