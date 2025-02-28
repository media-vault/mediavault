package com.mediavault.controller;

import com.mediavault.entity.Media;
import com.mediavault.entity.MediaType;
import com.mediavault.service.MediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    
    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    // Retrieve all media
    @GetMapping
    public ResponseEntity<List<Media>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }

    // Retrieve media by ID
    @GetMapping("/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable Long id) {
        return ResponseEntity.ok(mediaService.getMediaById(id));
    }

    // Search for media by title
    @GetMapping("/search")
    public ResponseEntity<List<Media>> searchMedia(@PathVariable String title) {
        return ResponseEntity.ok(mediaService.searchMedia(title));
    }

    // Filter media by type
    @GetMapping("/type/{mediaType}")
    public ResponseEntity<List<Media>> getMediaByType(@PathVariable MediaType mediaType) {
        return ResponseEntity.ok(mediaService.getMediaByType(mediaType));
    }

    // Add new media
    @PostMapping
    public ResponseEntity<Media> addMedia(@RequestBody Media media) {
        return ResponseEntity.ok(mediaService.addMedia(media));
    }

    // Update existing media
    @PutMapping("/{id}")
    public ResponseEntity<Media> updateMedia(@PathVariable Long id, @RequestBody Media updatedMedia) {
        return mediaService.updateMedia(id, updatedMedia)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete media by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }
}
