package com.cms.platform.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
    private String email;
    private String fullName;
    private String phone;
}