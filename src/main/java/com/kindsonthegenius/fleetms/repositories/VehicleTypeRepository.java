package com.kindsonthegenius.fleetms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kindsonthegenius.fleetms.models.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

}
