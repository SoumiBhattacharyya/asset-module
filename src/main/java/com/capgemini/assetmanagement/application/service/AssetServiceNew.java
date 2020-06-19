package com.capgemini.assetmanagement.application.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.assetmanagement.application.entity.Asset;

public interface AssetServiceNew {
	
	public List<Asset> findAll();
	
	public Page<Asset> findAll(int pageNo, int itemsPerPage);
	
	public Page<Asset> getSortAssets(int pageNo, int itemsPerPage, String fieldName);

}
