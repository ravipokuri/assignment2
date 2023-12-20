package com.ravi.services;
import java.util.List;

import com.ravi.dto.ChannelDto;
import com.ravi.entities.Channel;
public interface ChannelService {
    List<Channel> getAllChannels();
    Object addChannel(ChannelDto channelDto);
    Channel getChannelAndSubChannelDetails(Integer channel_id);

    void mapChannelToSubChannel(Integer channelId, Integer subChannelId);
}
