package com.skillswap.backend.service;

import com.skillswap.backend.dto.CreateSkillRequest;
import com.skillswap.backend.dto.SkillResponse;
import com.skillswap.backend.model.SkillOffered;
import com.skillswap.backend.model.SkillRequested;
import com.skillswap.backend.model.User;
import com.skillswap.backend.repository.SkillOfferedRepo;
import com.skillswap.backend.repository.SkillRequestedRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillService {

    private final SkillOfferedRepo offeredRepo;
    private final SkillRequestedRepo requestedRepo;
    private final UserService userService;

    public SkillService(SkillOfferedRepo o, SkillRequestedRepo r, UserService userService) {
        this.offeredRepo = o;
        this.requestedRepo = r;
        this.userService = userService;
    }

    @Transactional
    public SkillResponse addOffered(CreateSkillRequest req) {
        User u = userService.getByIdEntity(req.getUserId());
        SkillOffered s = new SkillOffered();
        s.setUser(u);
        s.setSkillName(req.getSkillName().trim());
        s.setDescription(req.getDescription());
        SkillOffered saved = offeredRepo.save(s);
        return new SkillResponse(saved.getId(), u.getId(), saved.getSkillName(), saved.getDescription());
    }

    @Transactional
    public SkillResponse addRequested(CreateSkillRequest req) {
        User u = userService.getByIdEntity(req.getUserId());
        SkillRequested s = new SkillRequested();
        s.setUser(u);
        s.setSkillName(req.getSkillName().trim());
        s.setDescription(req.getDescription());
        SkillRequested saved = requestedRepo.save(s);
        return new SkillResponse(saved.getId(), u.getId(), saved.getSkillName(), saved.getDescription());
    }

    @Transactional(readOnly = true)
    public List<SkillResponse> listOffered() {
        return offeredRepo.findAll().stream()
                .map(s -> new SkillResponse(s.getId(), s.getUser().getId(), s.getSkillName(), s.getDescription()))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SkillResponse> listRequested() {
        return requestedRepo.findAll().stream()
                .map(s -> new SkillResponse(s.getId(), s.getUser().getId(), s.getSkillName(), s.getDescription()))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SkillResponse> listOfferedByUser(Long userId) {
        User u = userService.getByIdEntity(userId);
        return offeredRepo.findByUser(u).stream()
                .map(s -> new SkillResponse(s.getId(), userId, s.getSkillName(), s.getDescription()))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<SkillResponse> listRequestedByUser(Long userId) {
        User u = userService.getByIdEntity(userId);
        return requestedRepo.findByUser(u).stream()
                .map(s -> new SkillResponse(s.getId(), userId, s.getSkillName(), s.getDescription()))
                .toList();
    }
}
