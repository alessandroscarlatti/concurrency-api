package com.scarlatti.taskLauncher;

import java.util.ArrayList;
import java.util.List;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 3/20/2018
 */
public class TaskLauncherBuilder {
    private List<Task> tasks;

    TaskLauncherBuilder() {
        tasks = new ArrayList<>();
    }

    public TaskLauncherBuilder withTask(Runnable task) {
        tasks.add(new Task(task, task.getClass().getSimpleName()));
        return this;
    }

    public TaskLauncherBuilder withTask(String name, Runnable task) {
        tasks.add(new Task(task, name));
        return this;
    }

    public GuiTaskLauncher build() {
       return new GuiTaskLauncher(this);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
