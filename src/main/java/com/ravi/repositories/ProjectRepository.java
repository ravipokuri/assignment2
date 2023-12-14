package com.ravi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ravi.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    //    @Query("SELECT p FROM Project p WHERE p.channel.channelName = :channelName AND p.subChannel.subChannelName = :subChannelName")
    List<Project> findByChannel_ChannelNameAndSubChannel_SubChannelName(String channelName, String subChannelName);

    @Query("SELECT p FROM Project p " +
            "WHERE LOWER(p.channel.channelName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(p.subChannel.subChannelName) LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            "   OR LOWER(p.projectName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Project> searchByKeyword(
            @Param("keyword") String keyword);

}
