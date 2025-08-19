package com.skillswap.backend.repository;

import com.skillswap.backend.model.SkillRequested;
import com.skillswap.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRequestedRepo extends JpaRepository<SkillRequested, Long> {
    List<SkillRequested> findByUser(User user);

    List<SkillRequested> findBySkillNameIgnoreCase(String skillName);
}
