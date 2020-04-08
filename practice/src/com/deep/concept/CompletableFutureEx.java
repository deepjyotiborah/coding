package com.deep.concept;

import java.util.concurrent.*;

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

    private void completableFutureThenApply() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> getStr());
        CompletableFuture<String> future = completableFuture.thenApply(s -> s + " Finished");
        try {
            System.out.println("Post then apply result : " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private String getStr() {
        return "Hello from " + Thread.currentThread().getName();
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

        completableFutureEx.completableFutureThenApply();
    }
}