package com.griddynamics.workshop.rx;

import rx.Observable;

import java.util.List;

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

    public static <T> void print(String name, Observable<T> o) {
        if (o != null) {
            @SuppressWarnings("unchecked")
            List<T> list = o.onErrorReturn(e->(T)new Object(){
                @Override
                public String toString() {
                    return "Error: " + e.getMessage();
                }
            }).toList().toBlocking().single();
            System.out.println(String.format("%-12s %s ", name, list));
        }
    }
}
