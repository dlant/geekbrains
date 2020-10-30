package ru.dlant.cloud.storage.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class FileInfo {
    private String name;
    private long size;
    private FileType type;
    private LocalDateTime lastModified;

    public enum FileType {
        FILE("F"), DIRECTORY("D");
        private String name;

        public String getName() {
            return name;
        }

        FileType(String name) {
            this.name = name;
        }
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public FileInfo(Path path) {
        try {
            this.name = path.getFileName().toString();
            this.type = Files.isDirectory(path) ? FileType.DIRECTORY : FileType.FILE;
            if (Files.isDirectory(path)) {
                this.size = -1L;
            } else {
                this.size = Files.size(path);

            }
            this.lastModified = LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneOffset.ofHours(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileInfo(String name, long size, FileType type) {
        this.name = name;
        this.size = size;
        this.type = type;
        if (type == FileType.DIRECTORY) {
            this.size = -1L;
        }

    }


    public String getFileName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

}