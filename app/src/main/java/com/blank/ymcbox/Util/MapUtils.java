package com.blank.ymcbox.Util;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MapUtils {
    
    public static String getName(String path) throws FileNotFoundException, IOException{
		String name=null;
		if(new File(path+"/levelname.txt").exists()==true){
            StringBuffer buffer=new StringBuffer();
            BufferedReader read_name=new BufferedReader(new FileReader(path + "/levelname.txt"));
            name=read_name.readLine();
			}
	
	
		return name;
	}
    
	
	public static String getIcon(String path){
		String icon=null;
		if(new File(path+"/world_icon.jpeg").exists()==true){
             icon = path+"/world_icon.jpeg";
		}


		return icon;
	}
	
}
