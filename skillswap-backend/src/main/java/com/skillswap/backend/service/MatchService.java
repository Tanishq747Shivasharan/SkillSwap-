package com.skillswap.backend.service;

import com.skillswap.backend.dto.MatchResult;
// import com.skillswap.backend.model.SkillOffered;
// import com.skillswap.backend.model.SkillRequested;
import com.skillswap.backend.model.User;
import com.skillswap.backend.repository.SkillOfferedRepo;
import com.skillswap.backend.repository.SkillRequestedRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final SkillOfferedRepo offeredRepo;
    private final SkillRequestedRepo requestedRepo;
    private final UserService userService;

    public MatchService(SkillOfferedRepo o, SkillRequestedRepo r, UserService userService) {
        this.offeredRepo = o; this.requestedRepo = r; this.userService = userService;
    }

    private static String norm(String s) {
        return s == null ? "" : s.trim().toLowerCase(Locale.ROOT);
    }

    /**
     * Mutual match: User A offers something User B wants AND User B offers something User A wants.
     */
    @Transactional(readOnly = true)
    public List<MatchResult> mutualMatchesForUser(Long userId) {
        User user = userService.getByIdEntity(userId);

        // Map skill -> set of userIds
        @SuppressWarnings("unused")
        Map<String, Set<Long>> offerMap = offeredRepo.findAll().stream()
                .collect(Collectors.groupingBy(s -> norm(s.getSkillName()),
                        Collectors.mapping(s -> s.getUser().getId(), Collectors.toSet())));

        Map<String, Set<Long>> wantMap = requestedRepo.findAll().stream()
                .collect(Collectors.groupingBy(s -> norm(s.getSkillName()),
                        Collectors.mapping(s -> s.getUser().getId(), Collectors.toSet())));

        // Skills A offers / wants
        Set<String> aOffers = offeredRepo.findByUser(user).stream().map(s -> norm(s.getSkillName())).collect(Collectors.toSet());
        Set<String> aWants  = requestedRepo.findByUser(user).stream().map(s -> norm(s.getSkillName())).collect(Collectors.toSet());

        Set<MatchResult> results = new LinkedHashSet<>();

        // For each skill that A offers, find users who want it
        for (String skillAOffers : aOffers) {
            Set<Long> usersWhoWant = wantMap.getOrDefault(skillAOffers, Collections.emptySet());
            for (Long bId : usersWhoWant) {
                if (Objects.equals(bId, userId)) continue;
                // Check if B offers something A wants
                Set<String> bOffers = offeredRepo.findByUser(userService.getByIdEntity(bId)).stream()
                        .map(s -> norm(s.getSkillName())).collect(Collectors.toSet());

                // Find intersection: bOffers ∩ aWants
                for (String s : bOffers) {
                    if (aWants.contains(s)) {
                        results.add(new MatchResult(userId, bId, skillAOffers, s));
                    }
                }
            }
        }
        return new ArrayList<>(results);
    }
}
