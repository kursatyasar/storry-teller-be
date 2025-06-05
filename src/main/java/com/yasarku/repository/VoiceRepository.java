package com.yasarku.repository;

import com.yasarku.entity.Voice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoiceRepository extends JpaRepository<Voice, Long> {
    // Custom query methods can be added here if needed
}