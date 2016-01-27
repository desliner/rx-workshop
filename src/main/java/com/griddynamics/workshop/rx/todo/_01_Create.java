package com.griddynamics.workshop.rx.todo;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

/**
 * @author Max Myslyvtsev
 * @since 9/17/15
 */
public class _01_Create {

    public static void main(String[] args) {
        Observable<String> o = createObservable();

        // TODO: print first item of o
        // TODO: print all items of o

        // TODO: subscribe and print individual events
    }



    private static Observable<String> createObservable() {
        // TODO: 1) just the item "item"

        // TODO: 2) emit items from the list
        // List<String> list = Arrays.asList("listItem1", "listItem2");

        // TODO: 3) emit error with message "Oops"

        // TODO: 4) emit items "a","b","c" using Observable.create

        return null;
    }
}
