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

}
