package com.cms.platform.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDto {
    private Long id;
    private Long postId;
    private String source;
    private Integer views;
}