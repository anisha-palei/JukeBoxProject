/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

public class Playlist {
  private int playlistId;
  private String playlistName;

  private List<Song> songList;

  public Playlist() {
  }

  public Playlist(int playlistId, String playlistName, List<Song> songList) {
    this.playlistId = playlistId;
    this.playlistName = playlistName;
    this.songList = songList;
  }

  public Playlist(int playlistId, String playlistName) {
    this.playlistId = playlistId;
    this.playlistName = playlistName;
  }

  public int getPlaylistId() {
    return playlistId;
  }

  public void setPlaylistId(int playlistId) {
    this.playlistId = playlistId;
  }

  public String getPlaylistName() {
    return playlistName;
  }

  public void setPlaylistName(String playlistName) {
    this.playlistName = playlistName;
  }

  public List<Song> getSongList() {
    return songList;
  }

  public void setSongList(List<Song> songList) {
    this.songList = songList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Playlist playlist = (Playlist) o;
    return playlistId == playlist.playlistId && Objects.equals(playlistName, playlist.playlistName) && Objects.equals(songList, playlist.songList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playlistId, playlistName, songList);
  }

  @Override
  public String toString() {
    return "Playlist{" +
            "playlistId=" + playlistId +
            ", playlistName='" + playlistName + '\'' +
            ", songList=" + songList +
            '}';
  }
}
