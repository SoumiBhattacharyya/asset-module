package com.capgemini.assetmanagement.application.service;

import java.util.List;

import com.capgemini.assetmanagement.application.entity.Asset;
import com.capgemini.assetmanagement.application.entity.Assets;

public interface AssetService {

	public List<Asset> getAllAssets();

	public Asset getAssetById(int theId);

	public void save(Assets assets);

	public Assets findById(int theId);

	public void deleteById(int theId);

}
