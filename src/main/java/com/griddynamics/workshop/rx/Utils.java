package com.griddynamics.workshop.rx;

/**
 * @author Max Myslyvtsev
 * @since 9/23/15
 */
public class Utils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
