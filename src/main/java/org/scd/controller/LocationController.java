package org.scd.controller;

import org.scd.config.exception.BusinessException;
import org.scd.model.Location;
import org.scd.model.dto.DateDTO;
import org.scd.model.dto.LocationDTO;
import org.scd.model.security.CustomUserDetails;
import org.scd.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController()
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    //@CrossOrigin(origins = "http://localhost:63342")
    @PostMapping(path = "/add")
    public ResponseEntity<Location> addLocation(@RequestBody final LocationDTO locationDTO) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(locationService.addLocation(userPrincipal, locationDTO));
    }

    //@CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable final Long id) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(locationService.findLocationById(userPrincipal,id));
    }

    //@CrossOrigin(origins = "http://localhost:63342")
    @PutMapping(path = "/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable final Long id,@RequestBody LocationDTO locationDTO) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(locationService.updateLocationById(userPrincipal,id,locationDTO));
    }

    //@CrossOrigin(origins = "http://localhost:63342")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteLocation(@PathVariable final Long id) throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        locationService.deleteLocationById(userPrincipal,id);
        return ResponseEntity.noContent().build();
    }


   // @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping(path = "/me")
    public ResponseEntity<List<Location>> getLocations() throws BusinessException{
        final CustomUserDetails userPrincipal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(locationService.getLocationsByUser(userPrincipal));

    }
    
    @PostMapping(path = "/all/{id}")
    public ResponseEntity<List<Location>> getFilteredLocations(@PathVariable final Long id, @RequestBody DateDTO dateDTO) throws BusinessException{
        return ResponseEntity.ok(locationService.getFilteredLocations(id,dateDTO));

    }



}

