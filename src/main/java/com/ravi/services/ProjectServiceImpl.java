package com.ravi.services;

import com.ravi.dto.ProjectDto;
import com.ravi.entities.Channel;
import com.ravi.entities.SubChannel;
import com.ravi.exception.CustomIllegalArgumentException;
import com.ravi.exception.InvalidRequestException;
import com.ravi.exception.ResourceNotFoundException;
import com.ravi.repositories.ChannelRepository;
import com.ravi.repositories.SubChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.ravi.entities.Project;
import com.ravi.repositories.ProjectRepository;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private SubChannelRepository subChannelRepository;

    @Override
    public Project insertProject(ProjectDto projectDto) {
        Integer channelId = projectDto.getChannelId();
        Integer subChannelId = projectDto.getSubChannelId();

        Channel channel = channelRepository.findById(channelId).orElse(null);
        SubChannel subChannel=subChannelRepository.findById(subChannelId).orElse(null);


        if(channel==null && subChannel==null) {
            throw new InvalidRequestException("Channel and SubChannel does not exits");
        }
        else if(channel==null) {
            throw new InvalidRequestException("Channel not found with ID: " + channelId);
        }
        else if(subChannel==null) {
            throw new InvalidRequestException("SubChannel not found with ID: " + subChannelId);
        }
        else {
            boolean isSubChannelPresent = channel.getSubChannels().stream()
                    .anyMatch(sub -> sub.getSubChannelID().equals(subChannelId));
            if(isSubChannelPresent) {
                Project project = new Project();
                project.setProjectName(projectDto.getProjectName());
                project.setProjectCreationTime(projectDto.getProjectCreationTime());
                project.setProjectCompletionDate(projectDto.getProjectCompletionDate());
                project.setChannel(channel);
                project.setSubChannel(subChannel);
                try {
                    return projectRepository.save(project);
                } catch (DataIntegrityViolationException e) {
                    throw new CustomIllegalArgumentException("Project Name should contain maximum of 50 characters");
                } catch (Exception e) {
                    throw new RuntimeException("An unexpected error occurred while saving the project", e);
                }

            }
            else {
                throw new InvalidRequestException("Channel and SubChannel Combination does not exist");
            }
        }
    }

    @Override
    public List<Project> getProjectsByChannelAndSubChannel(String channelName, String subChannelName) {
        List<Project> projects= projectRepository.findByChannel_ChannelNameAndSubChannel_SubChannelName(channelName, subChannelName);
        if(projects.isEmpty()) {
            throw new ResourceNotFoundException("No projects found");
        }
        else {
            return projects;
        }
    }

    @Override
    public List<Project> searchProjectsByKeyword(String keyword) {
        List<Project> projects= projectRepository.searchByKeyword(keyword);
        if(projects.isEmpty()) {
            throw new ResourceNotFoundException("No projects found");
        }
        else {
            return projects;
        }
    }


}

