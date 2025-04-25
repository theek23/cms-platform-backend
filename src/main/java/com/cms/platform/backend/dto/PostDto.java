package com.cms.platform.backend.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private UUID id;
    private String title;
    private String content;
    private String seoTitle;
    private String seoDescription;
    private String status;
    private UUID siteId;
}