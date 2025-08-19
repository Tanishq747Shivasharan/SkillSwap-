package com.skillswap.backend.dto;

public class SkillResponse {
    private Long id;
    private Long userId;
    private String skillName;
    private String description;

    public SkillResponse(Long id, Long userId, String skillName, String description) {
        this.id = id;
        this.userId = userId;
        this.skillName = skillName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getDescription() {
        return description;
    }
}
