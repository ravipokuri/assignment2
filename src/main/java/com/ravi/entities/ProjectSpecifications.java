package com.ravi.entities;

import org.springframework.data.jpa.domain.Specification;
import com.ravi.entities.Project;

public class ProjectSpecifications {

    public static Specification<Project> searchByKeyword(String keyword) {
        return (root, query, criteriaBuilder) -> {
            String keywordLike = "%" + keyword.toLowerCase() + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("channel").get("channelName")), keywordLike),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("subChannel").get("subChannelName")), keywordLike),
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("projectName")), keywordLike)
            );
        };
    }
}

