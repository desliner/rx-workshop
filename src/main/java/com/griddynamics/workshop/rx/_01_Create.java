package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * @author Max Myslyvtsev
 * @since 9/17/15
 */
public class _01_Create {

    public static void main(String[] args) {
        Observable<String> o = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                System.out.println("onSubscribe");
                subscriber.onStart();
                subscriber.onNext("a");
                subscriber.onNext("b");
                subscriber.onNext("c");
                subscriber.onCompleted();
            }
        });

        System.out.println("First: " + o.toBlocking().first());
        System.out.println("All: " + o.toList().toBlocking().single());

        o.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }
        });
    }
}
