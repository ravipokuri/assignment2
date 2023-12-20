package com.ravi.dto;

import jakarta.validation.constraints.*;


public class ChannelDto {
    
    @NotBlank(message = "Channel Name must have atleast 1 character")
    @NotNull(message = "Channel shouldn't be null")
    @Size(max = 100, message = "Channel Name should contain a maximum of 100 characters")
    private String channelName;

    public ChannelDto() {
        channelName = null;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
