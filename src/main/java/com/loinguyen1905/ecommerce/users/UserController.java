package com.loinguyen1905.ecommerce.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.ecommerce.users.dto.CreateUserDto;

@RestController
@RequestMapping("/api/v1/users/")
// @SecurityRequirement(name = "E-Commerce Application")
public class UserController {

    @Autowired
	private UserService userService;
    
    @PostMapping("")
	public ResponseEntity<CreateUserDto> register(@RequestBody CreateUserDto createUserDto) {
		CreateUserDto userDto = this.userService.registerUser(createUserDto);
		return new ResponseEntity<CreateUserDto>(userDto, HttpStatus.OK);
	}

}