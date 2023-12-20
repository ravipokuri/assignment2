package com.ravi.dto;

import jakarta.validation.constraints.*;


public class SubChannelDto {

    @NotBlank(message = "Channel Name must have atleast 1 character")
    @NotNull(message = "Channel shouldn't be null")
    @Size(max = 100, message = "Channel Name should contain a maximum of 100 characters")
    private String subChannelName;

    public SubChannelDto() {
        subChannelName = null;
    }


    public String getSubChannelName() {
        return subChannelName;
    }

    public void setSubChannelName(String channelName) {
        this.subChannelName = channelName;
    }
}
