package com.core.requestdata.repository;

import com.core.requestdata.model.Expense;
import com.core.requestdata.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long>  {
    
}
