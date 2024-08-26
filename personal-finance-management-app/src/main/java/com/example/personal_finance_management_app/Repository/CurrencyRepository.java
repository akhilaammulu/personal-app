package com.example.personal_finance_management_app.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.Currency;

public interface CurrencyRepository extends MongoRepository<Currency, String> {
    Currency findByCurrencyCode(String currencyCode);
}
