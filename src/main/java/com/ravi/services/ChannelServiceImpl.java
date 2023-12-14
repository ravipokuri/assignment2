package com.ravi.services;
import com.ravi.entities.SubChannel;
import com.ravi.exception.CustomIllegalArgumentException;
import com.ravi.exception.InvalidRequestException;
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

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public void addChannel(Channel channel) {
        try {
            channelRepository.save(channel);
        } catch (DataIntegrityViolationException e) {
            throw new CustomIllegalArgumentException("Channel Name should contain maximum of 100 characters");
        }
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
