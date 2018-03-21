package com.scarlatti;

/**
 * ______    __                         __           ____             __     __  __  _
 * ___/ _ | / /__ ___ ___ ___ ____  ___/ /______    / __/______ _____/ /__ _/ /_/ /_(_)
 * __/ __ |/ / -_|_-<(_-</ _ `/ _ \/ _  / __/ _ \  _\ \/ __/ _ `/ __/ / _ `/ __/ __/ /
 * /_/ |_/_/\__/___/___/\_,_/_//_/\_,_/_/  \___/ /___/\__/\_,_/_/ /_/\_,_/\__/\__/_/
 * Friday, 3/16/2018
 */
public class GreetingService {

    /**
     * This is a function that would take awhile
     * @param name
     * @return
     */
    public String greet(String name) {
        try {
            Thread.sleep(2000);

            // TODO throw an exception sometimes...
            return "hello, " + name;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
