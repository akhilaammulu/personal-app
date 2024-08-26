package com.example.personal_finance_management_app.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.personal_finance_management_app.Model.TaxDetails;
import com.example.personal_finance_management_app.Service.TaxCalculationService;

@RestController
@RequestMapping("/api/taxes")
public class TaxController {

    @Autowired
    private TaxCalculationService service;

    @PostMapping("/calculate")
    public TaxDetails calculateTax(@RequestBody TaxDetails taxDetails) {
        return service.calculateTax(taxDetails);
    }

    @GetMapping("/{id}")
    public TaxDetails getTaxDetailsById(@PathVariable String id) {
        return service.getTaxDetailsById(id);
    }
    @GetMapping
    public List<TaxDetails> getAllTaxDetails() {
        return service.getAllTaxDetails();
    }

}
