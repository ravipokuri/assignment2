package com.ravi.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProjectDto {
    @NotBlank(message = "Project Name must have atleast 1 character")
    @NotNull(message = "Project Name must not be empty")
    @Size(max = 50, message = "Project Name should contain a maximum of 50 characters and min of 1 character")
    private String projectName;

    @NotNull(message = "Project Creation Time must not be null")
    private LocalDateTime projectCreationTime;

    @NotNull(message = "Project Completion Date must not be null")
    @FutureOrPresent(message = "Project Completion Date must be in the present or future")
    private LocalDate projectCompletionDate;

    @NotNull(message = "Channel ID must not be null")
    @Positive(message = "Channel ID must be a positive integer")
    private Integer channelId;

    @NotNull(message = "SubChannel ID must not be null")
    @Positive(message = "SubChannel ID must be a positive integer")
    private Integer subChannelId;

    public ProjectDto() {
        projectName = null;
        projectCreationTime=null;
        projectCompletionDate=null;
        channelId=null;
        subChannelId=null;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getProjectCreationTime() {
        return projectCreationTime;
    }

    public void setProjectCreationTime(LocalDateTime projectCreationTime) {
        this.projectCreationTime = projectCreationTime;
    }

    public LocalDate getProjectCompletionDate() {
        return projectCompletionDate;
    }

    public void setProjectCompletionDate(LocalDate projectCompletionDate) {
        this.projectCompletionDate = projectCompletionDate;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getSubChannelId() {
        return subChannelId;
    }

    public void setSubChannelId(Integer subChannelId) {
        this.subChannelId = subChannelId;
    }


}
