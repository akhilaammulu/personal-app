package com.example.personal_finance_management_app.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.Currency;
import com.example.personal_finance_management_app.Repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    public Currency getCurrencyByCode(String currencyCode) {
        return repository.findByCurrencyCode(currencyCode);
    }

    public Currency addCurrency(Currency currency) {
        return repository.save(currency);
    }

    public double convertToBaseCurrency(String currencyCode, double amount) {
        Currency currency = repository.findByCurrencyCode(currencyCode);
        return amount * currency.getExchangeRateToBaseCurrency();
    }
    public List<Currency> getAllCurrencies() {
        return repository.findAll();
    }
}
