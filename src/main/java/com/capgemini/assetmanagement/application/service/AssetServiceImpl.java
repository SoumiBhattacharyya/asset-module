package com.capgemini.assetmanagement.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assetmanagement.application.DAO.AssetRepository;
import com.capgemini.assetmanagement.application.entity.Asset;
import com.capgemini.assetmanagement.application.entity.Assets;
import com.capgemini.assetmanagement.application.exception.RequestNotFoundException;

@Service
public class AssetServiceImpl implements AssetService {

	private AssetRepository assetRepository;

	@Autowired
	public AssetServiceImpl(AssetRepository theAssetRepository) {
		assetRepository = theAssetRepository;
	}

	@Override
	public Assets findById(int theId) {
		Optional<Assets> result = assetRepository.findById(theId);

		Assets theAssets = null;

		if (result.isPresent()) {
			theAssets = result.get();
		} else {
			// we didn't find the employee
			throw new RequestNotFoundException("Sorry ! No matching results found !");
		}

		return theAssets;
	}

	@Override
	public List<Asset> getAllAssets() {
		return assetRepository.getAllAssets();
	}

	@Override
	public void save(Assets theAssets) {
		assetRepository.save(theAssets);
	}

	@Override
	public void deleteById(int theId) {

		assetRepository.deleteById(theId);
	}

	@Override
	public Asset getAssetById(int theId) {

		return assetRepository.getAssetById(theId);
	}

}
