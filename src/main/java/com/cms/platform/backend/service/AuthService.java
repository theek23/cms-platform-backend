package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.request.AuthResponse;
import com.cms.platform.backend.dto.request.LoginRequest;
import com.cms.platform.backend.dto.request.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}