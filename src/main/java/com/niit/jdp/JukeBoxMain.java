package com.niit.jdp;

import com.niit.jdp.exception.PlaylistEmptyException;
import com.niit.jdp.exception.UserWrongInputException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class JukeBoxMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[35m-------------Welcome To JUKEBOX--------------------\u001B[0m");
        try {
            SongRepository songRepository = new SongRepository();
            MusicPlayerService musicPlayerService = new MusicPlayerService();
            PlaylistRepository playlistRepository = new PlaylistRepository();
            while (true) {
                System.out.println("\nPlease choose any of the following option:");
                System.out.println("\u001B[32m1.Songs\n2.Playlist\n3.Exit\u001B[0m");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        int choice1 = 0;
                        while (choice1 != 6) {
                            try {
                                System.out.println("\nEnter a choice in Song Category :");
                                System.out.println("\u001B[32m\t1.Display Songs list.\n\t2.Search song by name.\n\t3.Search song by album.\n\t4.Search song by artist.\n\t5.Search song by genre.\n\t6.Main Menu.\n\t7.Exit\u001B[0m");
                                choice1 = scanner.nextInt();
                                switch (choice1) {
                                    case 1: {
                                        System.out.println("--------------------------------------------------\u001B[34m'DISPLAY SONGS'\u001B[0m---------------------------------------------------------------");
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        songRepository.displaySongs().forEach(System.out::println);
                                        System.out.println();
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        songRepository.displaySongs().forEach(System.out::println);
                                        System.out.println("Enter song name : ");
                                        scanner.nextLine();
                                        String songName = scanner.nextLine();
                                        System.out.println(songRepository.searchSongByName(songName));
                                        System.out.println();
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        songRepository.displaySongs().forEach(System.out::println);
                                        System.out.println("Enter album name : ");
                                        scanner.nextLine();
                                        String albumName = scanner.nextLine();
                                        List<Song> songs = songRepository.searchByAlbumName(albumName);
                                       songs.forEach(System.out::println);
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        songRepository.displaySongs().forEach(System.out::println);
                                        System.out.println("Enter artist name : ");
                                        scanner.nextLine();
                                        String artistName = scanner.nextLine();
                                        List<Song> songs = songRepository.searchByArtistName(artistName);
                                        songs.forEach(System.out::println);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        songRepository.displaySongs().forEach(System.out::println);
                                        System.out.println("Enter genre type : ");
                                        scanner.nextLine();
                                        String genreType = scanner.nextLine();
                                        List<Song> songs = songRepository.searchByGenre(genreType);
                                        songs.forEach(System.out::println);
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Back to main menu...");
                                        break;
                                    }
                                    case 7:
                                        System.out.println("\u001B[35mThank you\u001B[0m");
                                        System.exit(0);
                                    default:
                                        System.out.println("Wrong input");
                                }
                            } catch (UserWrongInputException e) {
                                throw new RuntimeException(e);
                            }
                            if (choice1 != 6) {
                                System.out.println("Enter:\uu001B[34m1.Continue to Song Category\n\t  2.Play\n\t  3.Main menu\n\t  0.Exit\u001B[0m");
                                int choice2 = scanner.nextInt();
                                if (choice2 == 3) {
                                    break;
                                } else if (choice2 == 2) {
                                    System.out.println("Enter Song Id ");
                                    int id = scanner.nextInt();
                                    String songPath = songRepository.getSongBySongId(id).getSongPath();
                                    musicPlayerService.play(songPath);
                                    break;

                                } else if (choice2 != 1) {
                                    System.exit(0);
                                }

                            }
                        }
                        break;
                    }
                    //playlist Option
                    case 2: {
                        int choice2 = 0;
                        while (choice2 != 5) {
                            try {
                                System.out.println("\nEnter a choice in playlist : ");
                                System.out.println("\uu001B[34m\t1.Create a new Playlist.\n\t2.Add song to a Playlist.\n\t3.Display and Play selected Playlist\n\t4.Display all Playlist\n\t5.Main Menu.\n\t6.Exit\u001B[0m");
                                choice2 = scanner.nextInt();
                                scanner.nextLine();
                                switch (choice2) {
                                    case 1: {
                                        System.out.println("-------------------'CREATE PLAYLIST'-------------------");
                                        System.out.println("Enter the Playlist Name  : ");
                                        String playlistName = scanner.nextLine();
                                        Playlist playlist = playlistRepository.createPlaylist(playlistName);
                                        System.out.println("Your playlist has been created with \u001B[32mid\u001B[0m : " + playlist.getPlaylistId() + "\t and \u001B[32mPlayList Name\u001B[0m : " + playlist.getPlaylistName());
                                        break;
                                    }
                                    case 2: {

                                        System.out.println("------------------'ADD SONG TO PLAYLIST' -------------------");
                                        System.out.println("\u001B[32mPlayList ids\t\t Playlist Names\u001B[0m");
                                        playlistRepository.displayAllPlaylist().forEach(System.out::println);
                                        System.out.println("Enter the playlist id to add songs to: ");
                                        int playlistId = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        songRepository.displaySongs().forEach(System.out::println);
                                        System.out.println("Enter the song ids to add to the playlist separated by comma: ");
                                        String songIds = scanner.nextLine();
                                        boolean songsAdded = playlistRepository.songAddToPlaylist(playlistId, songIds);
                                        if (songsAdded) {
                                            System.out.println("\n");
                                            System.out.println("\u001B[32mSongs has been added to the playlist successfully\u001B[0m");
                                            System.out.println("\n");
                                        } else {
                                            System.err.println("Something went wrong");
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println();
                                        System.out.println("----------------Play-------------------");
                                        System.out.println("\u001B[32mPlayList ids\t\t\tPlaylist Names\u001B[0m");
                                        System.out.println("------------------------------------------");
                                        playlistRepository.displayAllPlaylist().forEach(System.out::println);
                                        System.out.println("Enter the playlist id to get songs : ");
                                        int id = scanner.nextInt();
                                        System.out.println("\u001B[32mSongId\t\t Name\t\t\t\t Duration\t\t\t\tGenre\t\t\t\t\t\tArtist\t\t\t\t\tAlbum\u001B[0m");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                                        List<Song> songsFromPlaylist = playlistRepository.getSongIdsFromPlaylist(id);
                                        for (Song song : songsFromPlaylist) {
                                            for (Song song1 : songsFromPlaylist) {
                                                System.out.println(song1);
                                            }
                                            System.out.println("Enter song id");
                                            int ids = scanner.nextInt();
                                            choice2 = musicPlayerService.play(song.getSongPath());
                                            break;
                                        }
                                        break;
                                    }
                                    case 4: {
                                        System.out.println();
                                        System.out.println("------------------Display All the playlists------------------");
                                        System.out.println("\uu001B[34mPlayList ids\t\t\t Playlist Names\uu001B[0m");
                                        playlistRepository.displayAllPlaylist().forEach(System.out::println);
                                        System.out.println();
                                        break;
                                    }
                                    case 5: {
                                        System.out.println(" main menu...");
                                        break;
                                    }
                                    case 6: {

                                        System.out.println("\u001B[35mThank you\u001B[0m");
                                        System.exit(0);
                                        break;
                                    }
                                    default:
                                        System.out.println("Wrong input");
                                }
                            } catch (PlaylistEmptyException exception) {
                                System.err.println("songs are present ");
                            }
                            if (choice2 != 5) {
                                System.out.println("Enter:\uu001B[34m1.Continue to Playlist Category\n\t  2.Main menu\n\t  0.Exit\u001B[0m");
                                int choice3 = scanner.nextInt();
                                if (choice3 == 2) {
                                    break;
                                } else if (choice3 != 1) {
                                    System.out.println("\u001B[35mThank you\u001B[0m");
                                    System.exit(0);
                                }
                            }
                        }
                        break;
                    }
                    //3.Exit
                    case 3:
                        if (choice == 3) {
                            System.out.println("\u001B[35mThank you\u001B[0m");
                            System.exit(0);
                        }
                }

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}