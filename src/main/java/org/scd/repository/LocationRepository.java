package org.scd.repository;

import org.scd.model.Location;

import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location,Long>{

    Location save(Location location);

   Optional <Location> findById(final Long id);

   void deleteById(final Long id);




}
