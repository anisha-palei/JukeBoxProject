/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int songId;
    private String songName;
    private String songDuration;
    private String genreType;
    private String artistName;
    private String albumName;

    private String songPath;

    public Song() {
    }

    public Song(int songId, String songName, String albumName) {
        this.songId = songId;
        this.songName = songName;
        this.albumName = albumName;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public Song(int songId, String songName) {
        this.songId = songId;
        this.songName = songName;
    }

    public Song(int songId, String songName, String songDuration, String genreType, String artistName, String albumName, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.songDuration = songDuration;
        this.genreType = genreType;
        this.artistName = artistName;
        this.albumName = albumName;
        this.songPath = songPath;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }


    @Override
    public String toString() {

        return String.format("\u001B[32m%-10s%-20s\t%-20s\t%-25s\t%-20s\t%-15s\u001B[0m",  songId,songName,songDuration,genreType,albumName,artistName,songPath);

    }
}

