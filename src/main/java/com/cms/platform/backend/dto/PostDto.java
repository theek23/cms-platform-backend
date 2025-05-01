package com.cms.platform.backend.dto;

import com.cms.platform.backend.entity.enums.PostStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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
    private PostStatus status;
    private List<String> tags;
    private Number views;
    private String thumbnail;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID siteId;

}