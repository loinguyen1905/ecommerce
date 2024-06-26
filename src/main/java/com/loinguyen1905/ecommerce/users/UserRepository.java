package com.loinguyen1905.ecommerce.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.ecommerce.users.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // @Query("SELECT u FROM User u JOIN FETCH u.addresses a WHERE a.addressId = ?1")
	// List<User> findByAddress(Long addressId);
	Optional<User> findByEmail(String email);
}