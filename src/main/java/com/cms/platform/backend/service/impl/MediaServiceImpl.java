package com.cms.platform.backend.service.impl;

import com.cms.platform.backend.dto.MediaDto;
import com.cms.platform.backend.entity.Media;
import com.cms.platform.backend.entity.User;
import com.cms.platform.backend.entity.enums.MediaType;
import com.cms.platform.backend.repository.MediaRepository;
import com.cms.platform.backend.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import static com.cms.platform.backend.utils.UserMapper.toDto;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final S3Client s3Client;
    private final MediaRepository mediaRepository;

    @Value("${aws.s3.bucket}")
    private String bucket;

    @Override
    public MediaDto uploadMedia(MultipartFile file, User user) {
        try {
            // Create folder path using userId
            String folderPath = user.getId().toString() + "/";
            String key = folderPath + UUID.randomUUID() + "_" + file.getOriginalFilename();

            // Create the PutObjectRequest with the full path
            PutObjectRequest putRequest = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .contentType(file.getContentType())
                    .build();

            // Upload file to S3
            s3Client.putObject(putRequest, RequestBody.fromBytes(file.getBytes()));

            // Get the file URL
            String fileUrl = s3Client.utilities().getUrl(GetUrlRequest.builder()
                    .bucket(bucket)
                    .key(key)
                    .build()).toExternalForm();

            // Save media metadata to database
            Media media = new Media();
            media.setUrl(fileUrl);
            media.setType(MediaType.IMAGE);
            media.setSize(file.getSize());
            media.setUser(user);
            mediaRepository.save(media);

            return new MediaDto(media.getId(), media.getUrl(), media.getType().toString(), media.getSize(), toDto(media.getUser()));

        } catch (IOException e) {
            throw new RuntimeException("S3 upload failed", e);
        }
    }

    @Override
    public Page<MediaDto> getMediaByUser(User user,int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "uploadedAt"));
        Page<Media> mediaPage = mediaRepository.findByUserId(user.getId(), pageable);

        return mediaPage.map(m -> new MediaDto(
                m.getId(),
                m.getUrl(),
                m.getType().toString(),
                m.getSize(),
                toDto(m.getUser())
        ));
    }

    @Override
    public void deleteMedia(UUID id) {
        mediaRepository.deleteById(id);
    }
}
