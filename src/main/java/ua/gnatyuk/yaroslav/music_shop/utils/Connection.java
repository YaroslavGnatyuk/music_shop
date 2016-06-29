package ua.gnatyuk.yaroslav.music_shop.utils;

import java.io.File;

/**
 * Created by yaroslav on 20/05/16.
 */
public interface Connection {
     boolean isConnect();
     String[] listOfDirectories();
     boolean changeDirectory(String name);
     boolean isFileExist(String file);
     boolean uploadFile(File file, String path);
     void close(boolean close);
     void deleteFile(String path);
}
