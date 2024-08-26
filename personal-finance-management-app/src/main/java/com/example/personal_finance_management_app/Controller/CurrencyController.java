package com.example.personal_finance_management_app.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.Currency;
import com.example.personal_finance_management_app.Service.CurrencyService;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @GetMapping("/{code}")
    public Currency getCurrencyByCode(@PathVariable String code) {
        return service.getCurrencyByCode(code);
    }

    @PostMapping
    public Currency addCurrency(@RequestBody Currency currency) {
        return service.addCurrency(currency);
    }

    @GetMapping("/convert")
    public double convertToBaseCurrency(@RequestParam String currencyCode, @RequestParam double amount) {
        return service.convertToBaseCurrency(currencyCode, amount);
    }
    @GetMapping
    public List<Currency> getAllCurrencies() {
        return service.getAllCurrencies();
    }
}
