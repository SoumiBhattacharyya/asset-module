package com.capgemini.assetmanagement.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assetmanagement.application.entity.Asset;
import com.capgemini.assetmanagement.application.entity.AssetResponse;
import com.capgemini.assetmanagement.application.entity.Assets;
import com.capgemini.assetmanagement.application.exception.AssetNotFoundException;
import com.capgemini.assetmanagement.application.service.AssetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AssetRestController {

	@Autowired
	private AssetService assetService;

	@Autowired
	public AssetRestController(AssetService theAssetService) {
		assetService = theAssetService;
	}

	// expose "/employees" and return list of students
	@GetMapping("/get-assets")
	public AssetResponse<List<Asset>> getAllAssets() {
		List<Asset> list = assetService.getAllAssets();

		if (list != null) {
			return new AssetResponse<List<Asset>>(false, "Assets found!", list, null);
		} else {
			return new AssetResponse<List<Asset>>(true, "Assets Not found!", null, null);
		}

	}

	@GetMapping("/assets/{assetId}")
	public AssetResponse<Asset> getAssetById(@PathVariable int assetId) {

		Asset theAssets = assetService.getAssetById(assetId);

		if (theAssets != null) {
			return new AssetResponse<Asset>(false, "Asset found!", null, theAssets);
		} else {
			return new AssetResponse<Asset>(true, "Asset Not found!", null, null);
		}
	}

	@GetMapping("/get/assetById/{assetId}")
	public AssetResponse<Assets> findById(@PathVariable int assetId) {

		Asset theAssets = assetService.getAssetById(assetId);

		if (theAssets != null) {
			return new AssetResponse<Assets>(false, "Asset found!", null, theAssets);
		} else {
			return new AssetResponse<Assets>(true, "Asset Not found!", null, null);
		}
	}

	@PostMapping("/add-assets")
	public AssetResponse<Asset> addAssets(@RequestBody Assets theAssets) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		if (theAssets.getAssetPrice() == 0) {
			throw new AssetNotFoundException("0 not allowed !");
		}

		theAssets.setAssetId(0);

		assetService.save(theAssets);

		return new AssetResponse<Asset>(false, "Assets Added Successfully!", null, null);

	}

	@PutMapping("/edit-assets")
	public AssetResponse<Asset> updateAsset(@RequestBody Assets theAssets) {

		assetService.save(theAssets);

		return new AssetResponse<Asset>(false, "Assets Updated Successfully!", null, null);

	}

	@DeleteMapping("/delete-assets/{assetId}")
	public AssetResponse<Asset> deleteAsset(@PathVariable int assetId) {

		Asset tempAssets = assetService.getAssetById(assetId);

		// throw exception if null

		if (tempAssets != null) {
			assetService.deleteById(assetId);
			return new AssetResponse<Asset>(false, "Asset Deleted Successfully!", null, tempAssets);
		} else {
			throw new AssetNotFoundException("Asset to be deleted is not found!");

		}
	}

}
