package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.UserDto;

public interface UserService {
    UserDto getProfile();
    UserDto updateProfile(UserDto userDto);
}