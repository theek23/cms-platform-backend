package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserDto> getProfile() {
        return ResponseEntity.ok(userService.getProfile());
    }

    @PutMapping("/me")
    public ResponseEntity<UserDto> updateProfile(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateProfile(userDto));
    }
}

