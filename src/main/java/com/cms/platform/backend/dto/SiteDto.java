package com.cms.platform.backend.dto;

import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.entity.enums.SiteCategory;
import com.cms.platform.backend.entity.enums.SiteStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteDto {
    private UUID id;
    private String name;
    private String slug;
    private String customDomain;
    private String theme;
    private SiteCategory category;
    private SiteStatus status;
    private UserDto userDto;
}
