package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.Subscriber;

import static com.griddynamics.workshop.rx.Utils.*;

/**
 * @author Max Myslyvtsev
 * @since 11/23/15
 */
public class _04_ErrorHandling {

    public static void main(String[] args) {
        Observable<String> unhandled = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onStart();
                subscriber.onNext("item1");
                subscriber.onError(new Exception("Ooops!"));
            }
        }); // TODO: create an observable that emits "item1" and then error with message "Oops"

        Observable<String> defaulted = unhandled.onErrorReturn(e -> "{default}"); // TODO: change unhandled observable to emit default item on error: "default"

        Observable<String> backup = Observable.just("backup1", "backup2"); // TODO: create backup observable that emits "backup1", "backup2"
        Observable<String> resumed = unhandled.onErrorResumeNext(backup); // TODO: change unhandled observable to emit items from backup observable on error

        Observable<String> mapped = unhandled.onErrorResumeNext(e ->
                Observable.error(new Exception("Mapped: " + e.getMessage()))
        ); // TODO: change unhandled observable to append " Mapped" suffix to exception message on error

        print("unhandled", unhandled);
        print("defaulted", defaulted);
        print("backup", backup);
        print("resumed", resumed);
        print("mapped", mapped);
    }
}
