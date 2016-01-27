package com.griddynamics.workshop.rx.todo;

import rx.Observable;
import rx.Subscriber;

/**
 * @author Max Myslyvtsev
 * @since 1/27/16
 */
public class _00_Sample {
    public static void main(String[] args) {
        Observable<String> o = createObservable();

        o.subscribe(System.out::println);
    }

    private static Observable<String> createObservable() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onStart();
                subscriber.onNext("It works!");
                subscriber.onCompleted();
            }
        });
    }
}
