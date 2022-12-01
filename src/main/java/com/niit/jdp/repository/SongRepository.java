/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    Connection connection;
  DatabaseConnectionService databaseService;
    List<Song> finalSongList;
    public SongRepository() throws SQLException, ClassNotFoundException {
        databaseService = new DatabaseConnectionService();
        connection = databaseService.getConnectionToDatabase();
        finalSongList=new ArrayList<>();
    }
    public List<Song> displaySongs()
    {
        String query="Select * from jukebox.song;";
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String genreType = resultSet.getString("genre_type");
                String albumName = resultSet.getString("album_name");
                String artistName = resultSet.getString("artist_name");
                Song song=new Song(songId,songName,songDuration,genreType,artistName,albumName);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return finalSongList;

    }
    public void searchSongBySongName()
    {

    }
    public void  searchSongByArtist()
    {

    }
    public void searchSongByGenre()
    {

    }
    public void searchSongByAlbum()
    {

    }
}
