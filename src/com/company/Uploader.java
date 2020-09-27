package com.company;

public class Uploader extends Thread {
    private int file;
    private int downloadSpeed;

    public Uploader(int file, int downloadSpeed) {
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
                System.out.println("Скорость скачивания: " + getDownloadSpeed() + " mb");
                System.out.println("Из: " + getFile() + " mb " + "- скачалось: " + (getDownloadSpeed() + i) + "mb");
                Thread.sleep(1000);

            }
            System.out.println("Загрузка завершена ");
            System.out.println("_______________________________________________");
        } catch (InterruptedException e) {


        }

    }
}