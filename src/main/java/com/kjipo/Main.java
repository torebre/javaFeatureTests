package com.kjipo;

public class Main {

    private static void launchThreadsTest() throws InterruptedException {
        var virtualThread = Thread.ofVirtual()
                .unstarted(() -> System.out.println(Thread.currentThread()));

        virtualThread.start();
        virtualThread.join();



    }


    public static void main(String[] args) throws InterruptedException {
        launchThreadsTest();
    }
}