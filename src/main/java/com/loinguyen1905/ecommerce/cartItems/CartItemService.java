package com.loinguyen1905.ecommerce.cartItems;

import com.loinguyen1905.ecommerce.users.dto.UserDto;

public interface CartItemService {
    UserDto registerUser(UserDto userDTO);
	
	// UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
	
	// UserDTO getUserById(Long userId);
	
	// UserDTO updateUser(Long userId, UserDTO userDTO);
	
	// String deleteUser(Long userId);
}