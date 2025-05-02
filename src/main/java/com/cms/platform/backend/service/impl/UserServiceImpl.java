package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.repository.UserRepository;
import com.cms.platform.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getProfile(UserDto user) {
        userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(),user.getFullName(), user.getPhone(), user.getRole());
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        System.out.println("Updating user profile: " + userDto.getFullName());
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        userRepository.save(user);
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getFullName(), user.getPhone(), user.getRole());
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(),user.getFullName(), user.getPhone(), user.getRole());
    }
}

