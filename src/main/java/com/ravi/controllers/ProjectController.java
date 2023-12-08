package com.ravi.controllers;

import com.ravi.dto.ProjectDto;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Project insertProject(@RequestBody ProjectDto projectDto) {

            return projectService.insertProject(projectDto);


    }

    @GetMapping("/{channelName}/{subChannelName}")
    @RolesAllowed({"ADMIN","PROJECTMANAGER"})
    public List<Project> getProjectsByChannelAndSubChannel(
            @PathVariable String channelName,
            @PathVariable String subChannelName) {

            return projectService.getProjectsByChannelAndSubChannel(channelName, subChannelName);




    }
}

