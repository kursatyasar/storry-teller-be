package com.yasarku.repository;

import com.yasarku.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    // Custom query methods can be added here if needed
}