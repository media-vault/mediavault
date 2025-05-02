package com.mediavault.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    public SystemController() {
    }

    // Retrieve all system info
    @GetMapping("/info")
    public ResponseEntity<List<>>getSystemInfo{
    }
}
