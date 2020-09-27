package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    private int file;
    private int downloadSpeed;

    public Downloader(Semaphore semaphore, CountDownLatch countDownLatch, int file, int downloadSpeed) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.file = file;
        this.downloadSpeed = downloadSpeed;
    }

    public int getFile() {
        return file;
    }

    public int getDownloadSpeed() {
        return downloadSpeed;
    }

    public void run() {
        try {
            System.out.println("Файл скачивается");
            for (int i = 0; i < getFile(); i += getDownloadSpeed()) {
                Thread.sleep(1000);

            }
            System.out.println(" Загрк=узка щавершена ");

        } catch (InterruptedException e) {

        }

    }
}