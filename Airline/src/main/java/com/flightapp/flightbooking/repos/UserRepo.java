package com.flightapp.flightbooking.repos;

import com.flightapp.flightbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findByUserName(String username);
}
