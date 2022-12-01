/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

public class Song {
    private int songId;
    private  String songName;
    private  String songDuration;
    private String genreType;
    private String artistName;
    private String albumName;

    public Song() {
    }

    public Song(int songId, String songName, String songDuration, String genreType, String artistName, String albumName) {
        this.songId = songId;
        this.songName = songName;
        this.songDuration = songDuration;
        this.genreType = genreType;
        this.artistName = artistName;
        this.albumName = albumName;
    }


}
