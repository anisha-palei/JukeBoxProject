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

  @Override
  public String toString() {
    return String.format("\u001B[32m%-30s%-15s\u001B[0m", playlistId,playlistName);
  }
}
