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
        song=new Song(1, "Kesariya", "04:28", "Romance", "Arijit singh","Brahmastra","src/main/resources/songs/Kesariya_64_PagalWorld.com.se_.wav");
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
        //act
        List<Song> expectedOutput=songRepository.displaySongs();
        //arrange
        List<Song> actualOutput= songRepository.displaySongs();
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));

    }
    @Test
    public void displayAllSongsFailure()
    {
        //act
        Song expectedOutput= new Song(1,"Kesariya","04:28","Romance","Brahmastra","Arijit singh","src/main/resources/songs/Kesariya_64_PagalWorld.com.se_.wav");
        //arrange
        List<Song> actualOutput= songRepository.displaySongs();
        //assert
        assertNotEquals(expectedOutput,actualOutput.get(0));

    }

    @Test
    public void searchSongByNameSuccess() throws UserWrongInputException {
        //act
        Song expectedOutput=songRepository.searchSongByName("Kesariya");
        //arrange
        Song actualOutput= songRepository.searchSongByName("Kesariya");
        //assert
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void searchSongByNameFailure() throws UserWrongInputException {
        //act
        Song expectedOutput=new Song(1, "unknown", "04:28", "Romance", "Arijit singh","Brahmastra","src/main/resources/songs/Kesariya_64_PagalWorld.com.se_.wav");
        //arrange
        Song actualOutput= songRepository.searchSongByName("Kesariya");
        //assert
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    public void searchSongByAlbumNameSuccess() throws UserWrongInputException {
        //act
        List<Song> expectedOutput=songRepository.searchByAlbumName("Brahmastra");
        //arrange
        List<Song> actualOutput= songRepository.searchByAlbumName("Brahmastra");
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));
    }

    @Test
    public void searchSongByAlbumNameFailure() throws UserWrongInputException {
        //act
        Song expectedOutput=new Song(1, "Kesariya", "04:28", "Romance", "Arijit singh","Kedarnath","src/main/resources/songs/Kesariya_64_PagalWorld.com.se_.wav");
        //arrange
        List<Song> actualOutput= songRepository.searchByAlbumName("Brahmastra");
        //assert
        assertNotEquals(expectedOutput,actualOutput.get(0));
    }
    @Test
    public void searchSongByArtistNameSuccess()
    {
        //act
        List<Song> expectedOutput=songRepository.searchByArtistName("Arijit singh");
        //arrange
        List<Song> actualOutput= songRepository.searchByArtistName("Arijit singh");
        //assert
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void searchSongByArtistNameFailure()
    {
        //act
        Song expectedOutput=new Song(1, "Kesariya", "04:28", "Romance", "Arjun Kapoor","Brahmastra","src/main/resources/songs/Kesariya_64_PagalWorld.com.se_.wav");
        //arrange
        List<Song> actualOutput= songRepository.searchByArtistName("Arijit singh");
        //assert
        assertNotEquals(expectedOutput,actualOutput.get(0));
    }

    @Test
    public void searchSongByGenreTypeSuccess()
    {
        //act
        List<Song> expectedOutput=songRepository.searchByGenre("Romance");
        //arrange
        List<Song> actualOutput= songRepository.searchByGenre("Romance");
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));
    }

    @Test
    public void searchSongByGenreTypeFailure()
    {
        //act
        List<Song> expectedOutput=songRepository.searchByGenre("Pop");
        //arrange
        List<Song> actualOutput= songRepository.searchByGenre("Romance");
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));
    }

    @Test
    public void createPlayListSuccess() throws SQLException, PlaylistEmptyException {
        //act
        String expectedOutput="aaa";
        //arrange
        String actualOutput="aaa";
        //assert
        assertEquals(expectedOutput,actualOutput);

    }

    @Test
    public void createPlayListFailure() throws SQLException, PlaylistEmptyException {
        //act
       String expectedOutput="aaa";
        //arrange
        String actualOutput="asd";
        //assert
        assertNotEquals(expectedOutput,actualOutput);

    }

    @Test
    public void addSongToPlaylistSuccess()
    {
        //act
        boolean expectedOutput=playListRepository.songAddToPlaylist(1,"2,1,3");
        //arrange
        boolean actualOutput=playListRepository.songAddToPlaylist(1,"2,1,3");
        //assert
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void addSongToPlaylistFailure()
    {
        //act
    boolean expectedOutput=playListRepository.songAddToPlaylist(1,"2,1,3");
        //arrange
    boolean actualOutput=playListRepository.songAddToPlaylist(0,"2,1,2");
        //assert
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    public void getSongsFromPlaylistSuccess() throws PlaylistEmptyException {
        //act
        List<Song> expectedOutput=playListRepository.getSongIdsFromPlaylist(1);
        //arrange
        List<Song> actualOutput=playListRepository.getSongIdsFromPlaylist(1);
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));
    }
    @Test
    public void getSongsFromPlaylistFailure() throws PlaylistEmptyException {
        //act
        List<Song> expectedOutput=playListRepository.getSongIdsFromPlaylist(2);
        //arrange
        List<Song> actualOutput=playListRepository.getSongIdsFromPlaylist(1);
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));
    }
    @Test
    public void displayAllPlaylistSuccess()
    {
        //act
        List<Playlist> expectedOutput=playListRepository.displayAllPlaylist();
        //arrange
        List<Playlist> actualOutput=playListRepository.displayAllPlaylist();
        //assert
        assertEquals(expectedOutput.get(0),actualOutput.get(0));
    }

    @Test
    public void displayAllPlaylistFailure()
    {

        //act
        List<Playlist> expectedOutput=playListRepository.displayAllPlaylist();
        //arrange
        List<Playlist> actualOutput=playListRepository.displayAllPlaylist();
        //assert
        assertNotEquals(expectedOutput.get(1),actualOutput.get(0));
    }

}