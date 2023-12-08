package com.ravi.controllers;

import com.ravi.entities.Channel;
import com.ravi.exception.ResourceNotFoundException;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ravi.entities.SubChannel;
import com.ravi.services.SubChannelService;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/subchannels")
public class SubChannelController {

    @Autowired
    private SubChannelService subChannelService;

    @GetMapping
    @RolesAllowed({"ADMIN","VIEWER"})
    public ResponseEntity<List<SubChannel>> getAllSubChannels() {

            List<SubChannel> subChannels = subChannelService.getAllSubChannels();

            if (!subChannels.isEmpty()) {
                return ResponseEntity.ok(subChannels);
            } else {
                throw new ResourceNotFoundException("No SubChannels found");
            }


    }

    @GetMapping("/{id}")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<Set<Channel>> getChannelDetails(@PathVariable Integer id) {
        SubChannel subChannel = subChannelService.getChannelAndSubChannelDetails(id);

        if (subChannel != null) {
            return ResponseEntity.ok(subChannel.getChannels());
        } else {
            throw new ResourceNotFoundException("SubChannel not found with ID: " + id);
        }
    }
}

