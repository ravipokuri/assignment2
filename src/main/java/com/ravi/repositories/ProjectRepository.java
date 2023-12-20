package com.ravi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ravi.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;
public interface ProjectRepository extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {
    //    @Query("SELECT p FROM Project p WHERE p.channel.channelName = :channelName AND p.subChannel.subChannelName = :subChannelName")
    List<Project> findByChannel_ChannelNameAndSubChannel_SubChannelName(String channelName, String subChannelName);

    Page<Project> findAll(Specification<Project> specification, Pageable pageable);

}
