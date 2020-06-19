package com.capgemini.assetmanagement.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assetmanagement.application.entity.Asset;
import com.capgemini.assetmanagement.application.entity.AssetResponse;
import com.capgemini.assetmanagement.application.service.AssetServiceNew;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AssetRestControllerNew {

	@Autowired
	public AssetServiceNew assetServiceNew;

	@Autowired
	public AssetRestControllerNew(AssetServiceNew theAssetServiceNew) {
		assetServiceNew = theAssetServiceNew;
	}

	@GetMapping("/assets")
	public AssetResponse<List<Asset>> findAll() {
		List<Asset> list = assetServiceNew.findAll();

		if (list != null) {
			return new AssetResponse<List<Asset>>(false, "Assets found!", list, null);
		} else {
			return new AssetResponse<List<Asset>>(true, "Assets Not found!", null, null);
		}

	}

	@GetMapping("/assets/{pageNo}/{itemsPerPage}")
	public Page<Asset> getAssets(@PathVariable int pageNo, @PathVariable int itemsPerPage) {
		return assetServiceNew.findAll(pageNo, itemsPerPage);
	}

	@GetMapping("/assets/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<Asset> getSortAssets(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {
		return assetServiceNew.getSortAssets(pageNo, itemsPerPage, fieldName);
	}

}
