package com.scarlatti.taskLauncher;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 3/16/2018
 */
public class GreetingService {

    private long sleepMs = 5000;

    public GreetingService() {
    }

    public GreetingService(long sleepMs) {
        this.sleepMs = sleepMs;
    }

    /**
     * This is a function that would take awhile
     * @param name
     * @return
     */
    public String greet(String name) {
        try {
            Thread.sleep(sleepMs);
            return "hello, " + name;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    public long getSleepMs() {
        return sleepMs;
    }

    public void setSleepMs(long sleepMs) {
        this.sleepMs = sleepMs;
    }
}
