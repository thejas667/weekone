package com.flightapp.flightbooking.repos;

import com.flightapp.flightbooking.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
	Role findRoleByName(String name);
}
