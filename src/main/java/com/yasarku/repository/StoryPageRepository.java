package com.yasarku.repository;

import com.yasarku.entity.StoryPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryPageRepository extends JpaRepository<StoryPage, Long> {
    // Custom query methods can be added here if needed
}