package com.pack.javasnippet;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntTest {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start(); // this thread begins execution, run method will be calleed.
        t1.join(); // waits for this thread to die
        t2.join();
        
        // if you dont put t1.join or t2.join then count will be zero
        // as the main thread will run the below line immediately
        System.out.println("Processing count=" + pt.getCount());
    }

}

class ProcessingThread implements Runnable {
//    private int count;
	private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
//            count++;
            count.incrementAndGet();
        }
    }

    public int getCount() {
        return this.count.get();
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}