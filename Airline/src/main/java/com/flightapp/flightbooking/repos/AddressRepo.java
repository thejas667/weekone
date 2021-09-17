package com.flightapp.flightbooking.repos;

import com.flightapp.flightbooking.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
