package com.xjsd.ai.assistant.core.api.music;

import androidx.annotation.Keep;

@Keep
public class MediaModel {
    private String album;
    private String artist;
    private String cmdType;
    private String controlType;
    private String favoriteType;
    private String genre;
    private String list;
    private String nlgId;
    private String plate;
    private String playMode;
    private String playQueryType;
    private String player;
    private String query;
    private String queryTarget;
    private String sessionId;
    private String source;
    private String tag;
    private String target_device;
    private String title;

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getCmdType() {
        return this.cmdType;
    }

    public String getControlType() {
        return this.controlType;
    }

    public String getFavoriteType() {
        return this.favoriteType;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getList() {
        return this.list;
    }

    public String getNlgId() {
        return this.nlgId;
    }

    public String getPlate() {
        return this.plate;
    }

    public String getPlayMode() {
        return this.playMode;
    }

    public String getPlayQueryType() {
        return this.playQueryType;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getQuery() {
        return this.query;
    }

    public String getQueryTarget() {
        return this.queryTarget;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSource() {
        return this.source;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTarget_device() {
        return this.target_device;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public void setCmdType(String str) {
        this.cmdType = str;
    }

    public void setControlType(String str) {
        this.controlType = str;
    }

    public void setFavoriteType(String str) {
        this.favoriteType = str;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setList(String str) {
        this.list = str;
    }

    public void setNlgId(String str) {
        this.nlgId = str;
    }

    public void setPlate(String str) {
        this.plate = str;
    }

    public void setPlayMode(String str) {
        this.playMode = str;
    }

    public void setPlayQueryType(String str) {
        this.playQueryType = str;
    }

    public void setPlayer(String str) {
        this.player = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public void setQueryTarget(String str) {
        this.queryTarget = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTarget_device(String str) {
        this.target_device = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "MediaModel{nlgId='" + this.nlgId + '\'' + ", cmdType='" + this.cmdType + '\'' + ", artist='" + this.artist + '\'' + ", title='" + this.title + '\'' + ", album='" + this.album + '\'' + ", genre='" + this.genre + '\'' + ", source='" + this.source + '\'' + ", player='" + this.player + '\'' + ", list='" + this.list + '\'' + ", plate='" + this.plate + '\'' + ", target_device='" + this.target_device + '\'' + ", tag='" + this.tag + '\'' + ", query='" + this.query + '\'' + ", playMode='" + this.playMode + '\'' + ", queryTarget='" + this.queryTarget + '\'' + ", favoriteType='" + this.favoriteType + '\'' + ", controlType='" + this.controlType + '\'' + ", playQueryType='" + this.playQueryType + '\'' + '}';
    }
}
