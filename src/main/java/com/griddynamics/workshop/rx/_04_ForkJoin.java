package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @author Max Myslyvtsev
 * @since 9/25/15
 */
public class _04_ForkJoin {

    public static void main(String[] args) {
        Observable<String> starting = Observable.just("start");

        //starting = starting.subscribeOn(Schedulers.newThread());

        Observable<String> left = starting.map(s -> {
            System.out.println("Left executing on: " + Thread.currentThread().getName());
            Utils.sleep(1000);
            return s.substring(0, 1); // take first character
        });
        Observable<String> right = starting.map(s -> {
            System.out.println("Right executing on: " + Thread.currentThread().getName());
            Utils.sleep(2000);
            return s.substring(s.length() - 1, s.length()); // take last character
        });
        Observable<String> zipped = Observable.zip(left, right, (a, b) -> a + b);

        //zipped = zipped.subscribeOn(Schedulers.newThread());

        long time = System.currentTimeMillis();
        String result = zipped.toBlocking().single();
        time = System.currentTimeMillis() - time;

        System.out.println("Result: " + result);
        System.out.println("Time: " + time);
    }
}
