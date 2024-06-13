package com.loinguyen1905.ecommerce.shops;

import com.loinguyen1905.ecommerce.users.dto.UserDto;

public interface ShopService {
    UserDto registerUser(UserDto userDTO);
	
	// UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
	
	// UserDTO getUserById(Long userId);
	
	// UserDTO updateUser(Long userId, UserDTO userDTO);
	
	// String deleteUser(Long userId);
}