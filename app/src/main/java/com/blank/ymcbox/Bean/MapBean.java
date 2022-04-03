package com.blank.ymcbox.Bean;
import androidx.annotation.Nullable;

public class MapBean { 

	public MapBean(){
		super();
	}
    private String worldName;
	private String worldIcon;
	private String path;
	private String description;
	public MapBean(String path){
		this.path=path;
	}
    public String getName() {
		return this.worldName;
	}
	public String getPath() {
		return this.path;
	}
	public String getIcon() {
		return this.worldIcon;
	}
	public String getDescription(){ return this.description;	}
	public void setName(String name) {
		this.worldName=name;
	}
	public void setPath(String path) {
		this.path=path;
	}
	public void setIcon(String icon) {
		this.worldIcon=icon;
	}
	public void setTime(String time){ this.description=time; }
}
