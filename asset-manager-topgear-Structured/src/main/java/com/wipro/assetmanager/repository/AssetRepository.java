package com.wipro.assetmanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.assetmanager.model.Asset;
import com.wipro.assetmanager.model.Employee;

@Repository
public interface AssetRepository extends JpaRepository<Asset, String>{

	Optional<List<Asset>> findByEmployee(Employee employee);

}
