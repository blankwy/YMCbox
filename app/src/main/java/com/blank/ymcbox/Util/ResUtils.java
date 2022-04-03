package com.blank.ymcbox.Util;

import com.blank.ymcbox.Bean.AddonBean;
import com.blank.ymcbox.Bean.ResBean;
import com.google.gson.Gson;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResUtils {

    public static AddonBean getAddon(String path) throws IOException {
        String path1=path+"/manifest.json";
        return (new Gson()).fromJson(FileUtils.fileRead(path1), AddonBean.class);
    }

    public static ResBean getRes(String path) throws IOException {
        String path1=path+"/manifest.json";
        return (new Gson()).fromJson(FileUtils.fileRead(path1), ResBean.class);
    }

    public static String getIcon(String path){
        String icon=null;
        if(new File(path+"/pack_icon.png").exists()==true){
            icon = path+"/pack_icon.png";
        }


        return icon;
    }
}
