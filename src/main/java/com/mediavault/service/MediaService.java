package com.mediavault.service;

import com.mediavault.entity.Media;
import com.mediavault.repository.MediaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MediaService {
    public final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Media getMediaById(Long id) {
        return mediaRepository.findById(id).orElse(null);
    }

    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }
}
