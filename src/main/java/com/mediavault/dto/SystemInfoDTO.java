package com.mediavault.dto;

import java.time.ZonedDateTime;

public class SystemInfoDTO {
    private String serverName;
    private String serverId;
    private String version;
    private String operatingSystem;
    private String architecture;
    private ZonedDateTime localTime;
    private String startupPath;
    private String javaVersion;
    private int processorCount;
    private long totalMemory;
    private long freeMemory;

    public SystemInfoDTO() {}

    public SystemInfoDTO(String serverName, String serverId, String version, String operatingSystem, String architecture, ZonedDateTime localTime, String startupPath, String javaVersion, int processorCount, long totalMemory, long freeMemory) {
        this.serverName = serverName;
        this.serverId = serverId;
        this.version = version;
        this.operatingSystem = operatingSystem;
        this.architecture = architecture;
        this.localTime = localTime;
        this.startupPath = startupPath;
        this.javaVersion = javaVersion;
        this.processorCount = processorCount;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
    }
}
