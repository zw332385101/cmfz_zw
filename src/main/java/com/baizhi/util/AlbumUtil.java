package com.baizhi.util;


import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AlbumUtil {
/*
* 获取大小
* */
public static double Mp3size(String downPath,String name) {
    File file = new File(downPath+"/"+name);
    double size=0.0;
    try {
        MP3File f = (MP3File) AudioFileIO.read(file);
        MP3AudioHeader audioHeader = (MP3AudioHeader) f.getAudioHeader();
        size=audioHeader.getTrackLength()/60.00;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }


    /*
     * 获取的大小
     * */
    public static double LongTime(String downPath,String name){
        FileInputStream fis= null;
        double size=0.0;
        try{
            File f= new File(downPath+"/"+name);
            fis= new FileInputStream(f);
            size=fis.available()/1024.0/1024.0;
        }catch(Exception e){
            System.out.println(e);
        } finally{
            if (null!=fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    //logger.error(e);
                    System.out.println(e);
                }
            }
        }
        return size;
    }
}
