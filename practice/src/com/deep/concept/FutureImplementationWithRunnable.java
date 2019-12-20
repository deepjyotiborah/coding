package com.deep.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FutureImplementationWithRunnable implements Runnable{

    // Shared object to store result
    private Object result = null;

    @Override
    public void run() {
        Random random = new Random();
        Integer randomInt = random.nextInt(5);
        try {
            Thread.sleep(randomInt * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = randomInt;

        // Wake up threads blocked on the get() method
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized Object get() throws InterruptedException {
            while (result == null)
                wait();
            return result;
    }

    public static void main(String[] args) throws InterruptedException {
        FutureImplementationWithRunnable[] runnableFuture = new FutureImplementationWithRunnable[5];
        for(int i = 0; i < 5 ; i ++) {
            runnableFuture[i] = new FutureImplementationWithRunnable();
            Thread t = new Thread(runnableFuture[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(runnableFuture[i].get());
        }
    }
}
