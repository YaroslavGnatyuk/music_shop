package ua.gnatyuk.yaroslav.music_shop.utils;

import it.sauronsoftware.ftp4j.*;
import it.sauronsoftware.ftp4j.connectors.DirectConnector;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by yaroslav on 20/05/16.
 */
public class FtpUpload implements Connection {
    private FTPClient client;
    private FTPConnector connector;
    private String host;
    private String port;
    private String username;
    private String password;

    public FtpUpload(String host,String port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;

        client = new FTPClient();
        connector = new DirectConnector();
        try {
            connector.connectForDataTransferChannel(host,Integer.parseInt(port));
            connector.setUseSuggestedAddressForDataConnections(true);
            connector.setConnectionTimeout(3000);
            connector.setReadTimeout(3000);

            client.setPassive(true);
            client.setConnector(connector);
            client.connect(host);
            client.login(username, password);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();
        } catch (FTPException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnect() {
        return client.isConnected();
    }

    @Override
    public String[] listOfDirectories() {
        try {
            return client.listNames();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();
        } catch (FTPException e) {
            e.printStackTrace();
        } catch (FTPDataTransferException e) {
            e.printStackTrace();
        } catch (FTPAbortedException e) {
            e.printStackTrace();
        } catch (FTPListParseException e) {
            e.printStackTrace();
        }

        return new String[0];
    }

    @Override
    public boolean changeDirectory(String pathToDirectory)
    {
        try {
            client.changeDirectory(pathToDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();
        } catch (FTPException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isFileExist(String file) {
        Set<String> fileSystem = new TreeSet<>();
        Collections.addAll(fileSystem,listOfDirectories());

        if (fileSystem.contains(file))
            return true;
        else
            return false;
    }

    @Override
    public boolean uploadFile(File file, String path) {
        try {
            if (!client.isConnected()) {
                System.out.println("Trying connect...");
                client.login(username, password);
                client.connect(host);
            }
            if(changeDirectory(path)){
                if(!isFileExist(file.getName())){
                    client.upload(file);
                }else{
                    System.out.println("The file already exist");
                    return false;
                }
            }else {
                System.out.println("The directory doesn't exist or something else");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();
            return false;
        } catch (FTPException e) {
            e.printStackTrace();
            return false;
        } catch (FTPDataTransferException e) {
            e.printStackTrace();
            return false;
        } catch (FTPAbortedException e) {
            e.printStackTrace();
            return false;
        }finally {
//            close(true);
        }
        return true;
    }

    @Override
    public void close(boolean close) {
        try {
            client.disconnect(close);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();
        } catch (FTPException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile(String path) {
        try {
            client.deleteFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();
        } catch (FTPException e) {
            e.printStackTrace();
        }
    }
}
