package com.blank.ymcbox.Bean;

import com.blank.ymcbox.Util.ResUtils;

import java.util.List;

public class AddonBean {
    private int format_version;

    private Header header;

    private List<Modules> modules;

    private List<Dependencies> dependencies;

    public void setFormat_version(int format_version) {
        this.format_version = format_version;
    }

    public int getFormat_version() {
        return format_version;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Header getHeader() {
        return header;
    }

    public void setModules(List<Modules> modules) {
        this.modules = modules;
    }

    public List<Modules> getModules() {
        return modules;
    }

    public void setDependencies(List<Dependencies> dependencies) {
        this.dependencies = dependencies;
    }

    public List<Dependencies> getDependencies() {
        return dependencies;
    }

    public static class Header {

        private String description;

        private String name;

        private String uuid;

        private List<Integer> version;

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getUuid() {
            return uuid;
        }

        public void setVersion(List<Integer> version) {
            this.version = version;
        }

        public List<Integer> getVersion() {
            return version;
        }

    }

    public static class Modules {

        private String description;

        private String type;

        private String uuid;

        private List<Integer> version;

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getUuid() {
            return uuid;
        }

        public void setVersion(List<Integer> version) {
            this.version = version;
        }

        public List<Integer> getVersion() {
            return version;
        }

    }

    public static class Dependencies {

        private String uuid;

        private List<Integer> version;

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getUuid() {
            return uuid;
        }

        public void setVersion(List<Integer> version) {
            this.version = version;
        }

        public List<Integer> getVersion() {
            return version;
        }

    }
}