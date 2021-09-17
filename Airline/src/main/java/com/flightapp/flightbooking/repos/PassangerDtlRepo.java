package com.flightapp.flightbooking.repos;

import com.flightapp.flightbooking.models.PassangerDtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassangerDtlRepo extends JpaRepository<PassangerDtl, Long>{

}
