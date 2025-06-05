package com.yasarku.repository;

import com.yasarku.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    // Custom query methods can be added here if needed
}