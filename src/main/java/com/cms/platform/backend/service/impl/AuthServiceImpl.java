package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.dto.request.AuthResponse;
import com.cms.platform.backend.dto.request.LoginRequest;
import com.cms.platform.backend.dto.request.RegisterRequest;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.repository.UserRepository;
import com.cms.platform.backend.security.JwtProvider;
import com.cms.platform.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token, new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole()));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token, new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getRole()));
    }
}