/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.exception.PlaylistEmptyException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseConnectionService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    Connection connection;
    DatabaseConnectionService databaseConnectionService;
    List<Song> finalSongList;
    MusicPlayerService musicPlayerService;

    public PlaylistRepository() throws SQLException, ClassNotFoundException {
        databaseConnectionService=new DatabaseConnectionService();
        connection = databaseConnectionService.getConnectionToDatabase();
        finalSongList = new ArrayList<>();
        musicPlayerService=new MusicPlayerService();
    }

    /**
     * This method is used to get the record os a Playlist based on their name
     *
     * @param playlistName - name of the playlist
     * @return playlist object
     */
    public Playlist createPlaylist(String playlistName) throws PlaylistEmptyException {
        if(playlistName==null)
        {
            throw new PlaylistEmptyException("Playlist is not Created");
        }
        Playlist playlist = new Playlist();
        String insertQuery = "insert into jukebox.playlist(playlist_name) values (?);";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, playlistName);
            int result = statement.executeUpdate();
            if (result > 0) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    playlist.setPlaylistId(keys.getInt(1));
                    playlist.setPlaylistName(playlistName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlist;
    }
    /**
     * This method is used to update a  record in the playlist table
     *
     * @param playlistId- id of playlist
     * @param  songIds- new songIds
     * @return true if the record is updated successfully, false otherwise
     */
    public  boolean songAddToPlaylist(int playlistId,String songIds)
    {
        int rowCount=0;
        String query="update jukebox.playlist set song_ids = ? where playlist_id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, songIds);
            statement.setInt(2, playlistId);
            rowCount = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowCount>0;
    }
    /**
     * This method is used to get all the songs ids from the playlist table based on playlist ids in jukebox database
     * @param playlistId-id of playlist table
     * @return List of songs objects
     */
    public List<Song> getSongIdsFromPlaylist(int playlistId) throws PlaylistEmptyException {
        if(playlistId==0)
        {
            throw new PlaylistEmptyException("Id is empty");
        }
        List<Song> songs = new ArrayList<>();
        String query = "select * from jukebox.playlist where playlist_id = ?;";
        ResultSet resultSet;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playlistId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String songIds = resultSet.getString("song_ids");
                String[] songIdArray = songIds.split(",");
                for (String songId : songIdArray) {
                    Song song = new SongRepository().getSongBySongId(Integer.parseInt(songId));
                    songs.add(song);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return songs;
    }
    /**
     * This method is used to get all the records from the playlist table in jukebox  database
     *
     * @return List of playlist objects
     */
    public List<Playlist> displayAllPlaylist() {
        List<Playlist> listOfPlaylist=new ArrayList<>();
        String query="Select * from jukebox.playlist;";
        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                int playlistId = resultSet.getInt("playlist_id");
                String playlistName = resultSet.getString("playlist_name");
                Playlist playList=new Playlist(playlistId,playlistName);
                listOfPlaylist.add(playList);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfPlaylist;

    }
}
