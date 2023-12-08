package com.ravi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ravi.entities.Project;
import java.util.List;
public interface ProjectRepository extends JpaRepository<Project, Integer>{
    List<Project> findByChannel_ChannelNameAndSubChannel_SubChannelName(String channelName, String subChannelName);
}
