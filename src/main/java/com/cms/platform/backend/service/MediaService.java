package com.cms.platform.backend.service;

import com.cms.platform.backend.dto.MediaDto;
import com.cms.platform.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.UUID;

public interface MediaService {
    MediaDto uploadMedia(MultipartFile file, User user);
    Page<MediaDto> getMediaByUser(User user, int page, int size);
    void deleteMedia(UUID id);
}
