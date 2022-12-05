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
    public int play(String songPath) {

        File songFile = new File(songPath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            System.out.println("Enter \uu001B[34m1. Start\t\n\t  2. Stop\t\t\n\t  3. Pause\t\n\t  4. Back to Main Menu\uu001B[0m");
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
                        break;
                    }

                }
            }while (choice==1||choice==2||choice==3);
            if(choice>=4)
            {
                return 5;
            }


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception) {
            exception.printStackTrace();

        }
        return 0;
    }
}
