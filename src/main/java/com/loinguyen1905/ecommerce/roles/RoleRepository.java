package com.loinguyen1905.ecommerce.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loinguyen1905.ecommerce.roles.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {}