package com.skillswap.backend.repository;

import com.skillswap.backend.model.SkillOffered;
import com.skillswap.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillOfferedRepo extends JpaRepository<SkillOffered, Long> {
    List<SkillOffered> findByUser(User user);

    List<SkillOffered> findBySkillNameIgnoreCase(String skillName);
}
