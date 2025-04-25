package com.cms.platform.backend.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDto {
    private UUID id;
    private UUID postId;
    private String source;
    private Integer views;
}