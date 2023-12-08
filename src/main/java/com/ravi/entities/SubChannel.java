package com.ravi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sub_channel")
public class SubChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sub_channel_id")
    private Integer subChannelID;
    @Column(name="sub_channel_name")
    private String subChannelName;
    @JsonIgnore
    @ManyToMany(mappedBy = "subChannels")
    private Set<Channel> channels = new HashSet<>();

    public Integer getSubChannelID() {
        return subChannelID;
    }

    public void setSubChannelID(Integer subChannelID) {
        this.subChannelID = subChannelID;
    }

    public String getSubChannelName() {
        return subChannelName;
    }

    public void setSubChannelName(String subChannelName) {
        this.subChannelName = subChannelName;
    }

    public Set<Channel> getChannels() {
        return channels;
    }

    public void setChannels(Set<Channel> channels) {
        this.channels = channels;
    }
}
