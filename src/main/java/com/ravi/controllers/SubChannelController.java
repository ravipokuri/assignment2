package com.ravi.controllers;

import com.ravi.dto.SubChannelDto;
import com.ravi.entities.Channel;
import com.ravi.exception.ResourceNotFoundException;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ravi.entities.SubChannel;
import com.ravi.services.SubChannelService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/subchannels")
public class SubChannelController {

    @Autowired
    private SubChannelService subChannelService;

    @GetMapping
    @RolesAllowed({"ADMIN","VIEWER"})
    public ResponseEntity<?> getAllSubChannels() {
        try{
            List<SubChannel> subChannels = subChannelService.getAllSubChannels();

            if (!subChannels.isEmpty()) {
                return ResponseEntity.ok(subChannels);
            } else {
                throw new ResourceNotFoundException("No SubChannels found");
            }
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }



    }

    @GetMapping("/{id}")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<?> getChannelDetails(@PathVariable @Valid Integer id) {
        try{
            SubChannel subChannel = subChannelService.getChannelAndSubChannelDetails(id);

            if (subChannel != null) {
                return ResponseEntity.ok(subChannel.getChannels());
            } else {
                throw new ResourceNotFoundException("SubChannel not found with ID: " + id);
            }
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }

    @PostMapping("/add/sunChannel")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<String> addChannel(@RequestBody @Valid SubChannelDto subChannelDto) {
        try{
            subChannelService.addSubChannel(subChannelDto);
            return new ResponseEntity<>("SubChannel added successfully", HttpStatus.CREATED);
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }
}

