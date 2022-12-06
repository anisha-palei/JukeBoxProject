CREATE DATABASE  IF NOT EXISTS `jukebox` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jukebox`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlist_id` int NOT NULL AUTO_INCREMENT,
  `playlist_name` varchar(30) DEFAULT NULL,
  `song_ids` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`playlist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'Shiv ji','3,8'),(2,'Party','1,2,3'),(3,'sad songs','5');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `song_id` int NOT NULL AUTO_INCREMENT,
  `song_name` varchar(50) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `genre_type` varchar(20) DEFAULT NULL,
  `album_name` varchar(30) DEFAULT NULL,
  `artist_name` varchar(30) DEFAULT NULL,
  `song_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,'Kesariya','01:28','Romance','Brahmastra','Arijit singh','src/main/resources/songs/Kesariya.wav'),(2,'Treat-You-Better','01:00','pop','Illuminate','Shawn Mendes','src/main/resources/songs/Treat-You-Better.wav'),(3,'Achyutam-Kesavam','01:40','devotional','Achyutam-Keshavam','Ankit Batra','src/main/resources/songs/Achyutam-Kesavam.wav'),(4,'Deva-Deva','02:00','Indian-Film-Pop','Brahmastra','Arjit Singh','src/main/resources/songs/Deva-Deva.wav'),(5,'Memory-Bring-Back','01:00','pop','Jordi','Maroon','src/main/resources/songs/Memory-Bring-Back-Maroon-5.wav'),(6,'Nacho','01:20','party','RRR','Vishal Mishra','src/main/resources/songs/Nacho.wav'),(7,'Nikkamma','01:15','party','Nikkamma','Javed Mohsin','src/main/resources/songs/Nikkamma.wav'),(8,'Sukh-Karta','03:00','devotional','Sukh-Karta','Amitabh Bachhan','src/main/resources/songs/Sukh-Karta-Dukh-Harta.wav');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-04 16:39:56
--Create database
create database jukebox;
--create query
create table jukebox.song(song_id int primary key not null auto_increment,song_name varchar(50),duration varchar(20),genre_type varchar(20),album_name varchar(30),artist_name varchar(30),song_path varchar(100));
create table jukebox.playlist(playlist_id int primary key not null auto_increment,playlist_name varchar(30), song_ids varchar(50));

--insert query
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Kesariya","01:28","Romance","Brahmastra","Arijit singh","src/main/resources/songs/Kesariya.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Treat-You-Better","01:00","pop","Illuminate","Shawn Mendes","src/main/resources/songs/Treat-You-Better.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Achyutam-Kesavam","01:40","devotional","Achyutam-Keshavam","Ankit Batra","src/main/resources/songs/Achyutam-Kesavam.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Deva-Deva","02:00","Indian-Film-Pop","Brahmastra","Arjit Singh","src/main/resources/songs/Deva-Deva.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Memory-Bring-Back","01:00","pop","Jordi","Maroon","src/main/resources/songs/Memory-Bring-Back-Maroon-5.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Nacho","01:20","party","RRR","Vishal Mishra","src/main/resources/songs/Nacho.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Nikkamma","01:15","party","Nikkamma","Javed Mohsin","src/main/resources/songs/Nikkamma.wav");
insert into jukebox.song(song_name,duration,genre_type,album_name,artist_name,song_path) values("Sukh-Karta","03:00","devotional","Sukh-Karta","Amitabh Bachhan","src/main/resources/songs/Sukh-Karta-Dukh-Harta.wav");


