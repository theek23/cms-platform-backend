package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.MediaDto;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

public interface MediaService {
    MediaDto uploadMedia(MultipartFile file);
    List<MediaDto> getMediaBySite(UUID siteId);
    void deleteMedia(UUID id);
}
