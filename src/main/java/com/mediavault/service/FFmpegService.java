package com.mediavault.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class FFmpegService {

    public String executeFFmpegCommand(String command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        try {
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("FFmpeg process failed with exit code " + exitCode);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("FFmpeg process was interrupted", e);
        }

        return output.toString();
    }

    // Example: Convert video to MP4
    public String convertToMP4(String inputFilePath, String outputFilePath) throws IOException {
        String command = "ffmpeg -i " + inputFilePath + " " + outputFilePath;
        return executeFFmpegCommand(command);
    }

    // Example: Extract video metadata
    public String extractMetadata(String inputFilePath) throws IOException {
        String command = "ffmpeg -i " + inputFilePath;
        return executeFFmpegCommand(command);
    }
}
