package com.skillswap.backend.controller;

import com.skillswap.backend.model.Skill;
import com.skillswap.backend.repository.SkillRepo;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillRepo skillRepo;

    public SkillController(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillRepo.findAll();
    }

    // Get skill by ID
    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Optional<Skill> skill = skillRepo.findById(id);
        return skill.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create new skill
    @PostMapping
    public Skill createSkill(@Valid @RequestBody Skill skill) {
        return skillRepo.save(skill);
    }

    // Update skill
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @Valid @RequestBody Skill updatedSkill) {
        return skillRepo.findById(id)
                .map(skill -> {
                    skill.setName(updatedSkill.getName());
                    skill.setCategory(updatedSkill.getCategory());
                    skill.setDescription(updatedSkill.getDescription());
                    return ResponseEntity.ok(skillRepo.save(skill));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete skill
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        if (skillRepo.existsById(id)) {
            skillRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
