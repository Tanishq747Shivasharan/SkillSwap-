package com.skillswap.backend.service;

import com.skillswap.backend.dto.CreateUserRequest;
import com.skillswap.backend.dto.UserResponse;
import com.skillswap.backend.exception.NotFoundException;
import com.skillswap.backend.model.User;
import com.skillswap.backend.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public UserResponse create(CreateUserRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setLocation(req.getLocation());
        User saved = userRepo.save(u);
        return new UserResponse(saved.getId(), saved.getName(), saved.getEmail(), saved.getLocation());
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepo.findAll().stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getEmail(), u.getLocation()))
                .toList();
    }

    @Transactional(readOnly = true)
    public User getByIdEntity(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
    }

    @Transactional(readOnly = true)
    public UserResponse getById(Long id) {
        User u = getByIdEntity(id);
        return new UserResponse(u.getId(), u.getName(), u.getEmail(), u.getLocation());
    }
}
