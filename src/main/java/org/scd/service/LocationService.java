package org.scd.service;

import org.scd.config.exception.BusinessException;
import org.scd.model.Location;
import org.scd.model.dto.LocationDTO;
import org.scd.model.security.CustomUserDetails;

import java.util.Date;
import java.util.List;

public interface LocationService {

    Location addLocation(final CustomUserDetails customUserDetails, final LocationDTO locationDTO) throws BusinessException;

    Location findLocationById(final CustomUserDetails customUserDetails, final Long id) throws BusinessException;

    Location updateLocationById(final CustomUserDetails customUserDetails, final Long id) throws BusinessException;

    void deleteLocationById(final CustomUserDetails customUserDetails, final Long id) throws BusinessException;

    List<Location> getFilteredLocations(final Long userId, final Date startDate, final Date endDate) throws BusinessException;

}
