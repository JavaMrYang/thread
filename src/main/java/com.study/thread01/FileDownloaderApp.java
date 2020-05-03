package com.study.thread01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author LiuYang
 * @Date 2020/5/3/003  10:51
 * @Version 1.0
 **/
public class FileDownloaderApp {

  public static void main(String[] args) {
    Thread downloaderThread=null;
    for (String url:args){
      downloaderThread=new Thread(new FileDownloader(url));

      downloaderThread.start();
    }

  }
  static class FileDownloader implements Runnable{
    private final String fileURL;

    FileDownloader(String fileURL) {
      this.fileURL = fileURL;
    }

    @Override
    public void run() {
      System.out.println("Downloading from "+fileURL);
      String fileBaseName=fileURL.substring(fileURL.lastIndexOf("/")+1);
      try {
        URL url=new URL(fileURL);
        String localFileName=System.getProperty("java.io.temdir")
        +"/viscent-"+fileBaseName;
        System.out.println("save to:"+localFileName);
        downloadFile(url,new FileOutputStream(localFileName),1024);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    private void downloadFile(URL url, OutputStream outputStream,int bufSize){

    }
  }
}
