package com.blank.ymcbox.Bean;

import java.io.File;

public class Item{
        private String name;
        private String description;
        private File icon;
        private String path;
        public Item(String name,String description,File icon,String path){
            this.name=name;
            this.description=description;
            this.icon=icon;
            this.path=path;
        }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public File getIcon() {
        return icon;
    }

    public String getDescription() {
        return description;
    }
}