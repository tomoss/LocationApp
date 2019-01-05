package org.scd.controller;

import org.scd.config.exception.BusinessException;
import org.scd.model.Location;
import org.scd.model.dto.LocationDTO;
import org.scd.model.security.CustomUserDetails;
import org.scd.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping(path = "/add")
    public ResponseEntity<Location> addLocation(@RequestBody final LocationDTO locationDTO) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(locationService.addLocation(userPrincipal, locationDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable final Long id) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(locationService.findLocationById(userPrincipal,id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable final Long id,@RequestBody LocationDTO locationDTO) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(locationService.updateLocationById(userPrincipal,id,locationDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteLocation(@PathVariable final Long id) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        locationService.deleteLocationById(userPrincipal,id);
        return ResponseEntity.noContent().build();
    }

}

