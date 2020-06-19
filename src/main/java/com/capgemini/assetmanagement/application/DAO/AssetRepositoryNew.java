package com.capgemini.assetmanagement.application.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assetmanagement.application.entity.Asset;

public interface AssetRepositoryNew extends JpaRepository<Asset, Integer>{

}
