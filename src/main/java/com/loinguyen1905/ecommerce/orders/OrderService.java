package com.loinguyen1905.ecommerce.orders;

import com.loinguyen1905.ecommerce.users.dto.UserDto;

public interface OrderService {
    UserDto registerUser(UserDto userDTO);
	
	// UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
	
	// UserDTO getUserById(Long userId);
	
	// UserDTO updateUser(Long userId, UserDTO userDTO);
	
	// String deleteUser(Long userId);
}