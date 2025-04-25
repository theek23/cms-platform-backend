package com.cms.platform.backend.dto;

import com.cms.platform.backend.entity.enums.Roles;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Roles role;
}
