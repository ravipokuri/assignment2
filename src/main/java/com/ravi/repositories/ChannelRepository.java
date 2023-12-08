package com.ravi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ravi.entities.Channel;
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    Channel findByChannelName(String channelName);
}
