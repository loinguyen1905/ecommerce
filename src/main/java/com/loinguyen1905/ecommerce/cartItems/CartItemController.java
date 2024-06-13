package com.loinguyen1905.ecommerce.cartItems;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.ecommerce.models.ApiResponse;
import com.loinguyen1905.ecommerce.models.ResponseBuilder;
import com.loinguyen1905.ecommerce.users.dto.UserDto;

@RestController
@RequestMapping("/api/v1/users/")
@SuppressWarnings("rawtypes")
// @SecurityRequirement(name = "E-Commerce Application")
public class CartItemController {

    @Autowired
	private UserService userService;

	
    @Autowired
    private ResponseBuilder responseBuilder;
    
	@PostMapping("")
	public ResponseEntity<ApiResponse> register(@RequestBody UserDto userDto) throws BadRequestException{
		userDto = this.userService.registerUser(userDto);
		return responseBuilder.buildResponse(HttpStatus.CREATED.value(),"Create a new user", userDto);
	}

}