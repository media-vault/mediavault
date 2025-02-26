package com.mediavault.service;

import com.mediavault.entity.Media;
import com.mediavault.repository.MediaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
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
    
    @PostConstruct
    @Transactional
    public void initDatabase() {
        if (mediaRepository.count() == 0) {
            mediaRepository.saveAll(List.of(
                new Media(null, "Inception", "/media/movies/inception.mp4", "https://image.tmbd.org/t/p/w500/xyz.jpg", 2010),
                new Media(null, "The Matrix", "/media/movies/matrix.mp4", "https://image.tmbd.org/t/p/w500/abc.jpg", 1999),
                new Media(null, "Interstellar", "/media/movies/interstellar.mp4", "https://image.tmbd.org/t/p/w500/pqr.jpg", 2014)
            ));
            System.out.println("Bootstrapped test data.");
        }
    }
}
