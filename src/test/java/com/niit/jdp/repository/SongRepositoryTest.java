package com.niit.jdp.repository;

import com.niit.jdp.exception.UserWrongInputException;
import com.niit.jdp.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongRepositoryTest {

    SongRepository songRepository;
    Song song;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        songRepository=new SongRepository();
    }

    @AfterEach
    void tearDown() {
        songRepository=null;
    }

    @Test
    void displaySongsSuccess() {
        int expected=8;
        //arrange
        List<Song> actualOutput= songRepository.displaySongs();
        //assert
        assertEquals(expected,actualOutput.size());
    }

    @Test
    void displaySongsFailure() {
        //act
        int expectedOutput=10;
        //arrange
        List<Song> actualOutput= songRepository.displaySongs();
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());

    }

    @Test
    void searchSongByNameSuccess() throws UserWrongInputException {
        //act
        int expectedOutput=1;
        //arrange
        int actualOutput= songRepository.searchSongByName("Kesariya").getSongId();
        //assert
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void searchSongByNameFailure() throws UserWrongInputException {
        //act
        int expectedOutput=2;
        //arrange
        int actualOutput= songRepository.searchSongByName("Kesariya").getSongId();
        //assert
        assertNotEquals(expectedOutput,actualOutput);
    }

    @Test
    void searchByAlbumNameSuccess() throws UserWrongInputException {
        //act
        int expectedOutput=2;
        //arrange
        List<Song> actualOutput= songRepository.searchByAlbumName("Brahmastra");
        //assert
        assertEquals(expectedOutput,actualOutput.size());
    }

    @Test
    void searchByAlbumNameFailure() throws UserWrongInputException {
        //act
        int expectedOutput = 1;
        //arrange
        List<Song> actualOutput = songRepository.searchByAlbumName("Brahmastra");
        //assert
        assertNotEquals(expectedOutput, actualOutput.size());

    }

    @Test
    void searchByArtistNameSuccess(){
        //act
        int expectedOutput=1;
        //arrange
        List<Song> actualOutput= songRepository.searchByArtistName("Arijit singh");
        //assert
        assertEquals(expectedOutput,actualOutput.size());

    }

    @Test
    void searchByArtistNameFailure(){
        //act
        int expectedOutput=2;
        //arrange
        List<Song> actualOutput= songRepository.searchByArtistName("Arijit singh");
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());
    }

    @Test
    void searchByGenreSuccess() {
        //act
        int expectedOutput=1;
        //arrange
        List<Song> actualOutput= songRepository.searchByGenre("Romance");
        //assert
        assertEquals(expectedOutput,actualOutput.size());
    }

    @Test
    void searchByGenreFailure() {
        //act
        int expectedOutput=2;
        //arrange
        List<Song> actualOutput= songRepository.searchByGenre("Romance");
        //assert
        assertNotEquals(expectedOutput,actualOutput.size());
    }
}