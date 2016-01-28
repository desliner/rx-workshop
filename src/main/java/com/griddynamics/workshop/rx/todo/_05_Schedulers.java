package com.griddynamics.workshop.rx.todo;

import com.griddynamics.workshop.rx.Utils;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Max Myslyvtsev
 * @since 9/23/15
 */
public class _05_Schedulers {

    public static void main(String[] args) throws Exception {

        // TODO: create an observable that:
        //  - prints incremental index of subscription when subscribed using log() method
        //  - emits "a", then does 1000ms pause, then emits "b", "c"
        Observable<String> o = null;

        // TODO: subscribe to observable 3 times and output all events with subscription index using log() method

        // TODO: apply different schedulers in subscribeOn and observeOn
    }

    private static void log(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("%-30s| %s", threadName, message));
    }
}
