/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Objects.equals(songName, song.songName) && Objects.equals(songDuration, song.songDuration) && Objects.equals(genreType, song.genreType) && Objects.equals(artistName, song.artistName) && Objects.equals(albumName, song.albumName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, songDuration, genreType, artistName, albumName);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songDuration='" + songDuration + '\'' +
                ", genreType='" + genreType + '\'' +
                ", artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
