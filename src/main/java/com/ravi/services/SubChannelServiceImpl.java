package com.ravi.services;

import com.ravi.entities.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ravi.entities.SubChannel;
import com.ravi.repositories.SubChannelRepository;
import java.util.List;

@Service
public class SubChannelServiceImpl implements SubChannelService {

    @Autowired
    private SubChannelRepository subChannelRepository;

    @Override
    public List<SubChannel> getAllSubChannels() {
        return subChannelRepository.findAll();
    }

    @Override
    public SubChannel getChannelAndSubChannelDetails(Integer sub_channel_id) {
        SubChannel subChannel = subChannelRepository.findById(sub_channel_id).orElse(null);

        if (subChannel != null) {
            return subChannel;
        } else {
            return null;
        }
    }

}

