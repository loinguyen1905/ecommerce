package com.loinguyen1905.ecommerce.products.entity;

import java.io.Serializable;
import java.util.Set;

import com.loinguyen1905.ecommerce.roles.entity.Role;

import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
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
public class Product implements Serializable {
    
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

    @Column(name = "created_at")
	private String createdAt;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "roles_has_users", joinColumns = @JoinColumn(name = "users_user_id"), inverseJoinColumns = @JoinColumn(name = "roles_role_id"))
	private Set<Role> roles = new HashSet<>();
}