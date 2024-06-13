package com.loinguyen1905.ecommerce.carts;

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
public class CartServiceImpl implements CartService {

    @Override
    public UserDto registerUser(UserDto userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
    }

    
}