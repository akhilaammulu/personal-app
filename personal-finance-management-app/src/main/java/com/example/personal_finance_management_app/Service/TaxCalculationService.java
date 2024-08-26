package com.example.personal_finance_management_app.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personal_finance_management_app.Model.TaxDetails;
import com.example.personal_finance_management_app.Repository.TaxDetailsRepository;

@Service
public class TaxCalculationService {

    @Autowired
    private TaxDetailsRepository repository;

    public TaxDetails calculateTax(TaxDetails taxDetails) {
        double calculatedTax = taxDetails.getAnnualIncome() * (taxDetails.getTaxRate() / 100);
        taxDetails.setCalculatedTax(calculatedTax);
        return repository.save(taxDetails);
    }

    public TaxDetails getTaxDetailsById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tax details not found"));
    }
    public List<TaxDetails> getAllTaxDetails() {
        // Use the repository to fetch all tax details from MongoDB
        return repository.findAll();
    }
}
