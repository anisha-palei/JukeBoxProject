/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseConnectionService;

import java.sql.*;
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
    public Song searchSongByName(String songName) {

        String query = " SELECT * FROM jukebox.song where (song_name = ? );";
        Song song = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String name = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String genreType = resultSet.getString("genre_type");
                String albumName = resultSet.getString("album_name");
                String artistName = resultSet.getString("artist_name");
                song=new Song(songId,songName,songDuration,genreType,artistName,albumName);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return song;

    }
    public List<Song> searchByAlbumName(String albumName)
    {
        String query= " select * from juke.song where albumName = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,albumName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String genreType = resultSet.getString("genre_type");
                String name = resultSet.getString("album_name");
                String artistName = resultSet.getString("artist_name");
                Song song=new Song(songId,songName,songDuration,genreType,artistName,albumName);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  finalSongList;
    }
    public List<Song> searchByArtistName(String artistName)
    {
        String query= " select * from sales.song where artistName = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("songDuration");
                String genreType = resultSet.getString("genre_type");
                String albumName = resultSet.getString("album_name");
                String name = resultSet.getString("artist_name");
                Song song=new Song(songId,songName,songDuration,genreType,artistName,albumName);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  finalSongList;
    }
    public void searchSongByAlbum()
    {

    }
}
