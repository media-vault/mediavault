package com.mediavault.repository;

import com.mediavault.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByTitleContaining(String title);
}
