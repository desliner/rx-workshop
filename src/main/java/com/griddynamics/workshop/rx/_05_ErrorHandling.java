package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.Subscriber;

import static com.griddynamics.workshop.rx.Utils.*;

/**
 * @author Max Myslyvtsev
 * @since 11/23/15
 */
public class _05_ErrorHandling {

    public static void main(String[] args) {
        Observable<String> unhandled = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onStart();
                subscriber.onNext("item1");
                subscriber.onError(new Exception("Ooops!"));
            }
        });

        Observable<String> defaulted = unhandled.onErrorReturn(e -> "{default}");

        Observable<String> backup = Observable.just("backup1", "backup2");
        Observable<String> resumed = unhandled.onErrorResumeNext(backup);

        Observable<String> mapped = unhandled.onErrorResumeNext(e ->
                Observable.error(new Exception("Mapped: " + e.getMessage()))
        );

        print("unhandled", unhandled);
        print("defaulted", defaulted);
        print("resumed", resumed);
        print("mapped", mapped);
    }
}
