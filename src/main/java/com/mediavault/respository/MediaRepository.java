package com.mediavault.repository;

import com.mediavault.entity.Media;
import com.mediavault.entity.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByTitleContainingIgnoreCase(String title);
    List<Media> findByMediaType(MediaType mediaType);
}
