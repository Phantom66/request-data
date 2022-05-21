package com.core.requestdata.repository;

import com.core.requestdata.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RequestDataRepository extends JpaRepository<Request, Long>  {
    
}
