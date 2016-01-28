package com.griddynamics.workshop.rx.todo;

import rx.Observable;
import rx.Subscriber;

import static com.griddynamics.workshop.rx.Utils.print;

/**
 * @author Max Myslyvtsev
 * @since 11/23/15
 */
public class _04_ErrorHandling {

    public static void main(String[] args) {

        Observable<String> unhandled = null; // TODO: create an observable that emits "item1" and then error with message "Oops"


        Observable<String> defaulted = null; // TODO: change unhandled observable to emit default item on error: "default"

        Observable<String> backup = null; // TODO: create backup observable that emits "backup1", "backup2"
        Observable<String> resumed = null; // TODO: change unhandled observable to emit items from backup observable on error

        Observable<String> mapped = null; // TODO: change unhandled observable to append " Mapped" suffix to exception message on error

        print("unhandled", unhandled);
        print("defaulted", defaulted);
        print("backup", backup);
        print("resumed", resumed);
        print("mapped", mapped);
    }
}
