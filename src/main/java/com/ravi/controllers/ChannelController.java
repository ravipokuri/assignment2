package com.ravi.controllers;

import com.ravi.entities.SubChannel;
import com.ravi.exception.ResourceNotFoundException;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ravi.entities.Channel;
import com.ravi.services.ChannelService;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    @RolesAllowed({"ADMIN","VIEWER"})
    public ResponseEntity<List<Channel>> getAllChannels() {
            List<Channel> channels = channelService.getAllChannels();
            if (!channels.isEmpty()) {
                return ResponseEntity.ok(channels);
            } else {
                throw new ResourceNotFoundException("No channels found");
            }

    }
    @GetMapping("/{id}")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<Set<SubChannel>> getChannelDetails(@PathVariable Integer id) {
        Channel channel = channelService.getChannelAndSubChannelDetails(id);

        if (channel != null) {
            return ResponseEntity.ok(channel.getSubChannels());
        } else {
            throw new ResourceNotFoundException("Channel not found with ID: " + id);
        }
    }
}

