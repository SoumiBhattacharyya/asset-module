package com.capgemini.assetmanagement.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.assetmanagement.application.DAO.AssetRepositoryNew;
import com.capgemini.assetmanagement.application.entity.Asset;

@Service
public class AssetServiceNewImpl implements AssetServiceNew {
	
	private AssetRepositoryNew assetRepositoryNew;
	
	@Autowired
	public AssetServiceNewImpl (AssetRepositoryNew theAssetRepositoryNew) {
		assetRepositoryNew = theAssetRepositoryNew;
	}

	@Override
	public List<Asset> findAll() {
		
		return assetRepositoryNew.findAll();
	}

	@Override
	public Page<Asset> findAll(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return assetRepositoryNew.findAll(pageable);
	}
	
	@Override
	public Page<Asset> getSortAssets(int pageNo, int itemsPerPage, String fieldName) {
		
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage , Sort.by(fieldName));
		
		return assetRepositoryNew.findAll(pageable);
	}

}
