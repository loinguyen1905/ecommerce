package com.loinguyen1905.ecommerce.roles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.ecommerce.roles.dto.RoleDto;
import com.loinguyen1905.ecommerce.roles.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = this.modelMapper.map(roleDto, Role.class);
        Role createdRole = this.roleRepository.save(role);
        roleDto = this.modelMapper.map(createdRole, RoleDto.class);
        return roleDto;
    }

}