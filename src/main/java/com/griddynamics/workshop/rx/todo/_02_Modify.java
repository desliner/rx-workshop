package com.griddynamics.workshop.rx.todo;

import rx.Observable;
import rx.Statement;
import rx.Subscriber;

import java.util.LinkedList;

import static com.griddynamics.workshop.rx.Utils.print;

/**
 * @author Max Myslyvtsev
 * @since 9/17/15
 */
public class _02_Modify {

    public static void main(String[] args) throws Exception {

        Observable<Integer> numbers = null; // TODO: emit numbers 1 to 10

        Observable<Integer> even = null; // TODO: filter even numbers

        Observable<Integer> odd = null; // TODO: filter odd numbers

        Observable<Integer> paired = null; // TODO: pair even and odd numbers adding them together (1st even + 1st odd, 2nd even + 2nd odd, etc)

        Observable<Integer> skipped = null; // TODO: skip first 2 items from paired

        Observable<Integer> appended = null; // TODO: append 42 to the end of skipped

        Observable<Integer> multiplied = null; // TODO: multiply each number from appended by 10

        Observable<Integer> digits = null; // TODO: transform multiplied observable of numbers to observable of their digits

        Observable<Integer> max = null; // TODO: find maximum digit

        Observable<Integer> sum = null; // TODO: sum all digits

        print("numbers", numbers);
        print("even", even);
        print("odd", odd);
        print("paired", paired);
        print("skipped", skipped);
        print("appended", appended);
        print("multiplied", multiplied);
        print("digits", digits);
        print("sum", sum);
        print("max", max);
    }
}
