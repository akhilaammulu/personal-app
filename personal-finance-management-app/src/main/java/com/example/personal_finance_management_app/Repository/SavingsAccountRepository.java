package com.example.personal_finance_management_app.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.SavingsAccount;

public interface SavingsAccountRepository extends MongoRepository<SavingsAccount, String> {
}
