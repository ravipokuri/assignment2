package com.ravi.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Integer projectId;

    @Column(name="project_name")
    private String projectName;
    @Column(name="project_creation_time")
    private LocalDateTime projectCreationTime;
    @Column(name="project_completion_time")
    private LocalDate projectCompletionDate;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public SubChannel getSubChannel() {
        return subChannel;
    }

    public void setSubChannel(SubChannel subChannel) {
        this.subChannel = subChannel;
    }
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sub_channel_id")
    private SubChannel subChannel;
}
