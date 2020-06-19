package com.capgemini.assetmanagement.application.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.assetmanagement.application.entity.Asset;
import com.capgemini.assetmanagement.application.entity.Assets;

public interface AssetRepository extends JpaRepository<Assets, Integer> {
	
	@Query("from Asset")
	List<Asset> getAllAssets();
	
	@Query("from Asset where assetId=?1")
	Asset getAssetById(int theId);

}
