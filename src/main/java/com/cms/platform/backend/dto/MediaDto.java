package com.cms.platform.backend.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaDto {
    private UUID id;
    private String url;
    private String type;
    private Long size;
    private UserDto userDto;
}