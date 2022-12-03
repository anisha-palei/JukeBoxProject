/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.exception.UserWrongInputException;
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
                String songPath = resultSet.getString("song_path");
                Song song=new Song(songId,songName,songDuration,genreType,artistName,albumName,songPath);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return finalSongList;

    }
    public Song searchSongByName(String songName) throws UserWrongInputException {
     if(songName==null)
     {
         throw new UserWrongInputException("Entered wrong Song name");
     }
        String query = " SELECT * FROM jukebox.song where (song_name = ? );";
        Song song = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String name = resultSet.getString("song_name");
                song=new Song(songId,songName);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return song;

    }
    public List<Song> searchByAlbumName(String albumName) throws UserWrongInputException {
        if(albumName==null)
        {
            throw new UserWrongInputException("Entered wrong album name");
        }
        String query= " select * from jukebox.song where album_name = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,albumName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String name = resultSet.getString("album_name");
                Song song=new Song(songId,songName);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  finalSongList;
    }
    public List<Song> searchByArtistName(String artistName)
    {
        String query= " select * from jukebox.song where artist_name = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                Song song=new Song(songId,songName);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  finalSongList;
    }
    public List<Song> searchByGenre(String genreType)
    {
        String query= " select * from jukebox.song where genre_type = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,genreType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                Song song=new Song(songId,songName);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  finalSongList;
    }
}
