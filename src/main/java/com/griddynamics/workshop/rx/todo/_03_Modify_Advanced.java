package com.griddynamics.workshop.rx.todo;

import rx.Observable;

import static com.griddynamics.workshop.rx.Utils.print;

/**
 * @author Max Myslyvtsev
 * @since 1/27/16
 */
public class _03_Modify_Advanced {

    public static void main(String[] args) {

        Observable<Integer> o1 = null; // TODO: emit numbers from 1 to 5

        Observable<Integer> o2 = null; // TODO: modify o1 that even numbers are divided by 2, odd numbers are multiplied by 3

        Observable<Integer> o3 = null; // TODO: modify o2 to emit 1 after all even items in addition to existing items

        Observable<Integer> o4 = null; // TODO: modify o3 that all items after item 15 are discarded

        Observable<Integer> o5 = null; // TODO: emit number of items in o4


        print("o1", o1);
        print("o2", o2);
        print("o3", o3);
        print("o4", o4);
        print("o5", o5);
    }
}
