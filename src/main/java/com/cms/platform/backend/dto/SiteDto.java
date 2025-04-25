package com.cms.platform.backend.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteDto {
    private UUID id;
    private String name;
    private String customDomain;
    private String theme;
    private String status;
}
