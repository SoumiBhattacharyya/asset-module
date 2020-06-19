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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "t_asset")
@NoArgsConstructor
@AllArgsConstructor
public class Assets {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private int assetId;

	@NotBlank(message = "Please enter a valid asset name !")
	@Size(min = 3, message = "asset name must have atleast 3 charaters")
	@Column(name = "asset_name", length = 45, nullable = false)
	private String assetName;

	@NumberFormat
	@Column(name = "asset_quantity", length = 10)
	private int assetQuantity;

	@NumberFormat
	@NotNull(message = "Please enter a valid asset price , it accepts only numbers or decimals !")
	@Column(name = "asset_price", length = 10, nullable = false)
	private Double assetPrice;

	@NotBlank(message = "Please enter the asset image url !")
	@Column(name = "asset_image_url", length = 255, nullable = false)
	private String assetImageUrl;

	@NotBlank(message = "Please enter a description for the asset !")
	@Column(name = "asset_description", length = 255, nullable = false)
	private String assetDescription;

	@OneToMany(mappedBy = "assets", cascade = CascadeType.ALL)
	private List<Requests> requests;

}
