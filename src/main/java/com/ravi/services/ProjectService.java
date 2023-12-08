package com.ravi.services;
import java.util.List;

import com.ravi.dto.ProjectDto;
import com.ravi.entities.Project;
public interface ProjectService {
    Project insertProject(ProjectDto projectDto);
    List<Project> getProjectsByChannelAndSubChannel(String channelName, String subChannelName);
}
