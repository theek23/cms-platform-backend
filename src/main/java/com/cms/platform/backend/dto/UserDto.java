package com.cms.platform.backend.dto;

import com.cms.platform.backend.entity.enums.Roles;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String username;
    private String email;
    private Roles role;
}
