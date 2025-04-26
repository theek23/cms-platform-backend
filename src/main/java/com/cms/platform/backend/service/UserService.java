package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.UserDto;
import com.cms.platform.backend.entity.User;

public interface UserService {
    UserDto getProfile(User user);
    UserDto updateProfile(UserDto userDto);
}