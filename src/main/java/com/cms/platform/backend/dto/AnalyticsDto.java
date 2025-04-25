package com.cms.platform.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDto {
    private String id;
    private String postId;
    private String source;
    private Integer views;
}