package com.mediavault.dto;

import java.time.ZonedDateTime;

public class SystemInfoDTO {
    private String serverName;
    private String serverId;
    private String version;
    private String operatingSystem;
    private String architecture;
    private ZonedDateTime localTime;
    private String timeZone;
    private String startupPath;
    private String javaVersion;
    private int processorCount;
    private long totalMemory;
    private long freeMemory;

    public SystemInfoDTO() {}

    public SystemInfoDTO(String serverName, String serverId, String version, String operatingSystem, String architecture, ZonedDateTime localTime, String timeZone, String startupPath, String javaVersion, int processorCount, long totalMemory, long freeMemory) {
        this.serverName = serverName;
        this.serverId = serverId;
        this.version = version;
        this.operatingSystem = operatingSystem;
        this.architecture = architecture;
        this.localTime = localTime;
        this.timeZone = timeZone;
        this.startupPath = startupPath;
        this.javaVersion = javaVersion;
        this.processorCount = processorCount;
        this.totalMemory = totalMemory;
        this.freeMemory = freeMemory;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerid(String serverId) {
        this.serverId = serverId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOperatinSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public ZonedDateTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(ZonedDateTime localTime) {
        this.localTime = localTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getStartupPath() {
        return startupPath;
    }

    public void setStartupPath(String startupPath) {
        this.startupPath = startupPath;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public int getProcessorCount() {
        return processorCount;
    }

    public void setProcessorCount(int processorCount) {
        this.processorCount = processorCount;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

}
