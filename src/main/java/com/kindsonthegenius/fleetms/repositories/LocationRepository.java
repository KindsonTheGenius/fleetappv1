package com.kindsonthegenius.fleetms.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kindsonthegenius.fleetms.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
