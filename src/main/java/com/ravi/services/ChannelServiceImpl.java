package com.ravi.services;
import com.ravi.entities.SubChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ravi.entities.Channel;
import com.ravi.repositories.ChannelRepository;
import java.util.List;
import java.util.Set;


@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public Channel getChannelAndSubChannelDetails(Integer channel_id) {
        Channel channel = channelRepository.findById(channel_id).orElse(null);

        if (channel != null) {
            return channel;
        } else {
            return null;
        }
    }


}
