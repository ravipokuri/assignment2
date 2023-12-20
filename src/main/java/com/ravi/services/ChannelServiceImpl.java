package com.ravi.services;

import com.ravi.dto.ChannelDto;
import com.ravi.entities.SubChannel;
import com.ravi.exception.InvalidRequestException;
import com.ravi.repositories.SubChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ravi.entities.Channel;
import com.ravi.repositories.ChannelRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
    public Object addChannel(ChannelDto channelDto) {
        Channel channel=new Channel();
        channel.setChannelName(channelDto.getChannelName());
        return channelRepository.save(channel);
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
