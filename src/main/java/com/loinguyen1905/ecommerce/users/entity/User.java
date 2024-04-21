package com.loinguyen1905.ecommerce.users.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = -297553281792804396L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Size(min = 5, message = "First Name must be between 5 and 30 characters long")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "First Name must not contain numbers or special characters")
    @Column(name = "user_name")
    private String username;

    @Email
	@Column(name = "email")
    private String email;

    @Size(min = 8, max = 100, message = "Password must be have least 8 char and max is 100 char")
    @Column(name = "password")
    private String password;

    @Size(min = 10, max = 10, message = "Mobile Number must be exactly 10 digits long")
	@Pattern(regexp = "^\\d{10}$", message = "Mobile Number must contain only Numbers")
	private String phone;

    @Column(name = "active")
	private boolean active;

}