package com.mediavault.service;

import com.mediavault.dto.SystemInfoDTO;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class SystemInfoService {
    
    private final String serverId = UUID.randomUUID().toString(); // persist this later??
                                                                  
    public SystemInfoDTO getSystemInfo() {
        Runtime runtime = Runtime.getRuntime();

        String serverName = "MediaVault";
        String version = "1.0.0"; // TODO: inject from application.properties
        String operatingSystem  = System.getProperty("os.name") + " " + System.getProperty("os.version");
        String architecture = System.getProperty("os.arch");
        ZonedDateTime localTime = ZonedDateTime.now();
        String timeZone = ZoneId.systemDefault().toString();
        String startupPath = Paths.get("").toAbsolutePath().toString();
        String javaVersion = System.getProperty("java.version");
        int processorCount = runtime.availableProcessors();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        return new SystemInfoDTO(
                serverName,
                serverId,
                version,
                operatingSystem,
                architecture,
                localTime,
                timeZone,
                startupPath,
                javaVersion,
                processorCount,
                totalMemory,
                freeMemory
        );
    }
}

