package com.loinguyen1905.ecommerce.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    private Long userId;
	private String username;
	private String password;
	private String email;
	private String phone;
	private boolean active = true;
	// private Set<Role> roles = new HashSet<>();
	// private AddressDTO address;
	// private CartDTO cart;
}