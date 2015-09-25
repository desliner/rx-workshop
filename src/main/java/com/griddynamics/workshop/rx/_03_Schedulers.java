package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Max Myslyvtsev
 * @since 9/23/15
 */
public class _03_Schedulers {

    public static void main(String[] args) throws Exception {
        AtomicInteger subscriptionId = new AtomicInteger(0);
        Observable<String> o = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                log("onSubscribe: " + subscriptionId.incrementAndGet());
                subscriber.onStart();
                subscriber.onNext("a");
                Utils.sleep(1000);
                subscriber.onNext("b");
                subscriber.onNext("c");
                subscriber.onCompleted();
            }
        });

        //o = o.subscribeOn(Schedulers.io());
        //o = o.observeOn(Schedulers.newThread());

        for (int i = 1; i <= 3; i++) {
            final int id = i;
            o.subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    log(String.format("Subscription #%d: onCompleted", id));
                }

                @Override
                public void onError(Throwable e) {
                    log(String.format("Subscription #%d: onError: %s", id, e));
                }

                @Override
                public void onNext(String s) {
                    log(String.format("Subscription #%d: onNext: %s", id, s));
                }
            });
        }
        Utils.sleep(5000);
    }

    private static void log(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.println(String.format("%-30s| %s", threadName, message));
    }
}
