package com.niit.jdp.repository;

import com.niit.jdp.exception.PlaylistEmptyException;
import com.niit.jdp.exception.UserWrongInputException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistRepositoryTest {

    SongRepository songRepository;
    PlaylistRepository playListRepository;
    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        songRepository=new SongRepository();
        playListRepository=new PlaylistRepository();

    }

    @AfterEach
    void tearDown() {
        songRepository=null;
        playListRepository=null;
    }

    @Test
    void createPlaylistSuccess() throws PlaylistEmptyException {
     assertNotNull(playListRepository.createPlaylist("new playlistName"));
    }

    @Test
    void songAddToPlaylistSuccess() {
        //arrange
        boolean actualOutput=playListRepository.songAddToPlaylist(2,null);
        //assert
        assertTrue(actualOutput);
    }
    @Test
    void songAddToPlaylistFailure() {
        //arrange
        boolean actualOutput=playListRepository.songAddToPlaylist(2,null);
        //assert
        assertNotEquals(false,actualOutput);
    }
    @Test
    void getSongIdsFromPlaylistSuccess() throws PlaylistEmptyException {
        //arrange
        List<Song> actualOutput= null;
        actualOutput = playListRepository.getSongIdsFromPlaylist(4);
        //assert
        assertEquals(1,actualOutput.get(0).getSongId());
    }

    @Test
    void getSongIdsFromPlaylistFailure() throws PlaylistEmptyException, UserWrongInputException {
        //arrange
        List<Song> actualOutput= playListRepository.getSongIdsFromPlaylist(4);
        //assert
        assertNotEquals(2,actualOutput.get(0).getSongId());
    }

    @Test
    void displayAllPlaylistSuccess() {
        //act
        int expectedResult = 1;
        //arrange
        List<Playlist> playlistList = playListRepository.displayAllPlaylist();
        int actualResult = playlistList.get(0).getPlaylistId();
        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void displayAllPlaylistFailure() {
        //act
        int expectedResult = 2;
        //arrange
        List<Playlist> playlistList = playListRepository.displayAllPlaylist();
        int actualResult = playlistList.get(0).getPlaylistId();
        //assert
        assertNotEquals(expectedResult, actualResult);

    }
}