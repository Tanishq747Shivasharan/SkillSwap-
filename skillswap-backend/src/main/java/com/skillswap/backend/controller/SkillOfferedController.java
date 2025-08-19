package com.skillswap.backend.controller;

import com.skillswap.backend.dto.CreateSkillRequest;
import com.skillswap.backend.dto.SkillResponse;
import com.skillswap.backend.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills/offered")
public class SkillOfferedController {

    private final SkillService service;

    public SkillOfferedController(SkillService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SkillResponse add(@Valid @RequestBody CreateSkillRequest req) {
        return service.addOffered(req);
    }

    @GetMapping
    public List<SkillResponse> list() {
        return service.listOffered();
    }

    @GetMapping("/user/{userId}")
    public List<SkillResponse> listByUser(@PathVariable Long userId) {
        return service.listOfferedByUser(userId);
    }
}
