package com.example.personal_finance_management_app.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "financialGoals")
public class FinancialGoal {
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public double getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	@Id
    private String id;
    private String goalName;
    private double targetAmount;
    private double currentAmount;
    private String dueDate;

    // Getters and Setters
}
