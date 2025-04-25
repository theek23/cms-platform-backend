package com.cms.platform.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteDto {
    private String id;
    private String name;
    private String customDomain;
    private String theme;
    private String status;
}
