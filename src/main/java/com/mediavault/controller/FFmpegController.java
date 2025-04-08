package com.mediavault.controller;

import com.mediavault.service.FFmpegService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ffmpeg")
public class FFmpegController {

    private final FFmpegService ffmpegService;

    @Autowired
    public FFmpegController(FFmpegService ffmpegService) {
        this.ffmpegService = ffmpegService;
    }

    @PostMapping("/convert")
    public String convertVideo(@RequestParam String inputFilePath, @RequestParam String outputFilePath) {
        try {
            return ffmpegService.convertToMP4(inputFilePath, outputFilePath);
        } catch (IOException e) {
            return "Error during conversion: " + e.getMessage();
        }
    }

    @GetMapping("/metadata")
    public String getVideoMetadata(@RequestParam String inputFilePath) {
        try {
            return ffmpegService.extractMetadata(inputFilePath);
        } catch (IOException e) {
            return "Error fetching metadata: " + e.getMessage();
        }
    }
}
