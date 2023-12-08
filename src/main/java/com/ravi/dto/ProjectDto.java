package com.ravi.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProjectDto {
    private String projectName;
    private LocalDateTime projectCreationTime;
    private LocalDate projectCompletionDate;
    private Integer channelId;
    private Integer subChannelId;

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
