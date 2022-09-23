package com.SPM.backend.IT20122614.repository;

import com.SPM.backend.IT20122614.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

}
