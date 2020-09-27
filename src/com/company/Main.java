package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final int DOWLOADERS_LIMIT = 3;
    private static final int DOWLOADS_LIMIT = 10;


    public static void main(String[] args) {
        Uploader uploader = new Uploader(500, 20);
        uploader.start();
        try {
            uploader.join();

            ExecutorService serivce = Executors.newFixedThreadPool(DOWLOADERS_LIMIT);
            List<Future<Downloader>> downloaders = new ArrayList<>();
            for (int i = 1; i <= DOWLOADS_LIMIT; i++) {

                Downloader downloader = new Downloader(new Semaphore(3, true), new CountDownLatch(10), 500, 100);
                Future d = serivce.submit(downloader);
                downloaders.add(d);

            }

            for (Future<Downloader> d : downloaders) {
                d.get();
            }

            serivce.shutdown();

            System.out.println(" Файл удален!!! ");

        } catch (InterruptedException | ExecutionException e) {

        }


    }
}