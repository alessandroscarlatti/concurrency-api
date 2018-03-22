package com.scarlatti.taskLauncher;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Thursday, 3/22/2018
 */
public class ExecutorDemo {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Future future;
    private GreetingService greetingService;

    @Test
    public void executorDemo() {
        GuiTaskLauncher.gui()
            .withTask("Start", this::start)
            .withTask("Start and Timeout", this::startAndTimeout)
            .withTask("Stop", this::stop)
            .withTask("Cancel", this::cancel)
            .build().show();
    }

    private void start() {
        System.out.println("start");

        greetingService = new GreetingService(2000);

        future = executor.submit(this::run);

        try {
            future.get();
        } catch (Exception e) {
            System.err.println("User canceled");
            e.printStackTrace();
        }

        System.out.println("done");
    }

    private void startAndTimeout() {
        System.out.println("start");

        greetingService = new GreetingService(4000);

        future = executor.submit(this::run);

        try {
            future.get(3000, TimeUnit.MILLISECONDS);
        } catch (CancellationException e) {
            System.err.println("User Cancelled");
            e.printStackTrace();
        } catch (TimeoutException | InterruptedException e) {
            System.err.println("Timed out");
            future.cancel(true);
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("Execution Exception");
            e.printStackTrace();
        }

        System.out.println("done");
    }

    private void stop() {
        System.out.println("stop");
    }

    private void cancel() {
        System.out.println("cancel");
        future.cancel(true);
    }

    private void run() {
        String greeting = greetingService.greet("phil");
        System.out.println(greeting);
    }
}
