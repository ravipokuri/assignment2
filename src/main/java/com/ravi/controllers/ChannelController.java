package com.ravi.controllers;

import com.ravi.entities.SubChannel;
import com.ravi.exception.ResourceNotFoundException;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ravi.entities.Channel;
import com.ravi.services.ChannelService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    @RolesAllowed({"ADMIN","VIEWER"})
    public ResponseEntity<?> getAllChannels() {
        try {
            List<Channel> channels = channelService.getAllChannels();
            if (!channels.isEmpty()) {
                return ResponseEntity.ok(channels);
            } else {
                throw new ResourceNotFoundException("No channels found");
            }
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }


    }
    @GetMapping("/{id}")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<?> getChannelDetails(@PathVariable @Valid Integer id) {
        try {
            Channel channel = channelService.getChannelAndSubChannelDetails(id);

            if (channel != null) {
                return ResponseEntity.ok(channel.getSubChannels());
            } else {
                throw new ResourceNotFoundException("Channel not found with ID: " + id);
            }
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }

    @PostMapping("/add/channel")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<String> addChannel(@RequestBody Channel channel) {
        try {
            channelService.addChannel(channel);
            return new ResponseEntity<>("Channel added successfully", HttpStatus.CREATED);
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }
}

