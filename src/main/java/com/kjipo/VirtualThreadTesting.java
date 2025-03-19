package com.kjipo;


import java.util.Base64;
import java.util.Random;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.LongStream;

public final class VirtualThreadTesting {

    private record Task(long id, String title) {
        @Override
        public String toString() {
            return String.format("ID: %d. Title: %s", id, title);
        }
    }

    private static final Random randomizer = new Random();

    private static Task getRandomTask(long id) {
        var titleBytes = new byte[10];
        randomizer.nextBytes(titleBytes);
        return new Task(id, String.format("Task %s", Base64.getEncoder().encodeToString(titleBytes)));
    }


    private static void launchThreads() {
        try (var scope = new StructuredTaskScope<Task>()) {
            var tasks = LongStream.range(1, 100).boxed()
                    .map(id -> scope.fork(() -> VirtualThreadTesting.getRandomTask(id))).toList();
            scope.join();

            tasks.forEach(taskFuture -> {
                var task = taskFuture.get();
                System.out.println(task);
            });

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        launchThreads();

    }


}
