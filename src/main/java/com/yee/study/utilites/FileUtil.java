package com.yee.study.utilites;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Author: RogerYee
 */
public class FileUtil
{
    public static void main(String [] args){

        FileUtil.changeLastModifiedDate("/Users/RogerYee/Desktop/2",-20*24*60*60*1000);
    }

    public static void changeLastModifiedDate(String path, long delta){

        File file = new File(path);
        File[] files = file.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(int i=0;i<files.length;i++)
        {
            File temp = files[i];
            long newDate = temp.lastModified() + delta;
            System.out.println(temp.getName() + ": lastModified = " + sdf.format(temp.lastModified()) + ", new = " + sdf.format(newDate));

            temp.setLastModified(newDate);
        }

    }
}
