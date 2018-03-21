package com.scarlatti.taskLauncher;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 3/20/2018
 */
public class Task {
    private Runnable runnable;
    private String name;

    public Task(Runnable runnable) {
        this.runnable = runnable;
    }

    public Task(Runnable runnable, String name) {
        this.runnable = runnable;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
            "runnable=" + runnable +
            ", name='" + name + '\'' +
            '}';
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
