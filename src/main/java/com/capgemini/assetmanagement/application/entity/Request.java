package com.capgemini.assetmanagement.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "t_request")
@NoArgsConstructor
@AllArgsConstructor
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	private int requestId;

	@NotNull(message = "Please enter the user id !")
	@NumberFormat
	@Column(name = "user_id", nullable = false)
	private int userId;

	@NotNull(message = "Please enter the asset id !")
	@NumberFormat
	@Column(name = "asset_id", nullable = false)
	private int assetId;

	@NotNull(message = "Please enter the employee id !")
	@NumberFormat
	@Column(name = "employee_id", nullable = false)
	private int employeeId;

	@Column(name = "alc_unlc", length = 255)
	private String alcUnlc;

	@Column(name = "reason", length = 255)
	private String reason;

	@NotBlank(message = "Please enter a valid asset name !")
	@Size(min = 3, message = "asset name must have atleast 3 charaters")
	@Column(name = "asset_name", length = 45, nullable = false)
	private String assetName;

	@NumberFormat
	@Column(name = "asset_quantity", length = 10)
	private int assetQuantity;

	@NotNull(message = "Please enter a valid status !")
	@Column(name = "status")
	private String status;

	@NumberFormat
	@Column(name = "total_price")
	private Double totalPrice;

	 
}
