package com.ravi.controllers;

import com.ravi.exception.InvalidRequestException;
import com.ravi.services.ChannelService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/channelsubchannelmapping")
public class ChannelSubChannelMappingController {

    @Autowired
    private ChannelService channelService;

    @PostMapping("/{channelId}/{subChannelId}")
    @RolesAllowed({"ADMIN"})
    public ResponseEntity<String> mapChannelToSubChannel(
            @PathVariable @Valid Integer channelId,
            @PathVariable @Valid Integer subChannelId) {
        try {
            if (channelId == null || subChannelId == null) {
                throw new InvalidRequestException("ChannelId and SubChannelId cannot be null");
            }
            channelService.mapChannelToSubChannel(channelId, subChannelId);

            return ResponseEntity.ok("Mapping successfully created");
        } catch (InvalidRequestException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request:"+e.getMessage());
        }
    }
}

