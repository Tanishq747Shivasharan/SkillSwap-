package com.skillswap.backend.controller;

import com.skillswap.backend.dto.MatchResult;
import com.skillswap.backend.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) { this.matchService = matchService; }

    @GetMapping("/{userId}")
    public List<MatchResult> mutualMatches(@PathVariable Long userId) {
        return matchService.mutualMatchesForUser(userId);
    }
}
