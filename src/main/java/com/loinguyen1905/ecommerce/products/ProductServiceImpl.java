package com.loinguyen1905.ecommerce.users;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.apache.el.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.loinguyen1905.ecommerce.models.ResponseBuilder;
import com.loinguyen1905.ecommerce.roles.RoleRepository;
import com.loinguyen1905.ecommerce.roles.entity.Role;
import com.loinguyen1905.ecommerce.users.dto.UserDto;
import com.loinguyen1905.ecommerce.users.entity.User;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setActive(true);
        user.setCreatedAt(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));

        Set<Role> newRoles = user.getRoles().stream().map(role -> {
            Optional<Role> roleOptional = this.roleRepository.findById(role.getRoleId());
            if(!roleOptional.isPresent()) return this.roleRepository.save(role);
            else return roleOptional.get();
        }).collect(Collectors.toSet());
        user.setRoles(newRoles);

        User registedUser = this.userRepository.save(user);
        userDto = modelMapper.map(registedUser, UserDto.class);
        return userDto;
    }
}