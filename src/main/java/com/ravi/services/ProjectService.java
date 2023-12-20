package com.ravi.services;
import java.util.List;

import com.ravi.dto.ProjectDto;
import com.ravi.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Project insertProject(ProjectDto projectDto);
    List<Project> getProjectsByChannelAndSubChannel(String channelName, String subChannelName);

    Page<Project> searchProjectsByKeyword(String keyword,int page,int size);
}
