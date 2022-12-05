package com.niit.jdp;

import com.niit.jdp.exception.PlaylistEmptyException;
import com.niit.jdp.exception.UserWrongInputException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JukeBoxMainTest {

    SongRepository songRepository;
    Song song;
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
    public void displayAllSongsSuccess()
    {
       int expected=8;
        //arrange
        List<Song> actualOutput= songRepository.displaySongs();
        //assert
        assertEquals(expected,actualOutput.size());

    }
    @Test
    public void displayAllSongsFailure()
    {
        //act
       int expectedOutput=10;
        //arrange
        List<Song> actualOutput= songRepository.displaySongs();
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());

    }

    @Test
    public void searchSongByNameSuccess() throws UserWrongInputException {
        //act
        int expectedOutput=1;
        //arrange
        int actualOutput= songRepository.searchSongByName("Kesariya").getSongId();
        //assert
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void searchSongByNameFailure() throws UserWrongInputException {
        //act
        int expectedOutput=2;
        //arrange
        int actualOutput= songRepository.searchSongByName("Kesariya").getSongId();
        //assert
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    public void searchSongByAlbumNameSuccess() throws UserWrongInputException {

        //act
        int expectedOutput=2;
        //arrange
        List<Song> actualOutput= songRepository.searchByAlbumName("Brahmastra");
        //assert
        assertEquals(expectedOutput,actualOutput.size());
    }

    @Test
    public void searchSongByAlbumNameFailure() throws UserWrongInputException {
        //act
        int expectedOutput=1;
        //arrange
        List<Song> actualOutput= songRepository.searchByAlbumName("Brahmastra");
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());
    }
    @Test
    public void searchSongByArtistNameSuccess()
    {
        //act
       int expectedOutput=1;
        //arrange
        List<Song> actualOutput= songRepository.searchByArtistName("Arijit singh");
        //assert
        assertEquals(expectedOutput,actualOutput.size());
    }

    @Test
    public void searchSongByArtistNameFailure()
    {
        //act
        int expectedOutput=2;
        //arrange
        List<Song> actualOutput= songRepository.searchByArtistName("Arijit singh");
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());
    }

    @Test
    public void searchSongByGenreTypeSuccess()
    {

        //act
        int expectedOutput=1;
        //arrange
        List<Song> actualOutput= songRepository.searchByGenre("Romance");
        //assert
        assertEquals(expectedOutput,actualOutput.size());
    }

    @Test
    public void searchSongByGenreTypeFailure()
    {
        //act
        int expectedOutput=2;
        //arrange
        List<Song> actualOutput= songRepository.searchByGenre("Romance");
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());
    }

    @Test
    public void addSongToPlaylistSuccess()
    {
        //arrange
        boolean actualOutput=playListRepository.songAddToPlaylist(2,null);
        //assert
        assertEquals(true,actualOutput);
    }

    @Test
    public void addSongToPlaylistFailure()
    {
        //arrange
        boolean actualOutput=playListRepository.songAddToPlaylist(2,null);
        //assert
        assertNotEquals(false,actualOutput);
    }

    @Test
    public void getSongsFromPlaylistSuccess() throws PlaylistEmptyException {
        //arrange
        List<Song> actualOutput= playListRepository.getSongIdsFromPlaylist(4);
        //assert
        assertEquals(1,actualOutput.get(0).getSongId());
    }
    @Test
    public void getSongsFromPlaylistFailure() throws PlaylistEmptyException {
        //arrange
        List<Song> actualOutput= playListRepository.getSongIdsFromPlaylist(4);
        //assert
        assertNotEquals(2,actualOutput.get(0).getSongId());
    }
    @Test
    public void displayAllPlaylistSuccess()
    {
        int expected=8;
        //arrange
        List<Playlist> actualOutput= playListRepository.displayAllPlaylist();
        //assert
        assertEquals(expected,actualOutput.size());
    }

    @Test
    public void displayAllPlaylistFailure()
    {

        int expected=2;
        //arrange
        List<Playlist> actualOutput= playListRepository.displayAllPlaylist();
        //assert
        assertNotEquals(expected,actualOutput.size());
    }

}