package com.ravi.services;
import java.util.List;

import com.ravi.entities.Channel;
import com.ravi.entities.SubChannel;
public interface SubChannelService {
    List<SubChannel> getAllSubChannels();

    void addSubChannel(SubChannel subChannel);
    SubChannel getChannelAndSubChannelDetails(Integer sub_channel_id);
}
