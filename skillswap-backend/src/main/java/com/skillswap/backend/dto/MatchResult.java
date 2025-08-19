package com.skillswap.backend.dto;

public class MatchResult {
    private Long userAId;
    private Long userBId;
    private String skillAOffers_BWants;
    private String skillBOffers_AWants;

    public MatchResult(Long userAId, Long userBId, String s1, String s2) {
        this.userAId = userAId;
        this.userBId = userBId;
        this.skillAOffers_BWants = s1;
        this.skillBOffers_AWants = s2;
    }

    public Long getUserAId() {
        return userAId;
    }

    public Long getUserBId() {
        return userBId;
    }

    public String getSkillAOffers_BWants() {
        return skillAOffers_BWants;
    }

    public String getSkillBOffers_AWants() {
        return skillBOffers_AWants;
    }
}
