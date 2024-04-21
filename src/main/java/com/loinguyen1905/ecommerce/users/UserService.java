package com.loinguyen1905.ecommerce.users;

import com.loinguyen1905.ecommerce.users.dto.CreateUserDto;

public interface UserService {
    CreateUserDto registerUser(CreateUserDto userDTO);
	
	// UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
	
	// UserDTO getUserById(Long userId);
	
	// UserDTO updateUser(Long userId, UserDTO userDTO);
	
	// String deleteUser(Long userId);
}