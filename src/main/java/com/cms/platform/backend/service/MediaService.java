package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.MediaDto;
import com.cms.platform.backend.entity.User;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

public interface MediaService {
    MediaDto uploadMedia(MultipartFile file, User user);
    List<MediaDto> getMediaByUser(User user);
    void deleteMedia(UUID id);
}
