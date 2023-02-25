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
    /**
     * This method is used to get all the records from the songs table in jukebox database
     *
     * @return List of songs objects
     */
    public List<Song> displaySongs()
    {
        String query="Select * from jukebox.song;";
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            finalSongList.clear();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String genreType = resultSet.getString("genre_type");
                String albumName = resultSet.getString("album_name");
                String artistName = resultSet.getString("artist_name");
                String songPath = resultSet.getString("song_path");
                Song song=new Song(songId,songName,songDuration,genreType,albumName,artistName,songPath);
                finalSongList.add(song);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return finalSongList;

    }
    /**
     * This method is used to get the record os a Song based on their song name
     *
     * @param songName - songName of the song table
     * @return song object
     */
    public Song searchSongByName(String songName)  {
        Song song = null;
        String query = " SELECT * FROM jukebox.song where (song_name = ? );";

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
                String songPath = resultSet.getString("song_path");
                 song=new Song(songId,songName,songDuration,genreType,albumName,artistName,songPath);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return song;

    }
    /**
     * This method is used to get all the records from the songs table in jukebox database
     * @param albumName-albumName of song table
     *
     * @return List of songs objects
     */
    public List<Song> searchByAlbumName(String albumName) throws UserWrongInputException {
        String query= " select * from jukebox.song where album_name = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,albumName);
            ResultSet resultSet = preparedStatement.executeQuery();
            finalSongList.clear();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String genreType = resultSet.getString("genre_type");
                String name = resultSet.getString("album_name");
                String artistName = resultSet.getString("artist_name");
                String songPath = resultSet.getString("song_path");
                Song song=new Song(songId,songName,songDuration,genreType,albumName,artistName,songPath);;
                finalSongList.add(song);

            }
            if(finalSongList.isEmpty())
            {
                throw new UserWrongInputException("Entered the wrong album name");
            }
        } catch (SQLException | UserWrongInputException e) {
            System.err.println(e.getMessage());
        }
        return  finalSongList;
    }
    /**
     * This method is used to get all the records from the songs table in jukebox database
     * @param artistName-name of artist
     *
     * @return List of songs objects
     */
    public List<Song> searchByArtistName(String artistName)
    {
        String query= " select * from jukebox.song where artist_name = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,artistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            finalSongList.clear();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String genreType = resultSet.getString("genre_type");
                String albumName = resultSet.getString("album_name");
                String name = resultSet.getString("artist_name");
                String songPath = resultSet.getString("song_path");
                Song song=new Song(songId,songName,songDuration,genreType,albumName,artistName,songPath);
                finalSongList.add(song);

            }
            if(finalSongList.isEmpty())
            {
                throw new UserWrongInputException("Entered the wrong artist name");
            }
        } catch (SQLException | UserWrongInputException e) {
            System.err.println(e.getMessage());
        }
        return  finalSongList;
    }
    /**
     * This method is used to get all the records from the songs table in jukebox database
     * @param genreType -type of genre in song table
     *
     * @return List of songs objects
     */
    public List<Song> searchByGenre(String genreType)
    {
        String query= " select * from jukebox.song where genre_type = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,genreType);
            ResultSet resultSet = preparedStatement.executeQuery();
            finalSongList.clear();
            while(resultSet.next())
            {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String songDuration = resultSet.getString("duration");
                String type = resultSet.getString("genre_type");
                String albumName = resultSet.getString("album_name");
                String artistName = resultSet.getString("artist_name");
                String songPath = resultSet.getString("song_path");
                Song song=new Song(songId,songName,songDuration,genreType,albumName,artistName,songPath);
                finalSongList.add(song);
            }
            if(finalSongList.isEmpty())
            {
                throw new UserWrongInputException("Entered the wrong genre type");
            }
        }   catch (SQLException | UserWrongInputException e) {
            System.err.println(e.getMessage());
        }
        return  finalSongList;
    }
    /**
     * This method is used to get the record os a Song based on their songId
     *
     * @param songId - id of the song
     * @return song object
     */
    public Song getSongBySongId(int songId) throws SQLException {
        Song song = new Song();
        String selectQuery = "select * from jukebox.song where song_id = ?;";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        statement.setInt(1, songId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("song_id");
            String songName = resultSet.getString("song_name");
            String songDuration = resultSet.getString("duration");
            String genreType = resultSet.getString("genre_type");
            String albumName = resultSet.getString("album_name");
            String artistName = resultSet.getString("artist_name");
            String songPath = resultSet.getString("song_path");
           song=new Song(songId,songName,songDuration,genreType,albumName,artistName,songPath);
        }
        return song;
    }
}
