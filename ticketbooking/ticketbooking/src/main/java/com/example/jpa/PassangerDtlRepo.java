package com.example.jpa;

import com.example.dbdata.PassangerDtl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassangerDtlRepo extends JpaRepository<PassangerDtl,Long> {
}
