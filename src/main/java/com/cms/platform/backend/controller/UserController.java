package com.cms.platform.backend.controller;

import com.cms.platform.backend.dto.UpdateUserDto;
import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserDto> getProfile(@AuthenticationPrincipal User user) {
        UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getEmail(),user.getFullName(), user.getPhone(), user.getRole());
        return ResponseEntity.ok(userService.getProfile(userDto));
    }

    @PutMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserDto> updateProfile(@AuthenticationPrincipal User user, @RequestBody UpdateUserDto updateUserDto) {
        UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getEmail(),updateUserDto.getFullName(), updateUserDto.getPhone(), user.getRole());
        return ResponseEntity.ok(userService.updateProfile(userDto));
    }
}
