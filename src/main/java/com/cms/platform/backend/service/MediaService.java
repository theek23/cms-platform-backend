package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.MediaDto;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface MediaService {
    MediaDto uploadMedia(MultipartFile file);
    List<MediaDto> getMediaBySite(String siteId);
    void deleteMedia(String id);
}
