package com.scarlatti.taskLauncher;

import org.junit.Test;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Tuesday, 3/20/2018
 */
public class GuiTaskLauncherTest {

    @Test
    public void runTaskLauncher() {
        GuiTaskLauncher.gui().withTask(() -> {
            System.out.println("hello");
        }).build().show();
    }
}
