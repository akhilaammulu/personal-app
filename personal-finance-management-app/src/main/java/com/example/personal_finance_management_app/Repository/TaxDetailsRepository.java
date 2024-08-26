package com.example.personal_finance_management_app.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.personal_finance_management_app.Model.TaxDetails;

public interface TaxDetailsRepository extends MongoRepository<TaxDetails, String> {
}
