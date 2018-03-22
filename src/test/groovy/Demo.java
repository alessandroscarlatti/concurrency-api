import com.scarlatti.taskLauncher.GuiTaskLauncher;
import org.junit.Test;

import java.awt.*;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Saturday, 2/24/2018
 */
public class Demo {

    /**
     * We want to be able to simply call the function
     * that we ultimately want to execute.
     *
     * We want to be able to wait for the function to return.
     *
     * We also want to be able to cancel the function somehow
     * during its execution.
     *
     * We want to receive back an exception if the function
     * throws the exception.
     */

    @Test
    public void runTimeoutFunction() {
        GuiTaskLauncher.gui()
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .withTask("Do Something", this::doSomething)
            .build().show();
    }

    public void doSomething() {
        System.out.println("do something");
    }
}
