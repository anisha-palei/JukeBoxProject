/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseConnectionService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Playlist createPlaylist(String playlistName)
    {
        Playlist playlist = new Playlist();
        String insertQuery = "insert into jukebox.playlist values (?);";
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
    public List<Song> getSonglistFromPlaylist(int playlistId)  {
        List<Song> songs = new ArrayList<>();
        String query = "select * from sales.playlist where playlist_id = ?;";
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
}
