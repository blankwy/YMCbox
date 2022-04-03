package com.blank.ymcbox.Bean;

public class ServerBean {
    
	private String status;

    private String host;

    private String motd;

    private int agreement;

    private String version;

    private int online;

    private int max;

    private String level_name;

    private String gamemode;

    private int delay;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public String getMotd() {
        return motd;
    }

    public void setAgreement(int agreement) {
        this.agreement = agreement;
    }

    public int getAgreement() {
        return agreement;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getOnline() {
        return online;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    public String getGamemode() {
        return gamemode;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
    
}
