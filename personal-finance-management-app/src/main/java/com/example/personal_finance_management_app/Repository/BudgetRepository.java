package com.example.personal_finance_management_app.Repository;

import com.example.personal_finance_management_app.Model.Budget;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends MongoRepository<Budget, ObjectId> {
    // Custom query methods can be added here if needed
}
