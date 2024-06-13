package com.loinguyen1905.ecommerce.categories.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.loinguyen1905.ecommerce.roles.entity.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDto {
    private Long userId;

	private String username;

	private String password;

	private String email;

	private String phone;
	
	private Set<Role> roles = new HashSet<>();
	// private AddressDTO address;
	// private CartDTO cart;
}