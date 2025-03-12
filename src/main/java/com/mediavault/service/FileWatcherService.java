package com.mediavault.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mediavault.service.MediaService;

@Service
public class FileWatcherService {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final MediaService mediaService;

    public FileWatcherService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @Async
    public void watchDirectory(Path path) {
        executorService.submit(() -> {
            try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
                path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
                System.out.println("Watching directory: " + path);

                while (!Thread.currentThread().isInterrupted()) {
                    WatchKey key = watchService.take();
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent<Path> ev = (WatchEvent<Path>) event;
                        Path filePath = path.resolve(ev.context());
                        System.out.println("New file detected: " + filePath);
                    }
                    key.reset();
                }
            } catch (IOException | InterruptedException e) {
                
            }
        });
    }
}
