package com.mediavault.controller;

import com.mediavault.dto.SystemInfoDTO;
import com.mediavault.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    private final SystemInfoService systemInfoService;

    @Autowired
    public SystemController(SystemInfoService systemInfoService) {
        this.systemInfoService = systemInfoService;
    }

    @GetMapping("/info")
    public ResponseEntity<SystemInfoDTO>getSystemInfo() {
        return ResponseEntity.ok(systemInfoService.getSystemInfo());
    }
}
