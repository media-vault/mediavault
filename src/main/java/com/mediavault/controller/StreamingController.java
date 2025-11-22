package com.mediavault.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/stream")
public class StreamingController {
        
        private static final String MOVIE_DIRECTORY = "/media";
    
        @GetMapping("/{filename}")
        public ResponseEntity<Resource> streamMedia(@PathVariable String filename, @RequestHeader HttpHeaders headers) {
            try {
                    Path filePath = Paths.get(MOVIE_DIRECTORY).resolve(filename).normalize();
                
                    Resource fileResource = new UrlResource(filePath.toUri());
                    
                    if (!fileResource.exists() || !fileResource.isReadable()) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                    }
                
                    List<HttpRange> ranges = headers.getRange();
                    return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                    .body(fileResource);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
}
