package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.MediaDto;
import com.cms.platform.backend.entity.Media;
import com.cms.platform.backend.repository.MediaRepository;
import com.cms.platform.backend.repository.UserRepository;
import com.cms.platform.backend.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;
    private final UserRepository userRepository;

    @Override
    public MediaDto uploadMedia(MultipartFile file) {
        Media media = new Media();
        media.setUrl("https://dummy-s3-url.com/" + file.getOriginalFilename());
        media.setType(com.cms.platform.backend.entity.enums.MediaType.IMAGE);
        media.setSize(file.getSize());
        media.setUser(userRepository.findById("").orElseThrow()); // mock user
        mediaRepository.save(media);
        return new MediaDto(media.getId(), media.getUrl(), media.getType().toString(), media.getSize());
    }

    @Override
    public List<MediaDto> getMediaBySite(UUID siteId) {
        return mediaRepository.findByUserId(siteId).stream()
                .map(m -> new MediaDto(m.getId(), m.getUrl(), m.getType().toString(), m.getSize()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMedia(UUID id) {
        mediaRepository.deleteById(id);
    }
}
