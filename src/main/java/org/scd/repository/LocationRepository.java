package org.scd.repository;

import org.scd.model.Location;

import org.scd.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location,Long>{

    Location save(Location location);

   Optional <Location> findById(final Long id);

   void deleteById(final Long id);

   List<Location> findLocationsByUser(User user);

   List<Location> findLocationsByDateAfterAndDateBeforeAndUserId(Date startDate, Date endDate, Long id);


}
