package com.deep.concept;

import com.sun.tools.javac.util.Assert;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureEx {

    private Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture completableFuture = new CompletableFuture();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            completableFuture.complete("Hello from " + name);
            return;
        });
        return completableFuture;
    }

    private Future<String> cancelAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture.cancel(false);
            return;
        });
        return completableFuture;
    }


    private void processResultOfAsyncProcessing() throws ExecutionException, InterruptedException {
        //thenApply() is the generic way to process the result of a computation.
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> getStr());
        CompletableFuture<String> future = completableFuture.thenApply(s -> s + " Finished");
        try {
            System.out.println("Post then apply result : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> future1 = completableFuture.thenApplyAsync(s -> s + getStr(" New String"));
        System.out.println("After thenApplyAsync result :  " + future1.get());
        //If you don't need to return a value then use thenAccept()
        completableFuture = CompletableFuture.supplyAsync(() -> getStr());
        CompletableFuture<Void> voidFuture = completableFuture.thenAccept(s -> System.out.println("Computation returned : " + s));
        System.out.println("Get void future result : " + voidFuture.get());

        //if you neither need the value of the computation nor want to return some value at the end of the chain then use thenRun()
        completableFuture = CompletableFuture.supplyAsync(() -> getStr());
        voidFuture = completableFuture.thenRun(() -> System.out.println("Processing finished"));
        System.out.println("Get result after thenRun() : " + voidFuture.get());
    }

    private void combiningFutures() throws ExecutionException, InterruptedException {

        System.out.println(" -- " + Thread.currentThread().getName());
        //thenCompose() -  method to chain two Futures sequentially.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getStr("hello"))
                                                    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + getStr(" world")));
        System.out.println("After thenCompose result : " + future.get());

        //If you want to execute two independent Futures and do something with their results, use the thenCombine method
        future = CompletableFuture.supplyAsync(() -> getStr("Hello")).thenCombine(
                CompletableFuture.supplyAsync(() -> getStr("World!!")), (s1, s2) -> s1 + " #### " + s2);

        System.out.println("After thenCombine result : " + future.get());
    }

    private void runMultipleFuture() throws ExecutionException, InterruptedException {

        //allOf() - wait for all of them to execute
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> getStr("Hello"));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> getStr("Beautiful "));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> getStr("World!!!"));

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
        System.out.println("After allOf result : " + combinedFuture.get());
        System.out.println("future1.isDone() : " + future1.isDone());
        System.out.println("future2.isDone() : " + future2.isDone());
        System.out.println("future3.isDone() : " + future3.isDone());
        String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println("Combined String : " + combined);
    }

    private String getStr() {
        return "Hello from " + Thread.currentThread().getName();
    }

    private String getStr(String str) {
        return str + " from " + Thread.currentThread().getName() +"\t";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureEx completableFutureEx = new CompletableFutureEx();
        Future<String> calculateAsync = completableFutureEx.calculateAsync();
        System.out.println("Main Thread - " + Thread.currentThread().getName());
        System.out.println(calculateAsync.get());
        Future<String> cancelAsync = completableFutureEx.cancelAsync();
        try {
            cancelAsync.get();
        } catch (CancellationException e) {
            System.out.println("Async processing cancelled.");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        completableFutureEx.processResultOfAsyncProcessing();
        completableFutureEx.combiningFutures();
        completableFutureEx.runMultipleFuture();

    }
}