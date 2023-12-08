package com.ravi.services;
import java.util.List;
import com.ravi.entities.Channel;
public interface ChannelService {
    List<Channel> getAllChannels();
    Channel getChannelAndSubChannelDetails(Integer channel_id);
}
