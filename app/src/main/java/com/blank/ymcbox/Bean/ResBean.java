package com.blank.ymcbox.Bean;

import com.blank.ymcbox.Util.ResUtils;

import java.util.List;

public class ResBean {

   // public String getIcon(){
     //   return ResUtils.getIcon(this.path) + "/pack_icon.png";
   // }

    private int format_version;

    private Header header;

    //public String path;

    private List<Modules> modules;

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

    public static class Header {

        private String name;

        private String description;

        private String uuid;

        private List<Integer> version;

        private List<Integer> min_engine_version;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
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

        public void setMin_engine_version(List<Integer> min_engine_version) {
            this.min_engine_version = min_engine_version;
        }

        public List<Integer> getMin_engine_version() {
            return min_engine_version;
        }

    }

    public static class Modules {

        private String type;

        private String uuid;

        private List<Integer> version;

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

    }}
