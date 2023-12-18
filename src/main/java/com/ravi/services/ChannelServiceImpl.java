package com.ravi.services;
import com.ravi.entities.SubChannel;
import com.ravi.exception.CustomIllegalArgumentException;
import com.ravi.exception.InvalidRequestException;
import com.ravi.repositories.SubChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.ravi.entities.Channel;
import com.ravi.repositories.ChannelRepository;
import java.util.List;
import java.util.Set;


@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepository channelRepository;
    @Autowired
    private SubChannelRepository subChannelRepository;

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public void addChannel(Channel channel) {
        if (channel.getChannelName() == null || channel.getChannelName().equals("") ) {
            throw new CustomIllegalArgumentException("Channel Name must be a non-null non-empty String");
        }
        if (channel.getChannelName().length() > 100) {
            throw new CustomIllegalArgumentException("Channel Name should contain a maximum of 100 characters");
        }
        channelRepository.save(channel);

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

    @Override
    public void mapChannelToSubChannel(Integer channelId, Integer subChannelId) {
        Channel channel = channelRepository.findById(channelId).orElse(null);
        SubChannel subChannel = subChannelRepository.findById(subChannelId).orElse(null);

        if (channel == null || subChannel == null) {
            throw new InvalidRequestException("Channel and SubChannel must exist");
        }

        channel.getSubChannels().add(subChannel);
        channelRepository.save(channel);
    }


}
