package com.ravi.services;
import java.util.List;
import com.ravi.entities.Channel;
public interface ChannelService {
    List<Channel> getAllChannels();
    void addChannel(Channel channel);
    Channel getChannelAndSubChannelDetails(Integer channel_id);
}
