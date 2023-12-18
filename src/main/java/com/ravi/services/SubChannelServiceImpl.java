package com.ravi.services;

import com.ravi.entities.Channel;
import com.ravi.exception.CustomIllegalArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    public void addSubChannel(SubChannel subChannel) {
        if (subChannel.getSubChannelName() == null || subChannel.getSubChannelName().equals("")) {
                throw new CustomIllegalArgumentException("SubChannel Name must be a non-null non-empty String");
        }
        if (subChannel.getSubChannelName().length() > 100) {
            throw new CustomIllegalArgumentException("SubChannel Name should contain a maximum of 100 characters");
        }
        subChannelRepository.save(subChannel);

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

