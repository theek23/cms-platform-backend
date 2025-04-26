package com.cms.platform.backend.dto.request;

import com.cms.platform.backend.entity.enums.Roles;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Roles role;
}