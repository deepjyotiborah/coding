package com.deep.concept;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable {

    @Override
    public Object call() throws Exception {

        Random random = new Random();
        Integer randomGenerator = random.nextInt(5);
        String thread = Thread.currentThread().getName();
        String result = String.valueOf(randomGenerator) + " " + thread;
        Thread.sleep(randomGenerator * 1000);
        return result;
    }
}

public class CallableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask[] futureTasks = new FutureTask[5];
        for(int i = 0; i < 5 ; i++) {
            Callable callableExample = new CallableExample();
            futureTasks[i] = new FutureTask(callableExample);
            Thread t = new Thread(futureTasks[i]);
            t.start();
        }

        Arrays.stream(futureTasks).forEach(futureTask -> {
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
