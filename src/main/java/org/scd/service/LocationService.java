package org.scd.service;

import org.scd.config.exception.BusinessException;
import org.scd.model.Location;
import org.scd.model.dto.LocationDTO;
import org.scd.model.security.CustomUserDetails;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.Date;
import java.util.List;

public interface LocationService {

    Location addLocation(final CustomUserDetails customUserDetails, final LocationDTO locationDTO) throws BusinessException;

    Location findLocationById(final CustomUserDetails customUserDetails, final Long id) throws BusinessException;

    Location updateLocationById(final CustomUserDetails customUserDetails, final Long id, final LocationDTO locationDTO) throws BusinessException;

    void deleteLocationById(final CustomUserDetails customUserDetails, final Long id) throws BusinessException;

    List<Location> getLocationsByUser(final CustomUserDetails customUserDetails) throws BusinessException;

    //List<Location> getFilteredLocations(final CustomUserDetails customUserDetails, final Date startDate, final Date endDate) throws BusinessException;

}
