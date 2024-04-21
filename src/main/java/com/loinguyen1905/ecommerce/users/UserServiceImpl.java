package com.loinguyen1905.ecommerce.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loinguyen1905.ecommerce.users.dto.CreateUserDto;
import com.loinguyen1905.ecommerce.users.entity.User;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CreateUserDto registerUser(CreateUserDto userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User registedUser = this.userRepository.save(user);
        userDTO = modelMapper.map(registedUser, CreateUserDto.class);
        return userDTO;
    }
    
}