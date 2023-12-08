package com.ravi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ravi.entities.SubChannel;
public interface SubChannelRepository  extends JpaRepository<SubChannel, Integer>{
    SubChannel findBySubChannelName(String subChannelName);
}
