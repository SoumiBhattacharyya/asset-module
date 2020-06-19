package com.capgemini.assetmanagement.application.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_user")
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@NotBlank(message = "Please enter your full name !")
	@Size(min = 3 , max = 255)
	@Column(name = "full_name", nullable = false, length = 255)
	private String fullName;
	
	@NotBlank(message = "Please enter the gender !")
	@Column(name = "gender", nullable = false)
	private String gender;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Please enter the old password !")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password should contain atleast one uppercase , lowercase , numbers and special characters")
	@Column(name = "password", nullable = false, unique = true, length = 255)
	private String password;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Please enter the password !")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password should contain atleast one uppercase , lowercase , numbers and special characters")
	@Column(name = "newPassword", length = 255)
	private String newPassword;

	@NotBlank(message = "Please enter the email !")
	@Size(min = 6 , max = 20)
	@Email
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotBlank(message = "ROLE_ADMIN or ROLE_MANAGER or CUSTOMER")
	@Column(name = "role", nullable = false)
	private String role;

	@Pattern(regexp = "^[789]\\d{9}$" , message = "Please enter a valid mobile number starting with 7/8/9")
	@Size(max = 10)
	@Column(name = "mobile", nullable = false)
	private String mobile;
	
	@NotBlank(message = "Please enter the address")
	@Size(min = 3,max = 255)
	@Column(name = "address", nullable = false, length = 255)
	private String address;
	
//	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Please enter the confirm password !")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password should contain atleast one uppercase , lowercase , numbers and special characters")
	@Column(name = "confirm_password", nullable = false, length = 255)
	private String confirmPassword;
	
	@NotBlank
	@Column(name = "user_image", nullable = false, length = 255)
	private String userImage;


	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Requests> requests;

}
