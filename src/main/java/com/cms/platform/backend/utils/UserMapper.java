package com.cms.platform.backend.utils;

import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.entity.User;

public class UserMapper {
    public static UserDto toDto(User user) {
        if (user == null) return null;

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFullName(),
                user.getPhone(),
                user.getRole()
        );
    }
}