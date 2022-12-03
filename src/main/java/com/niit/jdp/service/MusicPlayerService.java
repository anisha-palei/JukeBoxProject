/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayerService {
    Scanner scanner=new Scanner(System.in);
    public void play(String songPath) {

        File songFile = new File(songPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            System.out.println("Enter 1. Start\t\n\t2.stop \t\n\t3.pause\t\n\t4.Back to Main Menu");
            int choice=0;

            do {
                choice=scanner.nextInt();
                switch (choice) {
                    case 1: {
                        clip.start();
                        break;
                    }
                    case 2: {
                        clip.stop();
                        clip.close();
                        break;
                    }
                    case 3 :
                    {
                        if(clip!=null)
                        {
                            clip.stop();
                            break;
                        }

                    }
                    default: {
                        System.out.println("");
                    }

                }
            }while (choice==1||choice==2||choice==3);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();
        }
    }
}
