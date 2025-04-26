package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.UserDto;

public interface UserService {
    UserDto getProfile(UserDto userDto);
    UserDto updateProfile(UserDto userDto);
    UserDto getUserByEmail(String email);
}