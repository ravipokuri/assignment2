package com.ravi.controllers;

import com.ravi.dto.ProjectDto;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ravi.entities.Project;
import com.ravi.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    @RolesAllowed({"ADMIN","PROJECTMANAGER"})
    public ResponseEntity<?> insertProject(@RequestBody @Valid ProjectDto projectDto) {
        try{
             projectService.insertProject(projectDto);
             return new ResponseEntity<>("Project added successfully", HttpStatus.CREATED);
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }

    @GetMapping
    @RolesAllowed({"ADMIN","PROJECTMANAGER"})
    public ResponseEntity<?> getProjectsByChannelAndSubChannel(
            @RequestParam(required = false) String channelName,
            @RequestParam(required = false) String subChannelName) {
        try {
            List<Project> projects= projectService.getProjectsByChannelAndSubChannel(channelName, subChannelName);
            return ResponseEntity.ok(projects);
        }catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProjectsByKeyword(
            @RequestParam(required = true) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        try {
            Page<Project> projects = projectService.searchProjectsByKeyword(keyword, page, size);
            return ResponseEntity.ok(projects);
        } catch (Exception e) {
            String errorMessage = "An error occurred while processing the request: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}

