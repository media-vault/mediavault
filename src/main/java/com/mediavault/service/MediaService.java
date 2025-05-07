package com.mediavault.service;

import com.mediavault.entity.Media;
import com.mediavault.entity.MediaType;
import com.mediavault.repository.MediaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {
    public final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }
    
    // Retrieve all media
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    // Retrieve media by ID
    public Media getMediaById(Long id) {
        return mediaRepository.findById(id).orElse(null);
    }

    // Search for media by title
    public List<Media> searchMedia(String title) {
        return mediaRepository.findByTitleContainingIgnoreCase(title);
    }

    // Filter by MediaType
    public List<Media> getMediaByType(MediaType mediaType) {
        return mediaRepository.findByMediaType(mediaType);
    }

    // Add new media
    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    // Update exisiting media
    public Optional<Media> updateMedia(Long id, Media updatedMedia) {
        return mediaRepository.findById(id).map(existingMedia -> {
            existingMedia.setTitle(updatedMedia.getTitle());
            existingMedia.setFilePath(updatedMedia.getFilePath());
            existingMedia.setMediaType(updatedMedia.getMediaType());
            return mediaRepository.save(existingMedia);
        });
    }

    // Delete media by ID
    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}
