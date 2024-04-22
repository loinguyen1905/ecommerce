package com.loinguyen1905.ecommerce.roles;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loinguyen1905.ecommerce.models.ApiResponse;
import com.loinguyen1905.ecommerce.models.ResponseBuilder;
import com.loinguyen1905.ecommerce.roles.dto.RoleDto;

@RestController
@RequestMapping("/api/v1/roles/")
@SuppressWarnings("rawtypes")
public class RoleController {

    @Autowired
	private RoleService roleService;

    @Autowired
    private ResponseBuilder responseBuilder;
    
	@PostMapping("")
	public ResponseEntity<ApiResponse> register(@RequestBody RoleDto roleDto) throws BadRequestException {
		roleDto = this.roleService.createRole(roleDto);
		return responseBuilder.buildResponse(HttpStatus.CREATED.value(),"Create a new role", roleDto);
	}

}
