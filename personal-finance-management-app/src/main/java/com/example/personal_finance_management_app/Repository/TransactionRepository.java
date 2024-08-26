package com.example.personal_finance_management_app.Repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.Transaction;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, ObjectId> {
    List<Transaction> findByBudget_Id(ObjectId budgetId);
}
