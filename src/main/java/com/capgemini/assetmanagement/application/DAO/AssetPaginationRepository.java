package com.capgemini.assetmanagement.application.DAO;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.capgemini.assetmanagement.application.entity.Assets;

public interface AssetPaginationRepository extends PagingAndSortingRepository<Assets, Integer>{

}
